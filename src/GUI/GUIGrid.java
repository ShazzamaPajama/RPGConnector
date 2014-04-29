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
        Grid = new JTextField[25][25];
        
        for(int row=0; row<25; row++){
            for(int col=0; col<25; col++){
                JTextField cell = new JTextField();
                cell.setSize(new Dimension(500,500));
                cell.setBorder(BorderFactory.createLineBorder(Color.black));
            }
        }
    }
    
    public JTextField getCell(int row, int col){
        return Grid[row][col];
    }
    
    public JTextField[][] getGrid(){
        return this.Grid;
    }
}
