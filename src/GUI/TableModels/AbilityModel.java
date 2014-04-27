/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI.TableModels;

import GUI.TableModels.ArrayOfRowsModel;
import java.util.ArrayList;

/**
 *
 * @author Shazzama.Pajama
 */
public class AbilityModel extends ArrayOfRowsModel {
    
    public AbilityModel(){
        ColumnNames = new String[]{"STR", "CON", "DEX", "INT", "WIS", "CHA"};
        rows = new ArrayList<>();
    }
    
    public void addRow(Integer str, Integer con, Integer dex, Integer intelligence, Integer wis, Integer cha){
        ArrayList<Object> newrow = new ArrayList<>();
        newrow.add(str);
        newrow.add(con);
        newrow.add(dex);
        newrow.add(intelligence);
        newrow.add(wis);
        newrow.add(cha);
        
        rows.add(newrow);
    }
}
