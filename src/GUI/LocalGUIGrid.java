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
public class LocalGUIGrid {
    private LocalGUICell[][] Grid;
    private String ColorChanger;
    
    public LocalGUIGrid(){
        Grid = new LocalGUICell[20][20];
        ColorChanger = "White";
        
        for(int row=0; row<20; row++){
            for(int col=0; col<20; col++){
                LocalGUICell cell = new LocalGUICell(this);
                
                cell.setBorder(BorderFactory.createLineBorder(Color.black));
                Grid[row][col] = cell;
            }
        }
    }
    
    public LocalGUICell getCell(int row, int col){
        return Grid[row][col];
    }
    
    public JTextField[][] getGrid(){
        return this.Grid;
    }
    
    public void changeColorValue(String c){
        ColorChanger = c;
    }
    
    public String getColorChanger(){
        return this.ColorChanger;
    }
}
