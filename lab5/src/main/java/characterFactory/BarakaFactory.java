/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package characterFactory;

import characters.*;

/**
 * Фабрика персонажей для создания экземпляров {@link Baraka}
 * @author Yulov
 */
public class BarakaFactory extends CharacterFactory{
    /**
     *
     * @return объект типа GameCharacter, соответствующий персонажу Baraka
     */
    public GameCharacter createCharacter(){
        return new Baraka();
    }
}
