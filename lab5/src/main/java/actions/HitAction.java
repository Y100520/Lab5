/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package actions;

import characters.GameCharacter;

public class HitAction extends Action {
    private static final double BLOCK_DAMAGE_MULTIPLIER = 0.5;

    @Override
    public String getType() {
        return "Hit";
    }

    @Override
    public void realization(GameCharacter attacker, GameCharacter target, String targetActionType) {
        int damage = calculateDamage(attacker, target);

        switch (targetActionType) {
            case "Hit":
                target.addHealth(-damage);
                target.addDamageTakenThisFight(damage);
                break;
            case "Defense":
                if (Math.random() < BLOCK_DAMAGE_MULTIPLIER) {
                    int blockedDamage = damage / 2;
                    target.addHealth(-blockedDamage);
                    target.addDamageTakenThisFight(blockedDamage);
                } else {
                    System.out.println(target.getName() + " заблокировал атаку!");
                }
                break;
            case "Weaken":
                target.addHealth(-damage);
                target.addDamageTakenThisFight(damage);
                break;
            case "Regenerate":
                int doubleDamage = damage * 2;
                System.out.println("Регенерация прервана! Двойной урон!");
                target.addHealth(-doubleDamage);
                target.addDamageTakenThisFight(doubleDamage);
                break;
            default:
                target.addHealth(-damage);
                target.addDamageTakenThisFight(damage);
        }
    }

    private int calculateDamage(GameCharacter attacker, GameCharacter target) {
        double currentDamage = attacker.getDamage();

        if (target.isWeakened()) {
            currentDamage *= 1.25;
        }

        if (attacker.isWeakened()) {
            currentDamage *= 0.5;
        }

        if (attacker.hasTemporaryDamageBuff()) {
            currentDamage *= 1.15;
            attacker.setHasTemporaryDamageBuff(false);
        }

        return (int) currentDamage;
    }
}
