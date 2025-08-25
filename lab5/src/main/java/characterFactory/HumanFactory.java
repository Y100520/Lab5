/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package characterFactory;

import characters.*;

/**
 * Фабрика персонажей для создания экземпляров {@link Human}
 * @author Yulov
 */
public class HumanFactory extends CharacterFactory{

        static {
        // Регистрируем Human при загрузке класса
        CharacterFactory.registerCharacter("Human", Human::new);
    }
    /**
     *
     * @return объект типа GameCharacter, соответствующий персонажу Human
     */
        public GameCharacter createCharacter(){
        return new Human();
    }
}
