/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package characterFactory;

import characters.*;
/**
 * Фабрика персонажей для создания экземпляров {@link ShaoKahn}
 * @author Yulov
 */
public class ShaoKahnFactory extends CharacterFactory{

        static {
        // Регистрируем Shao Kahn при загрузке класса
        CharacterFactory.registerCharacter("Shao Kahn", ShaoKahn::new);
    }
    /**
     *
     * @return объект типа GameCharacter, соответствующий персонажу ShaoKahn
     */
        public GameCharacter createCharacter(){
        return new ShaoKahn();
    }
}
