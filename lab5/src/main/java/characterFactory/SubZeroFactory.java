/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package characterFactory;

import characters.*;

/**
 * Фабрика персонажей для создания экземпляров {@link SubZero}
 * @author Yulov
 */
public class SubZeroFactory extends CharacterFactory{

        static {
        // Регистрируем Sub Zero при загрузке класса
        CharacterFactory.registerCharacter("Sub Zero", SubZero::new);
    }
    /**
     *
     * @return объект типа GameCharacter, соответствующий персонажу SubZero
     */
        public GameCharacter createCharacter(){
        return new SubZero();
    }
}