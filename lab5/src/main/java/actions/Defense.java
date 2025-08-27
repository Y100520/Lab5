/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package actions;

import characters.GameCharacter;

public class Defense extends Action {

    @Override
    public String getType() {
        return "Defense";
    }

    @Override
    public void realization(GameCharacter human, GameCharacter enemy, String enemyActionType) {
    }
}