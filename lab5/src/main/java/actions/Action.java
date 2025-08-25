/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package actions;

import characters.GameCharacter;

/**
 * Абстрактный класс, предсталяющий действие в игре
 * Определяет общий интерфейс для различных типов действий (атака, защита, ослабление противника, лчение)
 * @author Yulov
 */

public abstract class Action {
    
    /**
     * Возвращает тип действия
     * @return строку с названием типа действия (например, "Атака", "Защита")
     */
    public abstract String getType();

    /**
     * Выполняет действие, влияя на игровых персонажей
     * 
     * @param gameCharacter персонаж, который совершает действие
     * @param enemy противник, на которого направлено действие
     * @param enemyActionType тип совершаемого противником действия 
     */
    public abstract void realization(GameCharacter gameCharacter, GameCharacter enemy, String enemyActionType);
}

