/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package characterFactory;

import characters.*;

/**
 * Фабрика персонажей для создания экземпляров {@link SonyaBlade}
 * @author Yulov
 */
public class SonyaBladeFactory extends CharacterFactory{

        static {
        // Регистрируем Sonya Blade при загрузке класса
        CharacterFactory.registerCharacter("Sonya Blade", SonyaBlade::new);
    }
    /**
     *
     * @return объект типа GameCharacter, соответствующий персонажу SonyaBlade
     */
        public GameCharacter createCharacter(){
        return new SonyaBlade();
    }
}
