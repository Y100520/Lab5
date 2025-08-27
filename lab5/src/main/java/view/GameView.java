/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import actionFactory.*;
import game.GameManager;
import game.Controller;
import characters.Player;
import components.Items;

import java.awt.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class GameView extends JFrame {
    Controller controller;
    GameManager helper = new GameManager();
    Items[] items = new Items[3];
    String nameButton = "";
    int locationsNumber = 0;

    public GameView() {
        initComponents();
        try {
            helper.readFromExcel();
        } catch (IOException ignored) {

        }
        helper.writeToTable(recordsTable);
        helper.setEnemies();
        helper.fight.location.setFullEnemiesList(helper.getEnemies());
        playerIconLabel.setIcon(new ImageIcon(getClass().getResource("/images/kitana.jpg")));

        attributesGroup.add(healthButton);
        attributesGroup.add(damageButton);
        itemsGroup.add(firstItemButton);
        itemsGroup.add(secondItemButton);
        itemsGroup.add(thirdItemButton);

        items[0] = new Items("Малое зелье лечение", 0);
        items[1] = new Items("Большое зелье лечение", 0);
        items[2] = new Items("Крест возрождения", 0);

        controller = new Controller();
        setControllerComponents();
        controller.view = this;
        helper.fight.setController(controller);
    }

    public void setControllerComponents() {
        controller.setEnemyHealthLabel(this.enemyHealthLabel);
        controller.setPlayerHealthLabel(this.playerHealthLabel);
        controller.setEndFightDialog(this.endFightDialog);
        controller.setPointsValueLabel(this.pointsValueLabel);
        controller.setExperienceValueLabel(this.experienceValueLabel);
        controller.setPlayerLevelLabel(this.playerLevelLabel);
        controller.setEnemyLevelLabel(this.enemyLevelLabel);
        controller.setPlayerDamageValueLabel(this.playerDamageValueLabel);
        controller.setEndRoundLabel(this.endRoundLabel);
        controller.setPlayerHealthBar(this.playerHealthBar);
        controller.setEnemyHealthBar(this.enemyHealthBar);
        controller.setEndGameDialog(this.endGameDialog);
        controller.setEndGameWithoutLadderDialog(this.endGameWithoutLadderDialog);
        controller.setFightFrame(this.fightFrame);
        controller.setEnemyDebuffLabel(this.enemyDebuffLabel);
        controller.setVictoryLabel(this.victoryLabel);
        controller.setEndGameWithoutLadderTitlleLabel(this.endGameWithoutLadderTitlleLabel);
        controller.setPlayerActionLabel(this.playerActionLabel);
        controller.setPlayerDebuffLabel(this.playerDebuffLabel);
        controller.setEnemyActionLabel(this.enemyActionLabel);
        controller.setFirstItemButton(this.firstItemButton);
        controller.setSecondItemButton(this.secondItemButton);
        controller.setThirdItemButton(this.thirdItemButton);
        controller.setCantUseItemDialog(this.cantUseItemDialog);
    }

    public JPanel getFightPanel() {
        return fightPanel;
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        fightFrame = new javax.swing.JFrame();
        fightPanel = new javax.swing.JPanel();
        playerIconLabel = new javax.swing.JLabel();
        attackButton = new javax.swing.JButton();
        defenseButton = new javax.swing.JButton();
        playerHealthBar = new javax.swing.JProgressBar();
        enemyIconLabel = new javax.swing.JLabel();
        enemyHealthBar = new javax.swing.JProgressBar();
        enemyHeroLabel = new javax.swing.JLabel();
        enemyDamageLabel = new javax.swing.JLabel();
        playerDamageLabel = new javax.swing.JLabel();
        playerDamageValueLabel = new javax.swing.JLabel();
        enemyDamageValueLabel = new javax.swing.JLabel();
        playerLevelLabel = new javax.swing.JLabel();
        fightLabel = new javax.swing.JLabel();
        playerHealthLabel = new javax.swing.JLabel();
        enemyHealthLabel = new javax.swing.JLabel();
        experienceLabel = new javax.swing.JLabel();
        pointsTitleLabel = new javax.swing.JLabel();
        experienceValueLabel = new javax.swing.JLabel();
        pointsValueLabel = new javax.swing.JLabel();
        enemyLevelLabel = new javax.swing.JLabel();
        enemyActionLabel = new javax.swing.JLabel();
        playerActionLabel = new javax.swing.JLabel();
        playerCharacterNameLabel = new javax.swing.JLabel();
        stunLabel = new javax.swing.JLabel();
        itemsButton = new javax.swing.JButton();
        debuffButton = new javax.swing.JButton();
        playerDebuffLabel = new javax.swing.JLabel();
        enemyDebuffLabel = new javax.swing.JLabel();
        locationLabel = new javax.swing.JLabel();
        enemyNumberLabel = new javax.swing.JLabel();
        endFightDialog = new javax.swing.JDialog();
        jPanel3 = new javax.swing.JPanel();
        endRoundLabel = new javax.swing.JLabel();
        nextRoundButton = new javax.swing.JButton();
        endGameDialog = new javax.swing.JDialog();
        jPanel4 = new javax.swing.JPanel();
        victoryLabel = new javax.swing.JLabel();
        enterNameField = new javax.swing.JTextField();
        enterNameLabel = new javax.swing.JLabel();
        enterNameLabelBottom = new javax.swing.JLabel();
        endGameButton = new javax.swing.JButton();
        recordsTableDialog = new javax.swing.JDialog();
        jPanel5 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        recordsTable = new javax.swing.JTable();
        closeRecordsTableButton = new javax.swing.JButton();
        endGameWithoutLadderDialog = new javax.swing.JDialog();
        jPanel6 = new javax.swing.JPanel();
        endGameWithoutLadderTitlleLabel = new javax.swing.JLabel();
        notInLadderLabel = new javax.swing.JLabel();
        endGameWithoutLadderButton = new javax.swing.JButton();
        itemsBagDialog = new javax.swing.JDialog();
        jPanel7 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        firstItemButton = new javax.swing.JRadioButton();
        secondItemButton = new javax.swing.JRadioButton();
        thirdItemButton = new javax.swing.JRadioButton();
        useItemButton = new javax.swing.JButton();
        itemsGroup = new javax.swing.ButtonGroup();
        cantUseItemDialog = new javax.swing.JDialog();
        jPanel8 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        closeCantUseItemButton = new javax.swing.JButton();
        levelUp = new javax.swing.JFrame();
        levelUpLabel = new javax.swing.JLabel();
        damageButton = new javax.swing.JRadioButton();
        healthButton = new javax.swing.JRadioButton();
        chooseAttributeButton = new javax.swing.JButton();
        attributesGroup = new javax.swing.ButtonGroup();
        setLocationsFrame = new javax.swing.JFrame();
        setLocationsLabel = new javax.swing.JLabel();
        setLocationsField = new javax.swing.JTextField();
        startWithLocationsButton = new javax.swing.JButton();
        StartPanel = new javax.swing.JPanel();
        MKLabel = new javax.swing.JLabel();
        startButton = new javax.swing.JButton();
        seeResultsButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        fightPanel.setBackground(new java.awt.Color(255, 255, 255));

        attackButton.setBackground(new java.awt.Color(255, 0, 0));
        attackButton.setFont(new java.awt.Font("Comic Sans MS", 1, 12));
        attackButton.setText("Атаковать");
        attackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                attackButtonActionPerformed(evt);
            }
        });

        defenseButton.setBackground(new java.awt.Color(255, 204, 0));
        defenseButton.setFont(new java.awt.Font("Comic Sans MS", 1, 12));
        defenseButton.setText("Защититься");
        defenseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                defenseButtonActionPerformed(evt);
            }
        });

        playerHealthBar.setBackground(new java.awt.Color(204, 204, 204));
        playerHealthBar.setForeground(new java.awt.Color(51, 255, 51));
        playerHealthBar.setMaximum(80);
        playerHealthBar.setMinimum(-1);

        enemyHealthBar.setBackground(new java.awt.Color(204, 204, 204));
        enemyHealthBar.setForeground(new java.awt.Color(0, 255, 0));
        enemyHealthBar.setMinimum(-1);

        enemyHeroLabel.setBackground(new java.awt.Color(0, 0, 0));
        enemyHeroLabel.setFont(new java.awt.Font("Comic Sans MS", 2, 14));

        enemyDamageLabel.setBackground(new java.awt.Color(255, 255, 255));
        enemyDamageLabel.setFont(new java.awt.Font("Comic Sans MS", 1, 14));
        enemyDamageLabel.setText("Damage");

        playerDamageLabel.setBackground(new java.awt.Color(255, 255, 255));
        playerDamageLabel.setFont(new java.awt.Font("Comic Sans MS", 1, 14));
        playerDamageLabel.setText("Damage");

        playerDamageValueLabel.setBackground(new java.awt.Color(255, 255, 255));
        playerDamageValueLabel.setFont(new java.awt.Font("Comic Sans MS", 1, 14));
        playerDamageValueLabel.setForeground(new java.awt.Color(255, 0, 0));
        playerDamageValueLabel.setText("16");

        enemyDamageValueLabel.setBackground(new java.awt.Color(255, 255, 255));
        enemyDamageValueLabel.setFont(new java.awt.Font("Comic Sans MS", 1, 14));
        enemyDamageValueLabel.setForeground(new java.awt.Color(255, 0, 0));
        enemyDamageValueLabel.setText("16");

        playerLevelLabel.setBackground(new java.awt.Color(255, 255, 255));
        playerLevelLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 12));
        playerLevelLabel.setText("0 уровень");

        fightLabel.setBackground(new java.awt.Color(255, 255, 255));
        fightLabel.setFont(new java.awt.Font("Comic Sans MS", 3, 36));
        fightLabel.setForeground(new java.awt.Color(0, 0, 153));
        fightLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fightLabel.setText("FIGHT");
        fightLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        playerHealthLabel.setBackground(new java.awt.Color(255, 255, 255));
        playerHealthLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 14));
        playerHealthLabel.setForeground(new java.awt.Color(102, 102, 102));
        playerHealthLabel.setText("80/80");

        enemyHealthLabel.setBackground(new java.awt.Color(255, 255, 255));
        enemyHealthLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 14));
        enemyHealthLabel.setForeground(new java.awt.Color(102, 102, 102));
        enemyHealthLabel.setText("80/80");

        experienceLabel.setBackground(new java.awt.Color(255, 255, 255));
        experienceLabel.setFont(new java.awt.Font("Comic Sans MS", 1, 18));
        experienceLabel.setForeground(new java.awt.Color(128, 92, 31));
        experienceLabel.setText("experience");

        pointsTitleLabel.setBackground(new java.awt.Color(255, 255, 255));
        pointsTitleLabel.setFont(new java.awt.Font("Comic Sans MS", 1, 18));
        pointsTitleLabel.setForeground(new java.awt.Color(128, 92, 31));
        pointsTitleLabel.setText("points");

        experienceValueLabel.setBackground(new java.awt.Color(255, 255, 255));
        experienceValueLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 14));
        experienceValueLabel.setForeground(new java.awt.Color(113, 90, 16));
        experienceValueLabel.setText("0/40");

        pointsValueLabel.setBackground(new java.awt.Color(255, 255, 255));
        pointsValueLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 14));
        pointsValueLabel.setForeground(new java.awt.Color(113, 90, 16));
        pointsValueLabel.setText("00");

        enemyLevelLabel.setBackground(new java.awt.Color(255, 255, 255));
        enemyLevelLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 12));
        enemyLevelLabel.setText("1 уровень");

        enemyActionLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 16));
        enemyActionLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        playerActionLabel.setFont(new java.awt.Font("Comic Sans MS", 1, 12));
        playerActionLabel.setForeground(new java.awt.Color(204, 0, 0));
        playerActionLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        playerCharacterNameLabel.setFont(new java.awt.Font("Comic Sans MS", 2, 14));
        playerCharacterNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        playerCharacterNameLabel.setText("Kitana ");

        stunLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 16));
        stunLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        itemsButton.setBackground(new java.awt.Color(174, 183, 106));
        itemsButton.setFont(new java.awt.Font("Comic Sans MS", 1, 12));
        itemsButton.setText("Предметы");
        itemsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemsButtonActionPerformed(evt);
            }
        });

        debuffButton.setBackground(new java.awt.Color(204, 0, 204));
        debuffButton.setFont(new java.awt.Font("Comic Sans MS", 1, 12));
        debuffButton.setText("Ослабить противника");
        debuffButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                debuffButtonActionPerformed(evt);
            }
        });

        locationLabel.setText("Локация:");

        enemyNumberLabel.setText("Враг:");

        javax.swing.GroupLayout fightPanelLayout = new javax.swing.GroupLayout(fightPanel);
        fightPanel.setLayout(fightPanelLayout);
        fightPanelLayout.setHorizontalGroup(
                fightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(fightPanelLayout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(enemyHealthLabel)
                                .addGap(18, 18, 18)
                                .addGroup(fightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(fightPanelLayout.createSequentialGroup()
                                                .addGap(262, 262, 262)
                                                .addGroup(fightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(fightLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(experienceLabel))
                                                .addContainerGap())
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fightPanelLayout.createSequentialGroup()
                                                .addGroup(fightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fightPanelLayout.createSequentialGroup()
                                                                .addComponent(enemyNumberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(itemsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(attackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(13, 13, 13))
                                                        .addGroup(fightPanelLayout.createSequentialGroup()
                                                                .addGroup(fightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, fightPanelLayout.createSequentialGroup()
                                                                                .addComponent(enemyHealthBar, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGroup(fightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addGroup(fightPanelLayout.createSequentialGroup()
                                                                                                .addGap(92, 92, 92)
                                                                                                .addComponent(pointsTitleLabel))
                                                                                        .addGroup(fightPanelLayout.createSequentialGroup()
                                                                                                .addGap(111, 111, 111)
                                                                                                .addComponent(pointsValueLabel)
                                                                                                .addGap(108, 108, 108)
                                                                                                .addComponent(experienceValueLabel))))
                                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, fightPanelLayout.createSequentialGroup()
                                                                                .addComponent(enemyDamageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(enemyDamageValueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addComponent(locationLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, fightPanelLayout.createSequentialGroup()
                                                                                .addGroup(fightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(enemyIconLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(enemyHeroLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addGroup(fightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fightPanelLayout.createSequentialGroup()
                                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                                .addComponent(stunLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                        .addGroup(fightPanelLayout.createSequentialGroup()
                                                                                                .addGroup(fightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                        .addGroup(fightPanelLayout.createSequentialGroup()
                                                                                                                .addGap(26, 26, 26)
                                                                                                                .addComponent(playerActionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                        .addGroup(fightPanelLayout.createSequentialGroup()
                                                                                                                .addGap(69, 69, 69)
                                                                                                                .addComponent(enemyActionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                                                .addGap(0, 0, Short.MAX_VALUE)))))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE))
                                                        .addGroup(fightPanelLayout.createSequentialGroup()
                                                                .addComponent(enemyDebuffLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                                .addGroup(fightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(fightPanelLayout.createSequentialGroup()
                                                                .addGroup(fightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(fightPanelLayout.createSequentialGroup()
                                                                                .addComponent(playerHealthBar, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(18, 18, 18)
                                                                                .addComponent(playerHealthLabel))
                                                                        .addGroup(fightPanelLayout.createSequentialGroup()
                                                                                .addComponent(playerDamageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(playerDamageValueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                .addGap(45, 45, 45))
                                                        .addGroup(fightPanelLayout.createSequentialGroup()
                                                                .addComponent(playerIconLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(60, 60, 60))
                                                        .addGroup(fightPanelLayout.createSequentialGroup()
                                                                .addGroup(fightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(playerCharacterNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(defenseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(18, 18, 18)
                                                                .addComponent(debuffButton)
                                                                .addContainerGap())
                                                        .addGroup(fightPanelLayout.createSequentialGroup()
                                                                .addComponent(playerDebuffLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(37, 37, 37)
                                                                .addComponent(playerLevelLabel)
                                                                .addGap(28, 28, 28))))))
                        .addGroup(fightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(fightPanelLayout.createSequentialGroup()
                                        .addGap(16, 16, 16)
                                        .addComponent(enemyLevelLabel)
                                        .addContainerGap(854, Short.MAX_VALUE)))
        );
        fightPanelLayout.setVerticalGroup(
                fightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fightPanelLayout.createSequentialGroup()
                                .addContainerGap(18, Short.MAX_VALUE)
                                .addComponent(fightLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(fightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(fightPanelLayout.createSequentialGroup()
                                                .addGap(63, 63, 63)
                                                .addGroup(fightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(playerHealthBar, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                                                        .addComponent(enemyHealthBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addGroup(fightPanelLayout.createSequentialGroup()
                                                                .addGap(8, 8, 8)
                                                                .addComponent(playerHealthLabel))
                                                        .addComponent(enemyHealthLabel, javax.swing.GroupLayout.Alignment.TRAILING)))
                                        .addGroup(fightPanelLayout.createSequentialGroup()
                                                .addGap(40, 40, 40)
                                                .addGroup(fightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(experienceLabel)
                                                        .addComponent(pointsTitleLabel))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                                                .addGroup(fightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(experienceValueLabel)
                                                        .addComponent(pointsValueLabel))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(fightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(playerDamageLabel)
                                        .addGroup(fightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(enemyDamageLabel)
                                                .addComponent(enemyDamageValueLabel)
                                                .addComponent(playerDamageValueLabel)))
                                .addGroup(fightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(fightPanelLayout.createSequentialGroup()
                                                .addGap(27, 27, 27)
                                                .addComponent(enemyDebuffLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(enemyIconLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                                                .addComponent(enemyHeroLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(locationLabel))
                                        .addGroup(fightPanelLayout.createSequentialGroup()
                                                .addGroup(fightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addGroup(fightPanelLayout.createSequentialGroup()
                                                                .addGap(18, 18, 18)
                                                                .addGroup(fightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(playerDebuffLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(playerLevelLabel))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                                                                .addComponent(playerIconLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(fightPanelLayout.createSequentialGroup()
                                                                .addGap(60, 60, 60)
                                                                .addComponent(playerActionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
                                                                .addComponent(enemyActionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(stunLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(18, 18, 18)
                                                .addComponent(playerCharacterNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                                .addGroup(fightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                                        .addComponent(attackButton, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                                        .addComponent(itemsButton, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                                        .addComponent(defenseButton, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                                        .addComponent(debuffButton, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                                        .addComponent(enemyNumberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(14, 14, 14))
                        .addGroup(fightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(fightPanelLayout.createSequentialGroup()
                                        .addGap(229, 229, 229)
                                        .addComponent(enemyLevelLabel)
                                        .addContainerGap(390, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout fightFrameLayout = new javax.swing.GroupLayout(fightFrame.getContentPane());
        fightFrame.getContentPane().setLayout(fightFrameLayout);
        fightFrameLayout.setHorizontalGroup(
                fightFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(fightFrameLayout.createSequentialGroup()
                                .addComponent(fightPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        fightFrameLayout.setVerticalGroup(
                fightFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(fightPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(179, 226, 217));

        endRoundLabel.setBackground(new java.awt.Color(204, 204, 204));
        endRoundLabel.setFont(new java.awt.Font("Comic Sans MS", 1, 42));
        endRoundLabel.setForeground(new java.awt.Color(204, 0, 0));
        endRoundLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        endRoundLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        nextRoundButton.setBackground(new java.awt.Color(114, 218, 142));
        nextRoundButton.setFont(new java.awt.Font("Comic Sans MS", 0, 24));
        nextRoundButton.setText("Дальше");
        nextRoundButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextRoundButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGap(208, 208, 208)
                                                .addComponent(nextRoundButton, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGap(104, 104, 104)
                                                .addComponent(endRoundLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(106, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(89, 89, 89)
                                .addComponent(endRoundLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 108, Short.MAX_VALUE)
                                .addComponent(nextRoundButton, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(72, 72, 72))
        );

        javax.swing.GroupLayout endFightDialogLayout = new javax.swing.GroupLayout(endFightDialog.getContentPane());
        endFightDialog.getContentPane().setLayout(endFightDialogLayout);
        endFightDialogLayout.setHorizontalGroup(
                endFightDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(endFightDialogLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        endFightDialogLayout.setVerticalGroup(
                endFightDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(endFightDialogLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(255, 204, 255));

        victoryLabel.setFont(new java.awt.Font("Comic Sans MS", 3, 24));
        victoryLabel.setForeground(new java.awt.Color(255, 0, 0));
        victoryLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        victoryLabel.setText("Победа на вашей стороне");

        enterNameField.setFont(new java.awt.Font("Comic Sans MS", 1, 18));
        enterNameField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        enterNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterNameFieldActionPerformed(evt);
            }
        });

        enterNameLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 14));
        enterNameLabel.setForeground(new java.awt.Color(102, 102, 102));
        enterNameLabel.setText("Введите имя своего персонажа для добавления");

        enterNameLabelBottom.setFont(new java.awt.Font("Comic Sans MS", 0, 14));
        enterNameLabelBottom.setForeground(new java.awt.Color(102, 102, 102));
        enterNameLabelBottom.setText("результата в таблицу рекордов");

        endGameButton.setBackground(new java.awt.Color(153, 153, 255));
        endGameButton.setFont(new java.awt.Font("Comic Sans MS", 1, 14));
        endGameButton.setForeground(new java.awt.Color(51, 51, 51));
        endGameButton.setText("закончить игру");
        endGameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endGameButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(endGameButton)
                                .addGap(14, 14, 14))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addGap(132, 132, 132)
                                                .addComponent(enterNameLabelBottom))
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addGap(60, 60, 60)
                                                .addComponent(victoryLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addGap(77, 77, 77)
                                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(enterNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(enterNameLabel))))
                                .addContainerGap(62, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addComponent(victoryLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(enterNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(enterNameLabelBottom)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                                .addComponent(enterNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(endGameButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        javax.swing.GroupLayout endGameDialogLayout = new javax.swing.GroupLayout(endGameDialog.getContentPane());
        endGameDialog.getContentPane().setLayout(endGameDialogLayout);
        endGameDialogLayout.setHorizontalGroup(
                endGameDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(endGameDialogLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        endGameDialogLayout.setVerticalGroup(
                endGameDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(endGameDialogLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(204, 204, 255));

        jLabel23.setFont(new java.awt.Font("Comic Sans MS", 1, 24));
        jLabel23.setForeground(new java.awt.Color(51, 51, 51));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("Таблица рекордов");

        recordsTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null}
                },
                new String[]{
                        "Имя", "Количество баллов"
                }
        ) {
            Class[] types = new Class[]{
                    java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });
        jScrollPane1.setViewportView(recordsTable);

        closeRecordsTableButton.setBackground(new java.awt.Color(255, 255, 153));
        closeRecordsTableButton.setFont(new java.awt.Font("Comic Sans MS", 0, 18));
        closeRecordsTableButton.setForeground(new java.awt.Color(51, 51, 51));
        closeRecordsTableButton.setText("Закрыть");
        closeRecordsTableButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeRecordsTableButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(closeRecordsTableButton, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel5Layout.createSequentialGroup()
                                                        .addGap(160, 160, 160)
                                                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(jPanel5Layout.createSequentialGroup()
                                                        .addGap(18, 18, 18)
                                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 527, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(closeRecordsTableButton, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                                .addContainerGap())
        );

        javax.swing.GroupLayout recordsTableDialogLayout = new javax.swing.GroupLayout(recordsTableDialog.getContentPane());
        recordsTableDialog.getContentPane().setLayout(recordsTableDialogLayout);
        recordsTableDialogLayout.setHorizontalGroup(
                recordsTableDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        recordsTableDialogLayout.setVerticalGroup(
                recordsTableDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel6.setBackground(new java.awt.Color(255, 204, 255));

        endGameWithoutLadderTitlleLabel.setFont(new java.awt.Font("Comic Sans MS", 3, 24));
        endGameWithoutLadderTitlleLabel.setForeground(new java.awt.Color(255, 0, 0));
        endGameWithoutLadderTitlleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        endGameWithoutLadderTitlleLabel.setText("Победа на вашей стороне");

        notInLadderLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 14));
        notInLadderLabel.setForeground(new java.awt.Color(102, 102, 102));
        notInLadderLabel.setText("К сожалению, Ваш результат не попал в топ 10");

        endGameWithoutLadderButton.setBackground(new java.awt.Color(153, 153, 255));
        endGameWithoutLadderButton.setFont(new java.awt.Font("Comic Sans MS", 1, 14));
        endGameWithoutLadderButton.setForeground(new java.awt.Color(51, 51, 51));
        endGameWithoutLadderButton.setText("Закончить игру");
        endGameWithoutLadderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endGameWithoutLadderButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
                jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel6Layout.createSequentialGroup()
                                                .addGap(48, 48, 48)
                                                .addComponent(endGameWithoutLadderTitlleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel6Layout.createSequentialGroup()
                                                .addGap(58, 58, 58)
                                                .addComponent(notInLadderLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel6Layout.createSequentialGroup()
                                                .addGap(153, 153, 153)
                                                .addComponent(endGameWithoutLadderButton, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(68, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
                jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(endGameWithoutLadderTitlleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addComponent(notInLadderLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(56, 56, 56)
                                .addComponent(endGameWithoutLadderButton, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(56, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout endGameWithoutLadderDialogLayout = new javax.swing.GroupLayout(endGameWithoutLadderDialog.getContentPane());
        endGameWithoutLadderDialog.getContentPane().setLayout(endGameWithoutLadderDialogLayout);
        endGameWithoutLadderDialogLayout.setHorizontalGroup(
                endGameWithoutLadderDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        endGameWithoutLadderDialogLayout.setVerticalGroup(
                endGameWithoutLadderDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel7.setBackground(new java.awt.Color(190, 182, 135));

        jLabel30.setFont(new java.awt.Font("Comic Sans MS", 0, 16));
        jLabel30.setForeground(new java.awt.Color(51, 51, 51));
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("Мешок предметов");

        firstItemButton.setBackground(new java.awt.Color(190, 182, 135));
        firstItemButton.setFont(new java.awt.Font("Comic Sans MS", 0, 12));
        firstItemButton.setText("Малое зелье лечение, 0 шт");
        firstItemButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstItemButtonActionPerformed(evt);
            }
        });

        secondItemButton.setBackground(new java.awt.Color(190, 182, 135));
        secondItemButton.setFont(new java.awt.Font("Comic Sans MS", 0, 12));
        secondItemButton.setText("Большое зелье лечение, 0 шт");
        secondItemButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                secondItemButtonActionPerformed(evt);
            }
        });

        thirdItemButton.setBackground(new java.awt.Color(190, 182, 135));
        thirdItemButton.setFont(new java.awt.Font("Comic Sans MS", 0, 12));
        thirdItemButton.setText("Крест возрождения, 0 шт");

        useItemButton.setBackground(new java.awt.Color(239, 237, 14));
        useItemButton.setFont(new java.awt.Font("Comic Sans MS", 1, 14));
        useItemButton.setText("Использовать");
        useItemButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                useItemButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
                jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel7Layout.createSequentialGroup()
                                                .addGap(120, 120, 120)
                                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(secondItemButton)
                                                        .addComponent(thirdItemButton, javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(firstItemButton, javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel30, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel7Layout.createSequentialGroup()
                                                .addGap(139, 139, 139)
                                                .addComponent(useItemButton)))
                                .addContainerGap(105, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
                jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(firstItemButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(secondItemButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(thirdItemButton)
                                .addGap(50, 50, 50)
                                .addComponent(useItemButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(54, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout itemsBagDialogLayout = new javax.swing.GroupLayout(itemsBagDialog.getContentPane());
        itemsBagDialog.getContentPane().setLayout(itemsBagDialogLayout);
        itemsBagDialogLayout.setHorizontalGroup(
                itemsBagDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        itemsBagDialogLayout.setVerticalGroup(
                itemsBagDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel8.setBackground(new java.awt.Color(243, 120, 120));

        jLabel31.setFont(new java.awt.Font("Comic Sans MS", 1, 18));
        jLabel31.setForeground(new java.awt.Color(51, 51, 51));
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("Вы не можете использовать ");

        jLabel32.setFont(new java.awt.Font("Comic Sans MS", 1, 18));
        jLabel32.setForeground(new java.awt.Color(51, 51, 51));
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setText("этот предмет");

        closeCantUseItemButton.setBackground(new java.awt.Color(204, 204, 204));
        closeCantUseItemButton.setFont(new java.awt.Font("Comic Sans MS", 0, 18));
        closeCantUseItemButton.setForeground(new java.awt.Color(51, 51, 51));
        closeCantUseItemButton.setText("ОК");
        closeCantUseItemButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeCantUseItemButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
                jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel8Layout.createSequentialGroup()
                                .addContainerGap(82, Short.MAX_VALUE)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                                                .addComponent(jLabel31)
                                                .addGap(58, 58, 58))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                                                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(135, 135, 135))))
                        .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(150, 150, 150)
                                .addComponent(closeCantUseItemButton, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
                jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel32)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                                .addComponent(closeCantUseItemButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(52, 52, 52))
        );

        javax.swing.GroupLayout cantUseItemDialogLayout = new javax.swing.GroupLayout(cantUseItemDialog.getContentPane());
        cantUseItemDialog.getContentPane().setLayout(cantUseItemDialogLayout);
        cantUseItemDialogLayout.setHorizontalGroup(
                cantUseItemDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        cantUseItemDialogLayout.setVerticalGroup(
                cantUseItemDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        levelUpLabel.setText("Что улучшить?");

        damageButton.setText("Урон");

        attributesGroup.add(healthButton);
        healthButton.setText("Здоровье");
        healthButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                healthButtonActionPerformed(evt);
            }
        });

        chooseAttributeButton.setText("ОК");
        chooseAttributeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseAttributeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout levelUpLayout = new javax.swing.GroupLayout(levelUp.getContentPane());
        levelUp.getContentPane().setLayout(levelUpLayout);
        levelUpLayout.setHorizontalGroup(
                levelUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(levelUpLayout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(healthButton, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addComponent(damageButton, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, levelUpLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(levelUpLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(83, 83, 83))
                        .addGroup(levelUpLayout.createSequentialGroup()
                                .addGap(89, 89, 89)
                                .addComponent(chooseAttributeButton))
        );
        levelUpLayout.setVerticalGroup(
                levelUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(levelUpLayout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addComponent(levelUpLabel)
                                .addGap(18, 18, 18)
                                .addGroup(levelUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(healthButton)
                                        .addComponent(damageButton))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                                .addComponent(chooseAttributeButton)
                                .addContainerGap())
        );

        setLocationsLabel.setText("Сколько локаций Вы хотите пройти?");

        setLocationsField.setText("3");
        setLocationsField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setLocationsFieldActionPerformed(evt);
            }
        });

        startWithLocationsButton.setText("Старт");
        startWithLocationsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startWithLocationsButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout setLocationsFrameLayout = new javax.swing.GroupLayout(setLocationsFrame.getContentPane());
        setLocationsFrame.getContentPane().setLayout(setLocationsFrameLayout);
        setLocationsFrameLayout.setHorizontalGroup(
                setLocationsFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(setLocationsFrameLayout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addGroup(setLocationsFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(setLocationsFrameLayout.createSequentialGroup()
                                                .addComponent(setLocationsField, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(93, 93, 93)
                                                .addComponent(startWithLocationsButton))
                                        .addComponent(setLocationsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(36, Short.MAX_VALUE))
        );
        setLocationsFrameLayout.setVerticalGroup(
                setLocationsFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(setLocationsFrameLayout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addComponent(setLocationsLabel)
                                .addGap(46, 46, 46)
                                .addGroup(setLocationsFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(setLocationsField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(startWithLocationsButton))
                                .addContainerGap(28, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        StartPanel.setBackground(new java.awt.Color(255, 255, 255));

        MKLabel.setFont(new java.awt.Font("Comic Sans MS", 2, 24));
        MKLabel.setForeground(new java.awt.Color(204, 204, 0));
        MKLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MKLabel.setText("Mortal Kombat");

        startButton.setFont(new java.awt.Font("Comic Sans MS", 0, 12));
        startButton.setText("Начать новую игру");
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

        seeResultsButton.setFont(new java.awt.Font("Comic Sans MS", 0, 12));
        seeResultsButton.setText("Посмотреть таблицу \nрезультатов");
        seeResultsButton.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        seeResultsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seeResultsButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout StartPanelLayout = new javax.swing.GroupLayout(StartPanel);
        StartPanel.setLayout(StartPanelLayout);
        StartPanelLayout.setHorizontalGroup(
                StartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(StartPanelLayout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(seeResultsButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                                .addComponent(startButton, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21))
                        .addGroup(StartPanelLayout.createSequentialGroup()
                                .addGroup(StartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(StartPanelLayout.createSequentialGroup()
                                                .addGap(159, 159, 159)
                                                .addComponent(MKLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(StartPanelLayout.createSequentialGroup()
                                                .addGap(143, 143, 143)
                                                .addComponent(jLabel3)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        StartPanelLayout.setVerticalGroup(
                StartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(StartPanelLayout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addComponent(MKLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                                .addGroup(StartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(seeResultsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(startButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(StartPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(StartPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );

        pack();
    }

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {
        setLocationsFrame.setVisible(true);
        setLocationsFrame.setBounds(300, 200, 430, 350);
    }

    private void attackButtonActionPerformed(java.awt.event.ActionEvent evt) {
        ActionFactory hitFactory = new HitFactory();
        helper.fight.turn(hitFactory, helper.getResults(), locationsNumber, helper.getEnemies());
    }

    private void defenseButtonActionPerformed(java.awt.event.ActionEvent evt) {
        ActionFactory defenseFactory = new DefenseFactory();
        helper.fight.turn(defenseFactory, helper.getResults(), locationsNumber, helper.getEnemies());
    }

    private void nextRoundButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if (helper.fight.checkExperience(helper.fight.getHuman())) {
            helper.fight.levelUp(helper.fight.getHuman());
            levelUp.setVisible(true);
            this.setPanelEnabled(getFightPanel(), false);
            levelUp.setBounds(300, 200, 430, 350);
        }

        if (helper.fight.location.isLocationCleared()) {
            System.out.println("Локация " + helper.fight.location.getCurrentLocation() + " пройдена!");

            helper.fight.location.resetLocation(true, helper.fight.getHuman().getLevel());

            System.out.println("Начинается локация " + helper.fight.location.getCurrentLocation());
        }

        helper.fight.setEnemy(helper.fight.location.getNextEnemy());

        locationLabel.setText("Локация: " + helper.fight.location.getCurrentLocation() + "/" + locationsNumber);
        enemyNumberLabel.setText("Враг: " + helper.fight.location.getCurrentEnemyNumber() + "/" + helper.fight.location.getTotalEnemiesInLocation());

        enemyIconLabel.setIcon(helper.fight.getEnemy().getPhoto());
        enemyDamageValueLabel.setText(Integer.toString(helper.fight.getEnemy().getDamage()));
        enemyHealthLabel.setText(Integer.toString(helper.fight.getEnemy().getHealth()) + "/" + Integer.toString(helper.fight.getEnemy().getMaxHealth()));
        enemyHeroLabel.setText(helper.fight.getEnemy().getName());
        enemyHealthBar.setMaximum(helper.fight.getEnemy().getMaxHealth());

        helper.fight.newRound();

        controller.setNewRoundTexts(helper.fight.getHuman(), helper.fight.getEnemy(), helper.fight.getHuman().getItems());

        endFightDialog.dispose();
        setPanelEnabled(fightPanel, true);
    }

    private void enterNameFieldActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void endGameButtonActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            helper.endGameTop(helper.fight.getHuman(), enterNameField, recordsTable);
        } catch (IOException ex) {
            Logger.getLogger(GameView.class.getName()).log(Level.SEVERE, null, ex);
        }
        endGameDialog.dispose();
        enterNameField.setText("");
    }

    private void closeRecordsTableButtonActionPerformed(java.awt.event.ActionEvent evt) {
        recordsTableDialog.dispose();
    }

    private void seeResultsButtonActionPerformed(java.awt.event.ActionEvent evt) {
        recordsTableDialog.setVisible(true);
        recordsTableDialog.setBounds(100, 100, 580, 450);
    }

    private void endGameWithoutLadderButtonActionPerformed(java.awt.event.ActionEvent evt) {
        endGameWithoutLadderDialog.dispose();
    }

    private void firstItemButtonActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void secondItemButtonActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void useItemButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if (firstItemButton.isSelected()) {
            nameButton = "First item";
        }
        if (secondItemButton.isSelected()) {
            nameButton = "Second item";
        }
        if (thirdItemButton.isSelected()) {
            nameButton = "Third item";
        }
        Player player = helper.fight.getHuman();
        helper.fight.useItem(player, player.getItems(), nameButton, controller);
        controller.setHealthBar(player);
        playerHealthLabel.setText(player.getHealth() + "/" + player.getMaxHealth());
        controller.setBagText(player.getItems());
    }

    private void itemsButtonActionPerformed(java.awt.event.ActionEvent evt) {
        itemsBagDialog.setVisible(true);
        itemsBagDialog.setBounds(300, 200, 430, 350);
    }

    private void closeCantUseItemButtonActionPerformed(java.awt.event.ActionEvent evt) {
        cantUseItemDialog.dispose();
    }

    private void debuffButtonActionPerformed(java.awt.event.ActionEvent evt) {
        ActionFactory weakenFactory = new WeakenFactory();
        helper.fight.turn(weakenFactory, helper.getResults(), locationsNumber, helper.getEnemies());
    }

    private void healthButtonActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void setLocationsFieldActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void startWithLocationsButtonActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            locationsNumber = Integer.parseInt(setLocationsField.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(setLocationsFrame, "Пожалуйста, введите число.");
            return;
        }
        if (locationsNumber <= 0) {
            JOptionPane.showMessageDialog(setLocationsFrame, "Количество локаций должно быть больше нуля.");
            return;
        }

        setLocationsFrame.setVisible(false);

        helper.fight.setHuman(helper.newHuman(controller, items));
        helper.fight.location.resetLocation(true, helper.fight.getHuman().getLevel());

        locationLabel.setText("Локация: " + helper.fight.location.getCurrentLocation() + "/" + locationsNumber);
        enemyNumberLabel.setText("Враг: " + helper.fight.location.getCurrentEnemyNumber() + "/" + helper.fight.location.getTotalEnemiesInLocation());

        fightFrame.setVisible(true);
        fightFrame.setSize(1000, 700);

        helper.fight.setEnemy(helper.fight.location.getNextEnemy());

        enemyIconLabel.setIcon(helper.fight.getEnemy().getPhoto());
        enemyDamageValueLabel.setText(Integer.toString(helper.fight.getEnemy().getDamage()));
        enemyHealthLabel.setText(helper.fight.getEnemy().getHealth() + "/" + helper.fight.getEnemy().getMaxHealth());
        enemyHeroLabel.setText(helper.fight.getEnemy().getName());

        helper.fight.newRound();

        controller.setNewRoundTexts(helper.fight.getHuman(), helper.fight.getEnemy(), helper.fight.getHuman().getItems());

        endFightDialog.dispose();
    }

    private void chooseAttributeButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if (!healthButton.isSelected() && !damageButton.isSelected()) {
            JOptionPane.showMessageDialog(
                    levelUp,
                    "Пожалуйста, выберите что улучшить: здоровье или урон.",
                    "Ошибка выбора",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        if (healthButton.isSelected()) {
            helper.fight.addHealthToPlayer(helper.fight.getHuman());
        } else {
            helper.fight.addDamageToPlayer(helper.fight.getHuman());
        }

        controller.setNewRoundTexts(helper.fight.getHuman(), helper.fight.getEnemy(), helper.fight.getHuman().getItems());

        attributesGroup.clearSelection();

        levelUp.dispose();
        setPanelEnabled(fightPanel, true);
    }

    public void setPanelEnabled(JPanel panel, Boolean isEnabled) {
        if (levelUp.isVisible()) return;
        panel.setEnabled(isEnabled);
        Component[] components = panel.getComponents();
        for (Component component : components) {
            if (component instanceof JPanel) {
                setPanelEnabled((JPanel) component, isEnabled);
            }
            component.setEnabled(isEnabled);
        }
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> {
            new GameView().setVisible(true);
        });
    }

    private javax.swing.JLabel MKLabel;
    private javax.swing.JPanel StartPanel;
    private javax.swing.JButton attackButton;
    private javax.swing.ButtonGroup attributesGroup;
    private javax.swing.JDialog cantUseItemDialog;
    private javax.swing.JButton chooseAttributeButton;
    private javax.swing.JButton closeCantUseItemButton;
    private javax.swing.JButton closeRecordsTableButton;
    private javax.swing.JRadioButton damageButton;
    private javax.swing.JButton debuffButton;
    private javax.swing.JButton defenseButton;
    private javax.swing.JDialog endFightDialog;
    private javax.swing.JButton endGameButton;
    private javax.swing.JDialog endGameDialog;
    private javax.swing.JButton endGameWithoutLadderButton;
    private javax.swing.JDialog endGameWithoutLadderDialog;
    private javax.swing.JLabel endGameWithoutLadderTitlleLabel;
    private javax.swing.JLabel endRoundLabel;
    private javax.swing.JLabel enemyActionLabel;
    private javax.swing.JLabel enemyDamageLabel;
    private javax.swing.JLabel enemyDamageValueLabel;
    private javax.swing.JLabel enemyDebuffLabel;
    private javax.swing.JProgressBar enemyHealthBar;
    private javax.swing.JLabel enemyHealthLabel;
    private javax.swing.JLabel enemyHeroLabel;
    private javax.swing.JLabel enemyIconLabel;
    private javax.swing.JLabel enemyLevelLabel;
    private javax.swing.JLabel enemyNumberLabel;
    private javax.swing.JTextField enterNameField;
    private javax.swing.JLabel enterNameLabel;
    private javax.swing.JLabel enterNameLabelBottom;
    private javax.swing.JLabel experienceLabel;
    private javax.swing.JLabel experienceValueLabel;
    private javax.swing.JFrame fightFrame;
    private javax.swing.JLabel fightLabel;
    private javax.swing.JPanel fightPanel;
    private javax.swing.JRadioButton firstItemButton;
    private javax.swing.JRadioButton healthButton;
    private javax.swing.JDialog itemsBagDialog;
    private javax.swing.JButton itemsButton;
    private javax.swing.ButtonGroup itemsGroup;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JFrame levelUp;
    private javax.swing.JLabel levelUpLabel;
    private javax.swing.JLabel locationLabel;
    private javax.swing.JButton nextRoundButton;
    private javax.swing.JLabel notInLadderLabel;
    private javax.swing.JLabel playerActionLabel;
    private javax.swing.JLabel playerCharacterNameLabel;
    private javax.swing.JLabel playerDamageLabel;
    private javax.swing.JLabel playerDamageValueLabel;
    private javax.swing.JLabel playerDebuffLabel;
    private javax.swing.JProgressBar playerHealthBar;
    private javax.swing.JLabel playerHealthLabel;
    private javax.swing.JLabel playerIconLabel;
    private javax.swing.JLabel playerLevelLabel;
    private javax.swing.JLabel pointsTitleLabel;
    private javax.swing.JLabel pointsValueLabel;
    private javax.swing.JTable recordsTable;
    private javax.swing.JDialog recordsTableDialog;
    private javax.swing.JRadioButton secondItemButton;
    private javax.swing.JButton seeResultsButton;
    private javax.swing.JTextField setLocationsField;
    private javax.swing.JFrame setLocationsFrame;
    private javax.swing.JLabel setLocationsLabel;
    private javax.swing.JButton startButton;
    private javax.swing.JButton startWithLocationsButton;
    private javax.swing.JLabel stunLabel;
    private javax.swing.JRadioButton thirdItemButton;
    private javax.swing.JButton useItemButton;
    private javax.swing.JLabel victoryLabel;
}
