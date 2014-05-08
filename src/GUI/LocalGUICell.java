/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import javax.swing.JTextField;

/**
 *
 * @author Amie
 */
public class LocalGUICell extends JTextField {
    HashMap<String,Color> Colors;
    LocalGUIGrid GridParent;
    String color;
    
    public LocalGUICell(LocalGUIGrid gridparent){
        this.initColors();
        color = "White";
        GridParent = gridparent;
        
        this.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent evt){
                if(evt.getClickCount() == 2){
                    ChangeColor(GridParent.getColorChanger());
                }
            }
        });
        
        
    }
    
    private void initColors(){
        Colors = new HashMap<>();
        Colors.put("White", Color.WHITE);
        Colors.put("Green", Color.GREEN);
        Colors.put("Red", Color.RED.brighter());
        Colors.put("Blue", Color.BLUE.brighter());
        Colors.put("Orange", Color.ORANGE);
        Colors.put("Black", Color.BLACK);
    }
    
    public void ChangeColor(String c) {
        if (Colors.containsKey(c)) {
            this.setBackground(Colors.get(c));
            this.color = c;
        }
        
    }
    
    public String getToken(){
        if (this.getText().trim().length() !=0){
            return this.getText().substring(0, 1);
        }else{
            return "";
        }
    }
    
    public String getColor(){
        return color;
    }
    
    public String setToken(String token){
        this.setText(token);
    }
}
