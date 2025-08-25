/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game;

/**
 *
 * @author Yulov
 */

import characterFactory.*;
import characters.Player;
import components.Items;
import characters.GameCharacter;
import components.Results;


import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

/**
 * Класс, управляющий основной логикой игры, включая создание персонажей,
 * обработку игровых сессий, управление результатами игроков и взаимодействие с Excel
 * @author Yulov
 */
public class GameManager {
    /**
     * Контроллер боевой системы
     */
    public Fight fight = new Fight();
    /**
     * Хранение рузльтатов 
     */
    private final ArrayList<Results> gameResults = new ArrayList<>();
    /**
     * Доступные противники
     */
    private final GameCharacter[] enemies = new GameCharacter[5];
    



    /**
     * Инициализирует список противников, создавая экземпляры персонажей
     */
    public void setEnemies() {
        CharacterRegistration.registerAll();
        enemies[0] = CharacterFactory.createCharacter("Baraka");
        enemies[1] = CharacterFactory.createCharacter("Sub Zero");
        enemies[2] = CharacterFactory.createCharacter("Liu Kang");
        enemies[3] = CharacterFactory.createCharacter("Sonya Blade");
        enemies[4] = CharacterFactory.createCharacter("Shao Kahn");
    }

    /**
     *
     * @return враги
     */
    public GameCharacter[] getEnemies() {
        return this.enemies;
    }

    /**
     * Создает нового игрока
     * 
     * @param controller экземпляр {@code Controller}, управляющий интерфейсом
     * @param items начальный инвентарь игрока
     * @return новый экземпляр игрока
     */
    public Player newHuman(Controller controller, Items[] items) {
        Player player = new Player(0, 80, 16, "Human");
        controller.setHealthBar(player);
        controller.setPlayerMaxHealthBar(player);
        player.setItems(items);
        return player;
    }

    /**
     * Завершает игровую сессию, сохраняет результат в Excel
     * 
     * @param player текущий игрок
     * @param text текстовое поле с именем игрока
     * @param table таблица результатов
     * @throws IOException при ошибках записи в файл
     */
    public void endGameTop(Player player, JTextField text, JTable table) throws IOException {
        gameResults.add(new Results(text.getText(), player.getPoints()));
        gameResults.sort(Comparator.comparing(Results::getPoints).reversed());
        writeToTable(table);
        writeToExcel();
    }

    /**
     * Записывает Топ-10 результатов в Excel-файл
     * 
     * @throws IOException при ошибках ввода/вывода
     * @see <a href="https://poi.apache.org/">Apache POI documentation</a>
     */
    public void writeToExcel() throws IOException {       
        File externalFile = new File("Results.xlsx");
    
        try (XSSFWorkbook book = new XSSFWorkbook()) {
            XSSFSheet sheet = book.createSheet("Результаты ТОП 10");
            XSSFRow r = sheet.createRow(0);
            r.createCell(0).setCellValue("№");
            r.createCell(1).setCellValue("Имя");
            r.createCell(2).setCellValue("Количество баллов");

            for (int i = 0; i < gameResults.size() && i < 10; i++) {
                XSSFRow r2 = sheet.createRow(i + 1);
                r2.createCell(0).setCellValue(i + 1);
                r2.createCell(1).setCellValue(gameResults.get(i).getName());
                r2.createCell(2).setCellValue(gameResults.get(i).getPoints());
            }
        
        try (FileOutputStream out = new FileOutputStream(externalFile)) {
            book.write(out);
        }
    }
    }

    /**
     * Возвращает список всех игровых результатов
     * 
     * @return неизменяемый список объектов Results
     */
    public ArrayList<Results> getResults() {
        return this.gameResults;
    }

    /**
     * Читает результаты из Excel-файла
     * 
     * @throws IOException при ошибках чтения файла
     */
    public void readFromExcel() throws IOException {
        File externalFile = new File("Results.xlsx");

        if (externalFile.exists()) {
            try (XSSFWorkbook book = new XSSFWorkbook(externalFile)) {
                readDataFromWorkbook(book);
            }  catch (IOException | InvalidFormatException ex) {
            Logger.getLogger(GameManager.class.getName()).log(
                Level.SEVERE, 
                "Ошибка чтения внешнего файла Results.xlsx", 
                ex
            );
            }
        } 
        else {
            try (InputStream is = getClass().getResourceAsStream("/Results.xlsx");
                 XSSFWorkbook book = new XSSFWorkbook(is)) {

                try (FileOutputStream out = new FileOutputStream(externalFile)) {
                    book.write(out);
                }

                readDataFromWorkbook(book);
            }
         catch (IOException ex) {
        Logger.getLogger(GameManager.class.getName()).log(
            Level.SEVERE, 
            "Ошибка копирования файла из ресурсов", 
            ex
            );
        }
        }
    }
    /**
     * Считывает данные из книги Excel и добавляет их в список результатов.
     *
     * @param book объект, содержащий данные
     */
    private void readDataFromWorkbook(XSSFWorkbook book) {
    XSSFSheet sh = book.getSheetAt(0);
    for (int i = 1; i <= sh.getLastRowNum(); i++) {
        XSSFRow row = sh.getRow(i);
        if (row != null) {
            String name = row.getCell(1).getStringCellValue();
            int points = (int) row.getCell(2).getNumericCellValue();
            gameResults.add(new Results(name, points));
        }
    }
}

    /**
     * Обновляет таблицу результатов в графическом интерфейсе
     * 
     * @param table JTable для отображения данных
     */
    public void writeToTable(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        for (int i = 0; i < gameResults.size(); i++) {
            if (i < 10) {
                model.setValueAt(gameResults.get(i).getName(), i, 0);
                model.setValueAt(gameResults.get(i).getPoints(), i, 1);
            }
        }
    }
}
