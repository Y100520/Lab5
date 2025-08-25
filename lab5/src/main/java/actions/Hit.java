/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actions;

import characters.GameCharacter;

/**
 * Класс, реализующий действие Атака
 * @author Yulov 
 */
public class Hit extends Action {
    /** Множитель урона при атаке дебаффнутого противника */
    private static final double DEBUFF_DAMAGE_MULTIPLIER = 1.25;
    /** Шанс пробития защиты (50%) */
    private static final double BLOCK_DAMAGE_MULTIPLIER = 0.5;
    /** Множитель урона при атаке дебаффнутого противника в защите */
    private static final double DEBUFF_BLOCK_DAMAGE_MULTIPLIER = 1.15;
    /** Множитель урона по лечащемуся противнику */
    private static final double HEAL_DAMAGE_MULTIPLIER = 2.0;
    

    /**
     * Возвращает тип действия.
     * 
     * @return строку "Hit" - тип данного действия
     */

    @Override
    public String getType() {
        return "Hit";
    }
/**
     * Реализует логику атаки с учетом действия противника.
     * 
     * @param human атакующий персонаж
     * @param enemy защищающийся персонаж
     * @param enemyActionType тип действия защищающегося
     */
    @Override
    public void realization(GameCharacter human, GameCharacter enemy, String enemyActionType) {
        int damage = calculateDamage(human, enemy);
        switch (enemyActionType) {
            case "Hit":
                enemy.addHealth(-damage);
                break;
            case "Defense":
                if (Math.random() < BLOCK_DAMAGE_MULTIPLIER) {
                    enemy.addHealth(-damage / 2);
                }
                break;
            case "Debuff":
                enemy.addHealth((int) (-damage * DEBUFF_BLOCK_DAMAGE_MULTIPLIER));
                break;
            case "Heal":
                enemy.addHealth((int) (-damage * HEAL_DAMAGE_MULTIPLIER));
                break;
            default:
                System.out.println("Unknown enemy action type: " + enemyActionType);
        }
    }
    /**
     * Рассчитывает базовый урон с учетом всех модификаторов.
     * 
     * @param attacker атакующий персонаж
     * @param defender защищающийся персонаж
     * @return рассчитанное значение урона с учетом всех модификаторов
     * 
     */
    private int calculateDamage(GameCharacter human, GameCharacter enemy) {
        int damage = human.getDamage();
        if (enemy.hasBonusDamage() && human.hasBonusDamage()) {
            damage = (int) (damage * DEBUFF_DAMAGE_MULTIPLIER / 2);
        } else if (enemy.hasBonusDamage() &&!human.hasBonusDamage()) {
            damage = (int) (damage * DEBUFF_DAMAGE_MULTIPLIER);
        } else if (!enemy.hasBonusDamage() && human.hasBonusDamage()) {
            damage = damage / 2;
        } else if (human.hasBonusDamage()) {
            damage = (int) (damage * 1.15);
            human.loseBonusDamageTurn();
        }
        return damage;
    }
}