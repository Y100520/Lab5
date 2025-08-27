/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game;

import actionFactory.ActionFactory;
import actionFactory.DefenseFactory;
import actionFactory.HitFactory;
import actionFactory.WeakenFactory;
import characters.Player;
import characters.GameCharacter;
import components.Results;
import actions.*;
import components.Items;

import java.util.ArrayList;
import java.util.Random;

public class Fight {
    Controller controller;
    Player player;
    GameCharacter enemy;

    public Location location = new Location();

    private final Random random = new Random();

    public ArrayList<Action> actionsList = new ArrayList<>() {
        {
            add(new HitAction());
            add(new Defense());
            add(new WeakenAction());
            add(new RegenerateAction());
        }
    };

    private final int[] experienceForNextLevel = {40, 90, 180, 260, 410, 1000};

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void setHuman(Player player) {
        this.player = player;
    }

    public void setEnemy(GameCharacter enemy) {
        this.enemy = enemy;
    }

    public Player getHuman() {
        return this.player;
    }

    public GameCharacter getEnemy() {
        return this.enemy;
    }

    public void turn(ActionFactory playerActionFactory, ArrayList<Results> gameResults, int locationsNumber, GameCharacter[] enemiesList) {
        Action playerAction = playerActionFactory.createAction();
        Action enemyAction = chooseEnemyAction();

        controller.setActionLabels(enemy, player, playerAction, enemyAction);

        playerAction.realization(player, enemy, enemyAction.getType());

        if (enemy.getHealth() > 0) {
            enemyAction.realization(enemy, player, playerAction.getType());
        }

        updateGameState();
        checkDeath(gameResults, locationsNumber, enemiesList);
    }

    private void updateGameState() {
        controller.setRoundTexts(player, enemy);
        checkDebuffs();
        controller.setHealthBar(player);
        controller.setHealthBar(enemy);
    }

    public void checkDebuffs() {
        player.countdownWeakenTurns();
        enemy.countdownWeakenTurns();
        controller.setDebuffLabel(player, player.isWeakened());
        controller.setDebuffLabel(enemy, enemy.isWeakened());
    }

    public Action chooseEnemyAction() {
        if ("Shao Kahn".equals(enemy.getName())) {
            if (enemy.getHealth() < enemy.getMaxHealth() / 2 && random.nextDouble() < 0.4) {
                return new RegenerateAction();
            }
        }

        if ("Sub Zero".equals(enemy.getName())) {
            if (random.nextDouble() < 0.3) {
                return new WeakenAction();
            }
        }

        if (random.nextDouble() < 0.7) {
            return new HitAction();
        } else {
            return new Defense();
        }
    }

    public void checkDeath(ArrayList<Results> gameResults, int locationsNumber, GameCharacter[] enemiesList) {
        if (player.getHealth() <= 0 && player.getItems()[2].getCount() > 0) {
            player.setHealth((int) (player.getMaxHealth() * 0.05));
            player.getItems()[2].setCount(-1);
            controller.setHealthBar(player);
            controller.revive(player, player.getItems());
        }

        boolean isFinalBossDefeated = "Shao Kahn".equals(enemy.getName()) && enemy.getHealth() <= 0;
        boolean isLastLocation = location.getCurrentLocation() == locationsNumber;

        if (player.getHealth() <= 0 || enemy.getHealth() <= 0) {
            if (isLastLocation && isFinalBossDefeated) {
                location.resetLocation(false, 1);
                endFinalRound(gameResults, enemiesList);
            } else {
                endRound(enemiesList);
            }
        }
    }

    public void endRound(GameCharacter[] enemiesList) {
        controller.makeEndFightDialogVisible();
        if (player.getHealth() > 0) {
            controller.setRoundEndText("Ты выиграл");
            if ("Shao Kahn".equals(enemy.getName())) {
                addItems(38, 23, 8, player.getItems());
                addPointsBoss(player);
            } else {
                addItems(25, 15, 5, player.getItems());
                addPoints(player);
            }
        } else {
            reset(enemiesList);
            controller.setRoundEndText(enemy.getName() + " выиграл");
        }
    }

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

    public void endFinalRound(ArrayList<Results> gameResults, GameCharacter[] enemiesList) {
        resetEnemies(enemiesList);
        String text = "Победа не на вашей стороне";
        if (player.getHealth() > 0) {
            addPointsBoss(player);
            text = "Победа на вашей стороне";
        }

        boolean isTopPlayer = false;
        if (gameResults.isEmpty() || gameResults.size() < 10) {
            isTopPlayer = true;
        } else {
            if (player.getPoints() > gameResults.get(9).getPoints()) {
                isTopPlayer = true;
            }
        }
        controller.gameEnding(text, isTopPlayer);
    }

    public void newRound() {
        controller.setPlayerMaxHealthBar(player);
        controller.setEnemyMaxHealthBar(enemy);
        player.setHealth(player.getMaxHealth());
        enemy.setHealth(enemy.getMaxHealth());

        player.resetDamageTakenThisFight();
        enemy.resetDamageTakenThisFight();

        controller.setHealthBar(player);
        controller.setHealthBar(enemy);
    }

    public void addPoints(Player player) {
        player.setExperience(20 + 5 * player.getLevel());
        player.setPoints(20 + 5 * player.getLevel() + player.getHealth() / 4);
    }

    public boolean checkExperience(Player player) {
        return player.getExperience() >= player.getNextExperience();
    }

    public void levelUp(Player player) {
        player.addLevel();
        int currentLevel = player.getLevel();
        if (currentLevel < experienceForNextLevel.length) {
            player.setNextExperience(experienceForNextLevel[currentLevel]);
        } else {
            player.setNextExperience(9999);
        }
    }

    public void addPointsBoss(Player player) {
        player.setExperience(50 + 10 * player.getLevel());
        player.setPoints(65 + player.getHealth() / 2);
    }

    public void addItems(int k1, int k2, int k3, Items[] items) {
        double i = Math.random();
        if (i < k1 * 0.01) {
            items[0].setCount(1);
        } else if (i < (k1 + k2) * 0.01) {
            items[1].setCount(1);
        } else if (i < (k1 + k2 + k3) * 0.01) {
            items[2].setCount(1);
        }
    }

    public void addHealthToPlayer(Player player) {
        player.addMaxHealth(20);
    }

    public void addDamageToPlayer(Player player) {
        player.addDamage(5);
    }

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

    public void resetEnemies(GameCharacter[] enemiesList) {
        for (GameCharacter anEnemy : enemiesList) {
            anEnemy.setLevel(1);
            switch (anEnemy.getName()) {
                case "Sub Zero" -> {
                    anEnemy.setDamage(16);
                    anEnemy.setMaxHealth(60);
                }
                case "Sonya Blade" -> {
                    anEnemy.setDamage(16);
                    anEnemy.setMaxHealth(80);
                }
                case "Shao Kahn" -> {
                    anEnemy.setDamage(30);
                    anEnemy.setMaxHealth(100);
                }
                case "Liu Kang" -> {
                    anEnemy.setDamage(20);
                    anEnemy.setMaxHealth(70);
                }
                case "Baraka" -> {
                    anEnemy.setDamage(12);
                    anEnemy.setMaxHealth(100);
                }
            }
        }
    }
}
