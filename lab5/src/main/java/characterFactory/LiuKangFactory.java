/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package characterFactory;

import characters.*;

/**
 * Фабрика персонажей для создания экземпляров {@link LiuKang}
 * @author Yulov
 */
public class LiuKangFactory extends CharacterFactory{

        static {
        // Регистрируем Liu Kang при загрузке класса
        CharacterFactory.registerCharacter("Liu Kang", LiuKang::new);
    }
    /**
     *
     * @return объект типа GameCharacter, соответствующий персонажу LiuKang
     */
        public GameCharacter createCharacter(){
        return new LiuKang();
    }
}
