/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package characterFactory;

import characters.*;

public class ShaoKahnFactory extends CharacterFactory {

    static {
        CharacterFactory.registerCharacter("Shao Kahn", ShaoKahn::new);
    }

    public GameCharacter createCharacter() {
        return new ShaoKahn();
    }
}
