/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package characterFactory;

import characters.GameCharacter;
import characters.SubZero;

public class SubZeroFactory extends CharacterFactory {

    static {
        CharacterFactory.registerCharacter("Sub Zero", SubZero::new);
    }

    public GameCharacter createCharacter() {
        return new SubZero();
    }
}
