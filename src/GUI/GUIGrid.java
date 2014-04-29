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
    private GUICell[][] Grid;
    private Color ColorChanger;
    
    public GUIGrid(){
        Grid = new GUICell[20][20];
        ColorChanger = Color.WHITE;
        
        for(int row=0; row<20; row++){
            for(int col=0; col<20; col++){
                GUICell cell = new GUICell(this);
                
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
    
    public void changeColorValue(Color c){
        ColorChanger = c;
    }
    
    public Color getColorChanger(){
        return this.ColorChanger;
    }
}
