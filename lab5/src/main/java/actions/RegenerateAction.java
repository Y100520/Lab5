/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package actions;

import characters.GameCharacter;

public class RegenerateAction extends Action {
    @Override
    public String getType() {
        return "Regenerate";
    }

    @Override
    public void realization(GameCharacter boss, GameCharacter player, String playerActionType) {
        if ("Defense".equals(playerActionType)) {
            int healAmount = boss.getDamageTakenThisFight() / 2;
            boss.addHealth(healAmount);
            System.out.println(boss.getName() + " восстанавливает " + healAmount + " здоровья!");
        } else if ("Hit".equals(playerActionType)) {
            System.out.println("Игрок прерывает регенерацию босса!");
        }
    }
}
