/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actions;

import characters.GameCharacter;

/**
 * Класс, реализующий действие Восстановление здоровья
 * @author Yulov
 */
public class Heal extends Action {

/**
 * Возвращает тип действия
 *
 * @return строку "Heal" - тип данного действия
 */   
    @Override
    public String getType() {
        return "Heal";
    }
/** 
 * @param human
 * @param enemy
 * @param enemyActionType
 * - Если противник атакует, применяет дебафф или лечится - лечение не происходит
 * - Если противник защищается - восстанавливает 50% недостающего здоровья
 */   
    @Override
    public void realization(GameCharacter human, GameCharacter enemy, String enemyActionType) {
        switch (enemyActionType) {
            case "Hit", "Heal", "Debuff" -> {
            }
            case "Defense" -> {
                human.addHealth((human.getMaxHealth() - human.getHealth()) / 2);
            }
        }
    }
}
