/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package characters;

import java.net.URL;
import javax.swing.ImageIcon;

public abstract class GameCharacter {

    public ImageIcon icon;

    private int level;
    private int health;
    private int maxHealth;
    private int damage;
    private final String name;

    private boolean isWeakened = false;
    private int weakenTurns = 0;
    private boolean hasTemporaryDamageBuff = false;
    private int damageTakenThisFight = 0;

    public GameCharacter(int level, int health, int damage, String name) {
        this.level = level;
        this.health = health;
        this.damage = damage;
        this.maxHealth = health;
        this.name = name;
    }

    public boolean isWeakened() {
        return isWeakened;
    }

    public void countdownWeakenTurns() {
        if (this.weakenTurns > 0) {
            this.weakenTurns--;
            if (this.weakenTurns == 0) {
                this.isWeakened = false;
                System.out.println(this.name + " больше не ослаблен.");
            }
        }
    }

    public void applyWeakenDebuff(int turns) {
        this.isWeakened = true;
        this.weakenTurns = turns;
    }

    public int getWeakenTurns() {
        return weakenTurns;
    }

    public boolean hasTemporaryDamageBuff() {
        return hasTemporaryDamageBuff;
    }

    public void setHasTemporaryDamageBuff(boolean hasBuff) {
        this.hasTemporaryDamageBuff = hasBuff;
    }

    public int getDamageTakenThisFight() {
        return damageTakenThisFight;
    }

    public void addDamageTakenThisFight(int damage) {
        this.damageTakenThisFight += damage;
    }

    public void resetDamageTakenThisFight() {
        this.damageTakenThisFight = 0;
    }

    public void setBonusDamageTurns(int turns) {
    }

    public boolean hasBonusDamage() {
        return isWeakened();
    }

    public void loseBonusDamageTurn() {
        countdownWeakenTurns();
    }

    public int getBonusDamageTurns() {
        return getWeakenTurns();
    }

    public void setPhoto(String path) {
        icon = new ImageIcon(path);
    }

    public void setPhoto(URL imageUrl) {
        if (imageUrl != null) {
            this.icon = new ImageIcon(imageUrl);
        } else {
            System.err.println("Ссылка на картинку пустая");
        }
    }

    public ImageIcon getPhoto() {
        return icon;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void addLevel() {
        this.level++;
    }

    public void addHealth(int health) {
        this.health += health;
        if (this.health > this.maxHealth) {
            this.health = this.maxHealth;
        }
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void addDamage(int damage) {
        this.damage += damage;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public void addMaxHealth(int maxHealth) {
        this.maxHealth += maxHealth;
    }

    public int getLevel() {
        return this.level;
    }

    public int getHealth() {
        return this.health;
    }

    public int getDamage() {
        return this.damage;
    }

    public int getMaxHealth() {
        return this.maxHealth;
    }

    public String getName() {
        return name;
    }
}
