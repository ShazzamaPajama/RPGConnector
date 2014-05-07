/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import Networking.Client.RPGConnectorClient;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JTextField;

/**
 *
 * @author ShazzamaPajama
 */
public class MPGUICell extends JTextField {
    private RPGConnectorClient listener;
    private MPGUIGrid GridParent;
    private int Row;
    private int Col;
    
    public MPGUICell(int row, int col, RPGConnectorClient client, MPGUIGrid parent){
        listener = client;
        GridParent = parent;
        Row = row;
        Col = col;
        
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
    
    public void ChangeColor(Color newcolor){
        this.setBackground(newcolor);
    }
    
    public int getRow(){
        return Row;
    }
    
    public int getCol(){
        return Col;
    }
    
    public Color GetColorChange(){
        return this.GridParent.getColorChanger();
    }
}
