/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import AssetDB.DBManager;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Shazzama.Pajama
 */
public class DnDDatabase extends javax.swing.JFrame {
    private DBManager dbManager;
    private BasicInfoModel BasicInfo;
    
    /**
     * Creates new form DnDDatabase
     */
    public DnDDatabase() {
        BasicInfo = new BasicInfoModel();
        BasicInfo.addRow("John", "orc", "NPC", "Paladin", "Neutral Good", 12, 85, 10);
        initComponents();
        dbManager = new DBManager();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabelTitle = new javax.swing.JLabel();
        jTextFieldName = new javax.swing.JTextField();
        jTextFieldRace = new javax.swing.JTextField();
        jTextFieldType = new javax.swing.JTextField();
        jLabelName = new javax.swing.JLabel();
        jLabelRace = new javax.swing.JLabel();
        jLabelType = new javax.swing.JLabel();
        jButtonSearchCharacter = new javax.swing.JButton();
        jLabelAbility = new javax.swing.JLabel();
        jComboBoxAb = new javax.swing.JComboBox();
        jButtonPageLeft = new javax.swing.JButton();
        jButtonPageRight = new javax.swing.JButton();
        jButtonSearchAb = new javax.swing.JButton();
        jTextFieldAb = new javax.swing.JTextField();
        jLabelAbVal = new javax.swing.JLabel();
        jLabelBasic = new javax.swing.JLabel();
        jComboBoxBasic = new javax.swing.JComboBox();
        jTextField1 = new javax.swing.JTextField();
        jLabelStatVal = new javax.swing.JLabel();
        jButtonSearchBasic = new javax.swing.JButton();
        jLabelSkill = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jTextFieldSkillVal = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabelSkillVal = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable2.setModel(BasicInfo);
        jScrollPane2.setViewportView(jTable2);

        jLabelTitle.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelTitle.setText("D&D Asset Database");

        jTextFieldType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTypeActionPerformed(evt);
            }
        });

        jLabelName.setText("Name:");

        jLabelRace.setText("Race");

        jLabelType.setText("Type");

        jButtonSearchCharacter.setText("Search");

        jLabelAbility.setText("Ability:");

        jComboBoxAb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "STR", "CON", "DEX", "INT", "WIS", "CHA" }));

        jButtonPageLeft.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButtonPageLeft.setText("<");

        jButtonPageRight.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButtonPageRight.setText(">");

        jButtonSearchAb.setText("Search");

        jLabelAbVal.setText("Value:");

        jLabelBasic.setText("Basic Stat:");

        jComboBoxBasic.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Name", "Race", "Type", "Class", "Alignment", "Level", "HP", "AtkBonus" }));

        jLabelStatVal.setText("Value");

        jButtonSearchBasic.setText("Search");

        jLabelSkill.setText("Skill:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Acrobatics", "Arcana", "Athletics", "Bluff", "Diplomacy", "Dungeoneering", "Endurance", "Heal", "History", "Insight", "Intimidate", "Nature", "Perception", "Religion", "Stealth", "Streetwise", "Thievery" }));

        jButton1.setText("Search");

        jLabelSkillVal.setText("Value:");

        jButton2.setText("ViewCharacter");

        jButton3.setText("Add Character");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelTitle)
                .addGap(341, 341, 341))
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelName)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jTextFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabelType)
                                    .addGap(53, 53, 53)
                                    .addComponent(jTextFieldType, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jTextFieldRace, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabelRace)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(124, 124, 124)
                                .addComponent(jButtonSearchCharacter)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(92, 92, 92)
                                .addComponent(jButtonSearchAb)
                                .addGap(33, 33, 33))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelBasic)
                                    .addComponent(jLabelStatVal))
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButtonSearchBasic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBoxBasic, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextField1))
                                .addGap(61, 61, 61)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabelAbility)
                                    .addComponent(jLabelAbVal))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jComboBoxAb, 0, 125, Short.MAX_VALUE)
                                    .addComponent(jTextFieldAb))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelSkill)
                                    .addComponent(jLabelSkillVal))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextFieldSkillVal)
                                    .addComponent(jComboBox1, 0, 125, Short.MAX_VALUE))
                                .addGap(48, 48, 48))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(78, 78, 78))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonPageLeft)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 818, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonPageRight)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addGap(18, 18, 18)
                                .addComponent(jButton3)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabelTitle)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(jButtonPageLeft))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(jButtonPageRight))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelName)
                            .addComponent(jTextFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldRace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelRace))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelType))
                        .addGap(18, 18, 18)
                        .addComponent(jButtonSearchCharacter))
                    .addComponent(jLabelBasic)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabelAbility, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jComboBoxAb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabelSkill))
                            .addComponent(jComboBoxBasic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextFieldAb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabelAbVal))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabelStatVal)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonSearchBasic)
                            .addComponent(jButtonSearchAb)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelSkillVal)
                            .addComponent(jTextFieldSkillVal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTypeActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        new CharacterSheet().setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButtonPageLeft;
    private javax.swing.JButton jButtonPageRight;
    private javax.swing.JButton jButtonSearchAb;
    private javax.swing.JButton jButtonSearchBasic;
    private javax.swing.JButton jButtonSearchCharacter;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBoxAb;
    private javax.swing.JComboBox jComboBoxBasic;
    private javax.swing.JLabel jLabelAbVal;
    private javax.swing.JLabel jLabelAbility;
    private javax.swing.JLabel jLabelBasic;
    private javax.swing.JLabel jLabelName;
    private javax.swing.JLabel jLabelRace;
    private javax.swing.JLabel jLabelSkill;
    private javax.swing.JLabel jLabelSkillVal;
    private javax.swing.JLabel jLabelStatVal;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JLabel jLabelType;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextFieldAb;
    private javax.swing.JTextField jTextFieldName;
    private javax.swing.JTextField jTextFieldRace;
    private javax.swing.JTextField jTextFieldSkillVal;
    private javax.swing.JTextField jTextFieldType;
    // End of variables declaration//GEN-END:variables
}
