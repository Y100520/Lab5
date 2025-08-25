/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package characters;

/**
 * Класс, представляющий игрового персонажа "Вы"
 * Наследует базовые характеристики от класса GameCharacter и задает уникальные параметры персонажа
 * @author Yulov
 */
public class Human extends GameCharacter {
    /**
     * Конструктор класса Human.
     * Инициализирует персонажа со стандартными характеристиками:
     * - Уровень: 1
     * - Максимальное здоровье: 100
     * - Базовый урон: 12
     * - Тип персонажа: "Human"
     */
    public Human(){
        super(0, 80, 16, "Human");
    }
}