/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package characters;

import components.Items;

/**
 * Класс, представляющий игрового персонажа, управляемого игроком
 * Наследуется от {@link GameCharacter} и добавляет свойства, связанные с прогрессом игрока
 * @author Yulov 
 */
public class Player extends GameCharacter {

    private int points;
    private int experience;
    private int nextExperience;
    private Items[] items;

    /**
     *
     * @param level уровень игрока
     * @param health здоровье игрока
     * @param damage базовый урон
     * @param name имя игрока
     */
    public Player(int level, int health, int damage, String name) {
        super(level, health, damage, name);
        this.points = 0;
        this.experience = 0;
        this.nextExperience = 40;
    }

    /**
     * Инвентарь игрока
     * @param items массив предметов {@link Items}, принадлежащих игроку
     */
    public void setItems(Items[] items){
        this.items = items;
    }

    /**
     *
     * @return предметы
     */
    public Items[] getItems(){
        return this.items;
    }

    /**
     *
     * @return баллы
     */
    public int getPoints() {
        return this.points;
    }

    /**
     *
     * @return опыт
     */
    public int getExperience() {
        return this.experience;
    }

    /**
     *
     * @return новый опыт
     */
    public int getNextExperience() {
        return this.nextExperience;
    }

    /**
     *
     */
    public void resetPoints() {
        this.points = 0;
    }
    
    /**
     *
     * @param points
     */
    public void setPoints(int points) {
        this.points += points;
    }

    /**
     *
     */
    public void resetExperience() {
        this.experience = 0;
    }

    /**
     *
     * @param experience
     */
    public void setExperience(int experience) {
        this.experience += experience;
    }

    /**
     *
     * @param nextExperience
     */
    public void setNextExperience(int nextExperience) {
        this.nextExperience = nextExperience;
    }
}