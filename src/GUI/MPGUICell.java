/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import Networking.Client.RPGConnectorClient;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
        
        //add listeners
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                if(evt.getClickCount() == 2){
                    listener.sendColorUpdate(Row, Col, GridParent.getColorChanger());
                }
            }
        });
        
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                    if (getText().trim().length() != 0) {
                        String token = getText().substring(0, 1);
                        listener.sendTokenUpdate(Row, Col, token);
                        setText("");
                    } else {
                        listener.sendTokenUpdate(Row, Col, "");
                        setText("");
                    }
                }
            }
        });
        
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
    
    public String GetColorChange(){
        return this.GridParent.getColorChanger();
    }
}
