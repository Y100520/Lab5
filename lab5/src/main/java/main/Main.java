package main;

import java.awt.EventQueue;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import view.GameView;

/**
 * Главный класс приложения, отвечающий за запуск графического интерфейса игры.
 * Устанавливает системную тему оформления и создает GUI в потоке обработки событий.
 * @author Yulov
 */
public class Main {

    /**
     * Точка входа в приложение. Инициализирует графический интерфейс игры.
     * <p>
     * Выполняет следующие действия:
     * <ol>
     *   <li>Устанавливает системную тему оформления через {@code UIManager}</li>
     *   <li>Запускает создание и отображение главного окна приложения 
     *       ({@code GameView}) в потоке обработки событий (Event Dispatch Thread)</li>
     * </ol>
     * В случае возникновения ошибок логирует их через стандартный механизм логирования Java.
     *
     * @param args аргументы командной строки (не используются)
     * @see javax.swing.UIManager#setLookAndFeel(String)
     * @see java.awt.EventQueue#invokeLater(Runnable)
     */
    public static void main(String args[]) {
        try {
            // Установка системной темы оформления
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            Logger.getLogger(GameView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // Создание GUI в потоке обработки событий
        EventQueue.invokeLater(() -> {
            try {
                new GameView().setVisible(true);
            } catch (Exception ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
}