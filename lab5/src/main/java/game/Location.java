/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package game;

import characters.GameCharacter;

import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

public class Location {

    public static final int MAX_RANDOM_ENEMIES = 4;
    private int currentLocation = 1;
    private int currentEnemyIndexInLocation = 0;
    private ArrayList<GameCharacter> enemiesForCurrentLocation = new ArrayList<>();
    private GameCharacter[] allPossibleEnemies = null;
    private Random random = new Random();

    public void setFullEnemiesList(GameCharacter[] list) {
        allPossibleEnemies = list;
    }

    public void generateEnemiesForLocation(int playerLevel) {
        enemiesForCurrentLocation.clear();
        int numberOfEnemies = 2 + playerLevel + random.nextInt(2);

        for (int i = 0; i < numberOfEnemies; i++) {
            int enemyIndex = random.nextInt(MAX_RANDOM_ENEMIES);
            GameCharacter enemy = allPossibleEnemies[enemyIndex];
            setEnemyPhoto(enemy);
            enemiesForCurrentLocation.add(enemy);
        }

        GameCharacter boss = allPossibleEnemies[4];
        setEnemyPhoto(boss);
        enemiesForCurrentLocation.add(boss);

        currentEnemyIndexInLocation = 0;
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

    public void resetLocation(boolean goToNext, int playerLevel) {
        if (goToNext) {
            currentLocation++;
            generateEnemiesForLocation(playerLevel);
        } else {
            currentLocation = 1;
            enemiesForCurrentLocation.clear();
        }
    }

    public boolean isLocationCleared() {
        return currentEnemyIndexInLocation >= enemiesForCurrentLocation.size();
    }

    public GameCharacter getNextEnemy() {
        if (!isLocationCleared()) {
            GameCharacter enemy = enemiesForCurrentLocation.get(currentEnemyIndexInLocation);
            currentEnemyIndexInLocation++;
            return enemy;
        }
        System.err.println("Попытка получить врага из зачищенной локации!");
        return allPossibleEnemies[4];
    }

    public int getCurrentLocation() {
        return currentLocation;
    }

    public int getCurrentEnemyNumber() {
        return currentEnemyIndexInLocation;
    }

    public int getTotalEnemiesInLocation() {
        return enemiesForCurrentLocation.size();
    }
}
