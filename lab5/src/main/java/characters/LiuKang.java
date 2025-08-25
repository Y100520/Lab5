/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package characters;

/**
 * Класс, представляющий игрового персонажа LiuKang 
 * Наследует базовые характеристики от класса GameCharacter и задает уникальные параметры персонажа
 * @author Yulov
 */
public class LiuKang extends GameCharacter {
    /**
     * Конструктор класса LiuKang.
     * Инициализирует персонажа со стандартными характеристиками:
     * - Уровень: 1
     * - Максимальное здоровье: 100
     * - Базовый урон: 12
     * - Тип персонажа: "Liu Kang"
     */
    public LiuKang() {
        super(1, 70, 20, "Liu Kang");
    }
}