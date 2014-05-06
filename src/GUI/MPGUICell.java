/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import Networking.Client.RPGConnectorClient;
import java.awt.Color;
import javax.swing.JTextField;

/**
 *
 * @author ShazzamaPajama
 */
public class MPGUICell extends JTextField {
    RPGConnectorClient listener;
    MPGUIGrid GridParent;
    
    public MPGUICell(RPGConnectorClient client, MPGUIGrid parent){
        listener = client;
        GridParent = parent;
        
        
        
    }
    
    public void ChangeColor(Color newcolor){
        this.setBackground(newcolor);
    }
}
