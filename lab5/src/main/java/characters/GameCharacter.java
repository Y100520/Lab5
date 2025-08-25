/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package characters;

import java.net.URL;
import javax.swing.ImageIcon;

/**
 * Абстрактный класс, представляющий игрового персонажа
 * Содержит общие характеристики персонажа
 * @author Yulov
 */
public abstract class GameCharacter {

    /**
     * Изображение персонажа
     */
    public ImageIcon icon;
    
    private int level;
    private int health;
    private int maxHealth;
    private int damage;
    private int bonusDamageTurns = 0;
    private final String name;

    /**
     *
     * @param level уровень персонажа
     * @param health текущее и максимальное здороьве
     * @param damage базовый урон
     * @param name имя персонажа
     */
    public GameCharacter(int level, int health, int damage, String name) {
        this.level = level;
        this.health = health;
        this.damage = damage;
        this.maxHealth = health;
        this.name=name;
    }

    /**
     *
     * @param turns количество ходов
     */
    public void setBonusDamageTurns(int turns) {
        this.bonusDamageTurns = turns;
    }
    
    /**
     *
     * @return bonusDamageTurns
     */
    public boolean hasBonusDamage() {
        return bonusDamageTurns > 0;
    }

    /**
     *
     */
    public void loseBonusDamageTurn() {
        if (bonusDamageTurns > 0) {
            bonusDamageTurns--;
        }
    }

    /**
     *
     * @return bonusDamageTurns
     */
    public int getBonusDamageTurns() {
        return bonusDamageTurns;
    }

    /**
     *
     * @param path путь к изображению
     */
    public void setPhoto(String path) {
        icon = new ImageIcon(path);
    }
    
    /**
     *
     * @param imageUrl
     */
    public void setPhoto(URL imageUrl) {
        if (imageUrl != null) {
            this.icon = new ImageIcon(imageUrl);
        } else {
            System.err.println("Image URL is null");
        }
    }

    /**
     *
     * @return объект иконки
     */
    public ImageIcon getPhoto() {
        return icon;
    }

    /**
     *
     * @param level
     */
    public void setLevel(int level) {
        this.level = level;
    }

    /**
     *
     */
    public void addLevel() {
        this.level++;
    }

    /**
     *
     * @param health
     */
    public void addHealth(int health) {
        this.health += health;
    }

    /**
     *
     * @param health
     */
    public void setHealth(int health) {
        this.health = health;
    }

    /**
     *
     * @param damage
     */
    public void setDamage(int damage) {
        this.damage = damage;
    }

    /**
     *
     * @param damage
     */
    public void addDamage(int damage) {
        this.damage += damage;
    }

    /**
     *
     * @param maxHealth
     */
    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    /**
     *
     * @param maxHealth
     */
    public void addMaxHealth(int maxHealth) {
        this.maxHealth += maxHealth;
    }

    /**
     *
     * @return уровень
     */
    public int getLevel() {
        return this.level;
    }

    /**
     *
     * @return здоровье
     */
    public int getHealth() {
        return this.health;
    }

    /**
     *
     * @return урон
     */
    public int getDamage() {
        return this.damage;
    }

    /**
     *
     * @return максимальное здоровье
     */
    public int getMaxHealth() {
        return this.maxHealth;
    }

    /**
     *
     * @return имя
     */
    public String getName() {
        return name;
    }
}

