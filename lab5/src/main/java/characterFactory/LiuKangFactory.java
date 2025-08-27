/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package characterFactory;

import characters.*;

public class LiuKangFactory extends CharacterFactory {

    static {
        CharacterFactory.registerCharacter("Liu Kang", LiuKang::new);
    }

    public GameCharacter createCharacter() {
        return new LiuKang();
    }
}
