/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package characters;

/**
 * Класс, представляющий игрового персонажа SubZero 
 * Наследует базовые характеристики от класса GameCharacter и задает уникальные параметры персонажа
 * @author Yulov
 */
public class SubZero extends GameCharacter {
    /**
     * Конструктор класса SubZero.
     * Инициализирует персонажа со стандартными характеристиками:
     * - Уровень: 1
     * - Максимальное здоровье: 100
     * - Базовый урон: 12
     * - Тип персонажа: "Sub Zero"
     */
    public SubZero() {
        super(1, 60, 16, "Sub Zero");
    }
}
