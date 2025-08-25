/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actions;

import characters.GameCharacter;

/**
 * Класс, реализующий действие Защита
 * 
 * @author Yulov
 */
public class Defense extends Action {
    
/**
 * Возвращает тип действия
 * 
 * @return строку "Defense" - тип данного действия
 */      

    @Override
    public String getType() {
        return "Defense";
    }
/**
 * @param human
 * @param enemy
 * @param enemyActionType
 */   
    @Override
    public void realization(GameCharacter human, GameCharacter enemy, String enemyActionType) {
    }
}