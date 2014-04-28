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
        
        rows = new ArrayList<>();
    }
    
    public AbilityModel(ArrayList<ArrayList<Object>> table){
        ColumnNames = new String[]{"Name", "Race", "Type", "STR", "CON", "DEX", "INT", "WIS", "CHA"};
        rows = table;
    }
    
    public void addRow(String Name, String Race, String Type, Integer str, Integer con, Integer dex, Integer intelligence, Integer wis, Integer cha){
        ArrayList<Object> newrow = new ArrayList<>();
        newrow.add(Name);
        newrow.add(Race);
        newrow.add(Type);
        newrow.add(str);
        newrow.add(con);
        newrow.add(dex);
        newrow.add(intelligence);
        newrow.add(wis);
        newrow.add(cha);
        
        rows.add(newrow);
    }
}
