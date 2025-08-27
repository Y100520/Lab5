/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package characterFactory;

import characters.*;

public class HumanFactory extends CharacterFactory {

    static {
        CharacterFactory.registerCharacter("Human", Human::new);
    }

    public GameCharacter createCharacter() {
        return new Human();
    }
}
