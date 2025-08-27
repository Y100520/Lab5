/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package characterFactory;

import characters.*;

public class BarakaFactory extends CharacterFactory {
    public GameCharacter createCharacter() {
        return new Baraka();
    }
}
