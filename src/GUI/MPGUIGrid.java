/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import Networking.Client.RPGConnectorClient;
import java.awt.Color;

/**
 *
 * @author ShazzamaPajama
 */
public class MPGUIGrid {
    private String CurrentColorChanger;
    private MPGUICell[][] Grid;
    
    
    public MPGUIGrid(){
        CurrentColorChanger = "White";
        Grid = new MPGUICell[20][20];
        
    }
    
    public void initGrid(RPGConnectorClient client){
        for (int row=0; row<20;row++){
            for(int col=0; col<20; col++){
                MPGUICell newcell = new MPGUICell(row,col, client, this);
                Grid[row][col] = newcell;
            }
        }
    }
    
    public String getColorChanger(){
        return this.CurrentColorChanger;
    }
    
    public void SetColorChanger(String color){
        this.CurrentColorChanger = color;
    }
    
    public MPGUICell getCell(int row, int col){
        return Grid[row][col];
    }
}
