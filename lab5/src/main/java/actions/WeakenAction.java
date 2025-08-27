/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package actions;

import characters.GameCharacter;

public class WeakenAction extends Action {
    @Override
    public String getType() {
        return "Weaken";
    }

    @Override
    public void realization(GameCharacter attacker, GameCharacter target, String targetActionType) {
        if ("Defense".equals(targetActionType)) {
            if (Math.random() < 0.75) {
                System.out.println(target.getName() + " ослаблен!");
                target.applyWeakenDebuff(attacker.getLevel());
            } else {
                System.out.println("Ослабление не прошло сквозь защиту!");
            }
        } else if ("Hit".equals(targetActionType)) {
            System.out.println(target.getName() + " срывает ослабление своей атакой!");
            attacker.setHasTemporaryDamageBuff(true);
        } else {
            System.out.println("Ослабление не сработало.");
        }
    }
}
