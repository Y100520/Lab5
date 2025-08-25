/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game;

import characters.GameCharacter;
import java.net.URL;

import java.util.ArrayList;

/**
 * Класс, который управляет текущей локацией игрока и врагами, встречающимися в ней
 * Отвечает за генерацию врагов, переключение между локациями.
 * @author Yulov
 */
public class Location {

    /**
     * Максимальное количество уникальных типов врагов
     */
    public static final int MAX_ENEMIES = 4;

    /**
     * Индекс врага по умолчанию (используется, когда враги на локации закончились)
     */
    public static final int DEFAULT_ENEMY_INDEX = 4;
    
    private int currentLocation = 1;
    private int currentEnemyNumber = 0;
    private ArrayList<GameCharacter> currentEnemiesList = new ArrayList<>();
    private GameCharacter[] fullEnemiesList = null;
    private int locationSize;

    /**
     *
     * @param list
     */
    public void setFullEnemiesList(GameCharacter[] list) {
        fullEnemiesList = list;
    }

    /**
     * Возвращает список врагов, сгенерированных для текущей локации
     * @return  список врагов
     */
    public ArrayList<GameCharacter> getCurrentEnemies() {
        return currentEnemiesList;
    }

    /**
     * Генерирует список случайных врагов для текущей локации
     * @param maxEnemies
     */
    public void setCurrentEnemies(int maxEnemies) {
        currentEnemiesList = new ArrayList<>();
        locationSize = 1 + (int) (Math.random() * maxEnemies);
        for (int i = 0; i < locationSize; i++) {
            GameCharacter enemy = getRandomEnemy();
            currentEnemiesList.add(enemy);
        }
    }   

    /**
     * Генерирует случайного врага из полного списка
     * @return экземпляр GameCharacter с настроенными параметрами
     */
    private GameCharacter getRandomEnemy() {
        int enemyIndex = (int) (Math.random() * MAX_ENEMIES);
        GameCharacter enemy = fullEnemiesList[enemyIndex];
        setEnemyPhoto(enemy);
        return enemy;
    }

    private void setEnemyPhoto(GameCharacter enemy) {
        try {
            String imageName = enemy.getName().toLowerCase().replace("-", "").replace(" ", "") + ".jpg";
            String resourcePath = "/images/" + imageName;
            URL imgURL = getClass().getResource(resourcePath);
            
            if (imgURL != null) {
                enemy.setPhoto(imgURL); 
            } else {
                System.err.println("Image not found: " + resourcePath);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param isNextLocation true, если переход к следующей локации, false - сброс
     * @param maxEnemies
     */
    public void resetLocation(boolean isNextLocation, int maxEnemies) {
        if (isNextLocation) {
            currentLocation += 1;
            currentEnemyNumber = 0;
            setCurrentEnemies(maxEnemies);
        } else {
            currentLocation = 1;
            currentEnemyNumber = 0;
            setCurrentEnemies(0);
        }
    }

    /**
     *
     * @return конкретная локация
     */
    public int getCurrentLocation() {
        return currentLocation;
    }

    /**
     *
     * @return номер врага
     */
    public int getCurrentEnemyNumber() {
        return currentEnemyNumber;
    }

     /**
     * Возвращает следующего противника для текущей локации.
     * Если все враги побеждены — возвращает врага по умолчанию
     * 
     * @return экземпляр GameCharacter, представляющий врага
     * @see EnemyFabric
     */
    public GameCharacter getCurrentEnemy() {
        GameCharacter enemy;
        if (currentEnemyNumber != locationSize) {
            currentEnemyNumber += 1;
            return currentEnemiesList.get(currentEnemyNumber - 1);
        } else {
            currentEnemyNumber = 0;
            enemy = fullEnemiesList[DEFAULT_ENEMY_INDEX];
            setEnemyPhoto(enemy);
            return enemy;
        }
    }
}