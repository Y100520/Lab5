/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package actions;

import characters.GameCharacter;

public abstract class Action {
    public abstract String getType();

    public abstract void realization(GameCharacter gameCharacter, GameCharacter enemy, String enemyActionType);
}

