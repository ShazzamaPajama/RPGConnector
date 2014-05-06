/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.ListIterator;
import javax.swing.JTextField;

/**
 *
 * @author Amie
 */
public class LocalGUICell extends JTextField {
    ArrayList<Color> Colors;
    ListIterator<Color> ColorIterator;
    LocalGUIGrid GridParent;
    
    public LocalGUICell(LocalGUIGrid gridparent){
        GridParent = gridparent;
        
        this.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent evt){
                if(evt.getClickCount() == 2){
                    ChangeColor(GridParent.getColorChanger());
                }
            }
        });
    }
    
    public void ChangeColor(Color c){
        this.setBackground(c);
    }
    
}
