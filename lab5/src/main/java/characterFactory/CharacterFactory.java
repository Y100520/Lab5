/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package characterFactory;

import characters.GameCharacter;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public abstract class CharacterFactory {
    private static final Map<String, Supplier<GameCharacter>> creators = new HashMap<>();

    public static void registerCharacter(String characterName, Supplier<GameCharacter> creator) {
        creators.put(characterName, creator);
    }

    public static GameCharacter createCharacter(String characterName) {
        Supplier<GameCharacter> creator = creators.get(characterName);
        if (creator != null) {
            return creator.get();
        }
        System.err.println("CharacterFactory: неизвестное имя персонажа \"" + characterName + "\"");
        return null;
    }
}
