/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JTextField;

/**
 *
 * @author Shazzama.Pajama
 */
public class GUIGrid {
    private JTextField[][] Grid;
    
    public GUIGrid(){
        Grid = new JTextField[20][20];
        
        for(int row=0; row<20; row++){
            for(int col=0; col<20; col++){
                JTextField cell = new JTextField();
                cell.addMouseListener(new java.awt.event.MouseAdapter(){
                    @Override
                    public void mouseClicked(java.awt.event.MouseEvent evt){
                        changeColor(evt);
                        
                    }
                });
                
                
                cell.setBorder(BorderFactory.createLineBorder(Color.black));
                Grid[row][col] = cell;
            }
        }
    }
    
    public JTextField getCell(int row, int col){
        return Grid[row][col];
    }
    
    public JTextField[][] getGrid(){
        return this.Grid;
    }
    
    public void changeColor(java.awt.event.MouseEvent evt){
        if(evt.getClickCount() == 2){
            JTextField textfield = (JTextField)evt.getSource();
            textfield.setBackground(Color.green);
        }
        
    }
}
