/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game;

import actionFactory.ActionFactory;
import characters.Player;
import characters.GameCharacter;
import components.Results;
import actions.*;
import components.Items;

import java.util.ArrayList;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс, управляющий логикой боевой системы игры. Отвечает за:
 * <ul>
 *   <li>Проведение боевых раундов между игроком и противником</li>
 *   <li>Обработку действий (атака, защита, дебафф, лечение)</li>
 *   <li>Управление системой опыта и уровней</li>
 *   <li>Инвентарь и использование предметов</li>
 *   <li>Искусственный интеллект противника</li>
 *   <li>Обработку окончания боя и переход между локациями</li>
 * </ul>
 * 
 * Реализует сложную логику выбора действий противника на основе истории действий игрока,
 * систему прокачки персонажа и адаптацию сложности противников под уровень игрока.
 * 
 * @author Yulov
 */
public class Fight {
    /** Контроллер для взаимодействия с графическим интерфейсом */
    Controller controller;
    /** Игровой персонаж, управляемый пользователем */
    Player player;
    /** Противник в текущем бою */
    GameCharacter enemy;

    /** Локация, содержащая информацию о текущем уровне и противниках */
    public Location location = new Location();
    
    /** Список доступных боевых действий */
    public ArrayList<Action> actionsList = new ArrayList<>() {
        {
            add(new Hit());
            add(new Defense());
            add(new Debuff());
            add(new Heal());
        }
    };
    
    /** История последних действий игрока для анализа ИИ */
    private final Deque<String> playerActionHistory = new ArrayDeque<>();
    /** Максимальный размер истории действий игрока */
    private static final int HISTORY_SIZE = 3;
    /** Опыт, необходимый для достижения каждого уровня */
    private final int[] experienceForNextLevel = {40, 90, 180, 260, 410, 1000};

    /**
     * Устанавливает контроллер для взаимодействия с графическим интерфейсом
     * @param controller экземпляр контроллера игры
     */
    public void setController(Controller controller) {
        this.controller = controller;
    }

    /**
     * Регистрирует игрока для текущего боя
     * @param player экземпляр игрока
     */
    public void setHuman(Player player) {
        this.player = player;
    }

    /**
     * Устанавливает текущего противника
     * @param enemy экземпляр противника
     */
    public void setEnemy(GameCharacter enemy) {
        this.enemy = enemy;
    }

    /**
     * Возвращает игрока, участвующего в бою
     * @return экземпляр игрока
     */
    public Player getHuman() {
        return this.player;
    }

    /**
     * Возвращает текущего противника
     * @return экземпляр противника
     */
    public GameCharacter getEnemy() {
        return this.enemy;
    }

    /**
     * Выполняет ход игрока с учетом выбранного действия и действия противника
     * @param enemyAction действие, выбранное противником
     * @param playerAction действие, выбранное игроком
     */
    public void playerMove(Action enemyAction, Action playerAction) {
        controller.setActionLabels(enemy, player, enemyAction, playerAction);
        playerAction.realization(player, enemy, enemyAction.getType());
    }

    /**
     * Выполняет ход противника с учетом выбранного действия и действия игрока
     * @param enemyAction действие, выбранное противником
     * @param playerAction действие, выбранное игроком
     */
    public void enemyMove(Action enemyAction, Action playerAction) {
        controller.setActionLabels(player, enemy, enemyAction, playerAction);
        playerAction.realization(enemy, player, enemyAction.getType());
    }

    /**
     * Проверяет и обновляет статусы дебаффов для игрока и противника.
     * Уменьшает длительность эффектов и обновляет графическое отображение.
     */
    public void checkDebuff() {
        if (!enemy.hasBonusDamage()) {
            controller.setDebuffLabel(enemy, false);
        }
        if (enemy.hasBonusDamage()) {
            controller.setDebuffLabel(enemy, true);
            enemy.loseBonusDamageTurn();
        }
        if (!player.hasBonusDamage()) {
            controller.setDebuffLabel(player, false);
        }
        if (player.hasBonusDamage()) {
            controller.setDebuffLabel(enemy, true);
            player.loseBonusDamageTurn();
        }
    }

    /**
     * Основной метод выполнения боевого раунда. Включает:
     * <ol>
     *   <li>Выбор действий игроком и противником</li>
     *   <li>Применение эффектов действий</li>
     *   <li>Обновление состояния игры</li>
     *   <li>Проверку условий смерти</li>
     * </ol>
     * 
     * @param actionFactory фабрика для создания действий игрока
     * @param gameResults список результатов игры для записи
     * @param locationsNumber номер текущей локации
     * @param enemiesList список всех противников в игре
     */
    public void hit(ActionFactory actionFactory, ArrayList<Results> gameResults, int locationsNumber, GameCharacter[] enemiesList) {
        Action playerAction = actionFactory.createAction();

        Action enemyAction = chooseEnemyAction(enemy, new ArrayList<>(actionsList), getPlayerActionHistory());
        // Логируем действие игрока
        logPlayerAction(playerAction.getType());
        
        playerAction.realization(player, enemy, enemyAction.getType());
        controller.setActionLabels(enemy, player, enemyAction, playerAction);
    
        if (enemy.getHealth() > 0) {
            enemyAction.realization(enemy, player, playerAction.getType());
            controller.setActionLabels(player, enemy, enemyAction, playerAction);
        }
        updateGameState();
        checkDeath(gameResults, locationsNumber, enemiesList);
    }
    
    /**
     * Обновляет состояние игрового интерфейса после хода
     */
    private void updateGameState() {
        controller.setRoundTexts(player, enemy);
        checkDebuff();
        controller.setHealthBar(player);
        controller.setHealthBar(enemy);
    }
    
    /**
     * Проверяет условия смерти игрока или противника и инициирует
     * соответствующие процедуры окончания раунда
     * 
     * @param gameResults список результатов игры
     * @param locationsNumber номер текущей локации
     * @param enemiesList список всех противников
     */
    public void checkDeath(ArrayList<Results> gameResults, int locationsNumber, GameCharacter[] enemiesList) {
        if (player.getHealth() <= 0 & player.getItems()[2].getCount() > 0) {
            player.setHealth((int) (player.getMaxHealth() * 0.05));
            player.getItems()[2].setCount(-1);
            controller.setHealthBar(player);
            controller.revive(player, player.getItems());
        }
        if (player.getHealth() <= 0 | enemy.getHealth() <= 0) {
            if (location.getCurrentLocation() == locationsNumber & "Shao Kahn".equals(enemy.getName())) {
                location.resetLocation(false, 1);
                endFinalRound(gameResults, enemiesList);
            } else {
                endRound(enemiesList);
            }
        }
    }

    /**
     * Обрабатывает завершение обычного раунда (не финального)
     * @param enemiesList список всех противников в игре
     */
    public void endRound(GameCharacter[] enemiesList) {
        controller.makeEndFightDialogVisible();
        if (player.getHealth() > 0) {
            controller.setRoundEndText("You win");
            if (enemy.getName().equals("Shao Kahn")) {
                addItems(38, 23, 8, player.getItems());
                addPointsBoss(player);
                location.resetLocation(true, player.getLevel());
            } else {
                addItems(25, 15, 5, player.getItems());
                addPoints(player);
            }
        } else {
            reset(enemiesList);
            controller.setRoundEndText(enemy.getName() + " win");
        }
    }

    /**
     * Сбрасывает состояние игры к начальным значениям:
     * <ul>
     *   <li>Восстанавливает здоровье и урон игрока</li>
     *   <li>Сбрасывает уровень и опыт игрока</li>
     *   <li>Восстанавливает противников</li>
     *   <li>Сбрасывает локацию</li>
     * </ul>
     * 
     * @param enemiesList список всех противников
     */
    public void reset(GameCharacter[] enemiesList) {
        player.setDamage(16);
        player.setHealth(80);
        player.setMaxHealth(80);
        resetEnemies(enemiesList);
        player.setLevel(0);
        player.resetPoints();
        player.resetExperience();
        player.setNextExperience(40);
        location.setFullEnemiesList(enemiesList);
        location.resetLocation(false, player.getLevel());
    }

    /**
     * Обрабатывает завершение финального раунда игры
     * @param gameResults список результатов для записи
     * @param enemiesList список всех противников
     */
    public void endFinalRound(ArrayList<Results> gameResults, GameCharacter[] enemiesList) {
        resetEnemies(enemiesList);
        String text = "Победа не на вашей стороне";
        if (player.getHealth() > 0) {
            addPoints(player);
            text = "Победа на вашей стороне";
        }
        boolean top = false;
        if (gameResults == null) {
            top = true;
        } else {
            int a = 0;
            for (Results results : gameResults) {
                if (player.getPoints() < results.getPoints()) {
                    a++;
                }
            }
            if (a < 10) {
                top = true;
            }
        }
        controller.gameEnding(text, top);
    }

    /**
     * Начинает новый раунд боя:
     * <ul>
     *   <li>Восстанавливает здоровье участников</li>
     *   <li>Обновляет графические компоненты здоровья</li>
     * </ul>
     */
    public void newRound() {
        controller.setPlayerMaxHealthBar(player);
        controller.setEnemyMaxHealthBar(enemy);
        player.setHealth(player.getMaxHealth());
        enemy.setHealth(enemy.getMaxHealth());
        controller.setHealthBar(player);
        controller.setHealthBar(enemy);
    }
    
    /**
     * Добавляет действие игрока в историю для анализа ИИ противника
     * @param action тип выполненного действия ("Hit", "Block", и т.д.)
     */
    public void logPlayerAction(String action) {
        if (playerActionHistory.size() >= HISTORY_SIZE) {
            playerActionHistory.removeFirst();
        }
        playerActionHistory.addLast(action);
    }
    
    /**
     * Возвращает историю последних действий игрока
     * @return список действий (размер определяется HISTORY_SIZE)
     */
    public List<String> getPlayerActionHistory() {
        return new ArrayList<>(playerActionHistory);
    }

    /**
     * Выбирает действие для противника на основе:
     * <ul>
     *   <li>Имени противника (разные персонажи имеют разные стили боя)</li>
     *   <li>Истории последних действий игрока</li>
     *   <li>Вероятностных весов для каждого типа действия</li>
     * </ul>
     * 
     * @param enemy текущий противник
     * @param actions список доступных действий
     * @param playerHistory история действий игрока
     * @return выбранное действие для противника
     */
    public Action chooseEnemyAction(GameCharacter enemy, List<Action> actions, List<String> playerHistory) {
        Map<String, Double> actionWeights = new HashMap<>();
        switch (enemy.getName()) {
            case "Sub Zero" -> {
                actionWeights.put("Hit", 0.4);
                actionWeights.put("Block", 0.3);
                actionWeights.put("Debuff", 0.3);
            }
            case "Shao Kahn" -> {
                actionWeights.put("Hit", 0.5);
                actionWeights.put("Block", 0.3);
                actionWeights.put("Heal", 0.2);
            }
            case "Liu Kang" -> {
                actionWeights.put("Hit", 0.5);
                actionWeights.put("Counter", 0.5);
            }
            default -> {
                actionWeights.put("Hit", 0.7);
                actionWeights.put("Block", 0.3);
            }
        }

        adjustWeightsByPlayerActions(actionWeights, playerHistory);

        return selectWeightedAction(actions, actionWeights);
    }
    
    /**
     * Адаптирует вероятности выбора действия врагом в зависимости от частоты действий игрока.
     * @param weights карта весов действий
     * @param playerHistory история действий игрока
     */
    private void adjustWeightsByPlayerActions(Map<String, Double> weights, List<String> playerHistory) {
        long playerHits = playerHistory.stream().filter(a -> a.equals("Hit")).count();
        long playerBlocks = playerHistory.stream().filter(a -> a.equals("Block")).count();

        if (playerHits > HISTORY_SIZE / 2) {
            weights.put("Block", weights.getOrDefault("Block", 0.0) * 1.5);
            weights.put("Counter", weights.getOrDefault("Counter", 0.0) * 1.3);
        }

        if (playerBlocks > HISTORY_SIZE / 2) {
            weights.put("Debuff", weights.getOrDefault("Debuff", 0.0) * 1.4);
            weights.put("Hit", weights.get("Hit") * 0.8);
        }

        normalizeWeights(weights);
    }
    
    /**
     * Нормализует веса вероятностей, чтобы сумма была равна 1.
     * @param weights карта с весами
     */
    private void normalizeWeights(Map<String, Double> weights) {
        double totalWeight = weights.values().stream()
            .mapToDouble(Double::doubleValue)
            .sum();

        if (totalWeight > 0) {
            weights.replaceAll((action, weight) -> weight / totalWeight);
        } 
        else {
            double defaultWeight = 1.0 / weights.size();
            weights.replaceAll((action, weight) -> defaultWeight);
        }
    }
    
    /**
     * Случайно выбирает действие на основе взвешенных вероятностей.
     * @param actions список доступных действий
     * @param weights веса вероятностей для каждого действия
     * @return выбранное действие
     */
    private Action selectWeightedAction(List<Action> actions, Map<String, Double> weights) {
        double total = weights.values().stream().mapToDouble(Double::doubleValue).sum();
        double random = Math.random() * total;

        double current = 0;
        for (Action action : actions) {
            current += weights.getOrDefault(action.getType(), 0.0);
            if (random <= current) {
                return action;
            }
        }
        return actions.get(actions.size() - 2);
    }

    /**
     * Начисляет очки игроку за победу в обычном раунде
     * @param player экземпляр игрока
     */
    public void addPoints(Player player) {
        player.setExperience(20 + 5 * player.getLevel());
        player.setPoints(20 + 5 * player.getLevel() + player.getHealth() / 4);
    }

    /**
     * Проверяет, достаточно ли опыта для повышения уровня
     * @param player экземпляр игрока
     * @return true если игрок может повысить уровень, иначе false
     */
    public boolean checkExperience(Player player) {
        return player.getExperience() >= player.getNextExperience();
    }

    /**
     * Повышает уровень игрока и усиливает противников:
     * <ul>
     *   <li>Увеличивает уровень игрока</li>
     *   <li>Устанавливает порог опыта для следующего уровня</li>
     *   <li>Усиливает здоровье и урон противников</li>
     * </ul>
     * 
     * @param player экземпляр игрока
     * @param enemies список всех противников
     */
    public void levelUp(Player player, GameCharacter[] enemies) {
        player.addLevel();
        int i = 0;
        while (player.getNextExperience() >= experienceForNextLevel[i]) {
            i = i + 1;
        }
        player.setNextExperience(experienceForNextLevel[i]);
        for (int j = 0; j < 5; j++) {
            newHealthEnemy(enemies[j], player);
        }
    }

    /**
     * Начисляет очки игроку за победу над боссом
     * @param player экземпляр игрока
     */
    public void addPointsBoss(Player player) {
        player.setExperience(50);
        player.setPoints(65 + player.getHealth() / 2);
    }

    /**
     * Добавляет случайные предметы в инвентарь игрока после победы
     * @param k1 вероятность получения предмета 1 (0-100)
     * @param k2 вероятность получения предмета 2 (0-100)
     * @param k3 вероятность получения предмета 3 (0-100)
     * @param items массив предметов игрока
     */
    public void addItems(int k1, int k2, int k3, Items[] items) {
        double i = Math.random();
        if (i < k1 * 0.01) {
            items[0].setCount(1);
        }
        if (i >= k1 * 0.01 & i < (k1 + k2) * 0.01) {
            items[1].setCount(1);
        }
        if (i >= (k1 + k2) * 0.01 & i < (k1 + k2 + k3) * 0.01) {
            items[2].setCount(1);
        }
    }

    /**
     * Увеличивает максимальное здоровье игрока при повышении уровня
     * @param player экземпляр игрока
     */
    public void addHealthToPlayer(Player player) {
        player.addMaxHealth(40 + 5 * player.getLevel());
    }

    /**
     * Увеличивает урон игрока при повышении уровня
     * @param player экземпляр игрока
     */
    public void addDamageToPlayer(Player player) {
        player.addDamage(5 + player.getLevel());
    }

    /**
     * Усиливает противника в соответствии с уровнем игрока
     * @param enemy экземпляр противника
     * @param player экземпляр игрока
     */
    public void newHealthEnemy(GameCharacter enemy, Player player) {
        enemy.addMaxHealth(enemy.getMaxHealth() * (35 - 3 * player.getLevel()) / 100);
        enemy.addDamage(enemy.getDamage() * (20 + player.getLevel()) / 100);
        enemy.addLevel();
    }

    /**
     * Использует предмет из инвентаря игрока
     * @param human персонаж, использующий предмет (игрок)
     * @param items массив предметов в инвентаре
     * @param name название используемого предмета
     * @param controller контроллер для взаимодействия с GUI
     */
    public void useItem(GameCharacter human, Items[] items, String name, Controller controller) {
        switch (name) {
            case "First item" -> {
                if (items[0].getCount() > 0) {
                    human.addHealth((int) (human.getMaxHealth() * 0.25));
                    items[0].setCount(-1);
                } else {
                    controller.openCantUseItemDialog();
                }
            }
            case "Second item" -> {
                if (items[1].getCount() > 0) {
                    human.addHealth((int) (human.getMaxHealth() * 0.5));
                    items[1].setCount(-1);
                } else {
                    controller.openCantUseItemDialog();
                }
            }
            case "Third item" -> controller.openCantUseItemDialog();
        }
    }

    /**
     * Сбрасывает параметры всех противников к начальным значениям
     * @param enemiesList список всех противников в игре
     */
    public void resetEnemies(GameCharacter[] enemiesList) {
        for (GameCharacter enemy : enemiesList) {
            enemy.setLevel(1);
            switch (enemy.getName()) {
                case "Sub Zero" -> {
                    enemy.setDamage(16);
                    enemy.setMaxHealth(60);
                }
                case "Sonya Blade" -> {
                    enemy.setDamage(16);
                    enemy.setMaxHealth(80);
                }
                case "Shao Kahn" -> {
                    enemy.setDamage(30);
                    enemy.setMaxHealth(100);
                }
                case "Liu Kang" -> {
                    enemy.setDamage(20);
                    enemy.setMaxHealth(70);
                }
                case "Baraka" -> {
                    enemy.setDamage(12);
                    enemy.setMaxHealth(100);
                }
            }
        }
    }
}