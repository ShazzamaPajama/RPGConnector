/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import AssetDB.DBManager;
import GUI.TableModels.ParallelAbilityModel;
import GUI.TableModels.ParallelBasicModel;
import GUI.TableModels.ParallelSkillModel;
import GUI.TableModels.ParallelValueModel;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ListIterator;

/**
 *
 * @author Shazzama.Pajama
 */
public class CharacterSheet extends javax.swing.JFrame {
    private ParallelBasicModel BasicInfo;
    private ParallelAbilityModel AbilityInfo;
    private ParallelSkillModel SkillInfo;
    private DBManager Database;
    
    /**
     * Creates new form NewJFrame
     */
    public CharacterSheet(DBManager DB) {
        initComponents();
        BasicInfo = new ParallelBasicModel();
        AbilityInfo = new ParallelAbilityModel();
        SkillInfo = new ParallelSkillModel();
        Database = DB;
        
        jTableBasic.setModel(BasicInfo);
        jTableAbility.setModel(AbilityInfo);
        jTableSkill.setModel(SkillInfo);
        
    }
    
    public CharacterSheet(ArrayList<Object> basic, ArrayList<Object> ability, ArrayList<Object> skill, String Description, String Extras, DBManager DB){
        initComponents();
        BasicInfo = new ParallelBasicModel(basic);
        AbilityInfo = new ParallelAbilityModel(ability);
        SkillInfo = new ParallelSkillModel(skill);
        Database = DB;
        
        jTableBasic.setModel(BasicInfo);
        jTableAbility.setModel(AbilityInfo);
        jTableSkill.setModel(SkillInfo);
        jTextAreaDescription.setText(Description);
        jTextAreaExtras.setText(Extras);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane5 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabelTitle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableAbility = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableSkill = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextAreaDescription = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextAreaExtras = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTableBasic = new javax.swing.JTable();

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane5.setViewportView(jTable3);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabelTitle.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelTitle.setText("Character Sheet");

        jScrollPane1.setViewportView(jTableAbility);

        jScrollPane2.setViewportView(jTableSkill);

        jTextAreaDescription.setColumns(20);
        jTextAreaDescription.setLineWrap(true);
        jTextAreaDescription.setRows(5);
        jTextAreaDescription.setWrapStyleWord(true);
        jScrollPane3.setViewportView(jTextAreaDescription);

        jLabel10.setText("Description:");

        jTextAreaExtras.setColumns(20);
        jTextAreaExtras.setLineWrap(true);
        jTextAreaExtras.setRows(5);
        jTextAreaExtras.setWrapStyleWord(true);
        jScrollPane4.setViewportView(jTextAreaExtras);

        jLabel11.setText("Extra Attacks / Spells / Abilities:");

        jButton1.setText("Save Character");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("New Character");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jScrollPane6.setViewportView(jTableBasic);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabelTitle)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel10))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(jButton1)
                .addGap(67, 67, 67)
                .addComponent(jButton2)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTitle)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        new CharacterSheet(this.Database).setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ParallelValueModel Basic = (ParallelValueModel)jTableBasic.getModel();
        ParallelValueModel Abilities = (ParallelValueModel)jTableAbility.getModel();
        ParallelValueModel Skills = (ParallelValueModel)jTableSkill.getModel();
        
        ListIterator BasicIterator = Basic.getIterator();
        ListIterator AbilityIterator = Abilities.getIterator();
        ListIterator SkillIterator = Skills.getIterator();
        
        String Name = BasicIterator.next().toString();
        System.out.println("Name = " + Name) ;
        String Race = BasicIterator.next().toString();
        System.out.println("race = " + Race);
        String Type = BasicIterator.next().toString();
        System.out.println("Type = " + Type);
        
        try{
            
            
            Database.addSkillSet(Name, Race, Type);
            
            while(SkillIterator.hasNext()){
                String value = SkillIterator.next().toString();
                Integer Score;
                if(value.equals("")){
                   Score = 0;
                }else{
                    Score = Integer.parseInt(value);
                }
                
                Database.updateSkill(Name, Race, Type, Type, Score );
            }
            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTableAbility;
    private javax.swing.JTable jTableBasic;
    private javax.swing.JTable jTableSkill;
    private javax.swing.JTextArea jTextAreaDescription;
    private javax.swing.JTextArea jTextAreaExtras;
    // End of variables declaration//GEN-END:variables
}
