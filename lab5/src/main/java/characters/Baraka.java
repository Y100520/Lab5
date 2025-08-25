/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package characters;

/**
 * Класс, представляющий игрового персонажа Baraka 
 * Наследует базовые характеристики от класса GameCharacter и задает уникальные параметры персонажа
 * @author Yulov
 */
public class Baraka extends GameCharacter {
    /**
     * Конструктор класса Baraka.
     * Инициализирует персонажа со стандартными характеристиками:
     * - Уровень: 1
     * - Максимальное здоровье: 100
     * - Базовый урон: 12
     * - Тип персонажа: "Baraka"
     */
    public Baraka() {
        super(1, 100, 12, "Baraka");
    }
}
