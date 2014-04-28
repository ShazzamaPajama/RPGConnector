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
public class BasicInfoModel extends ArrayOfRowsModel {
    
    
    public BasicInfoModel(){
        ColumnNames = new String[]{
            "Name", "Race", "Type", "Class", "Alignment", "Level", "HP", "AC", "AtkBonus"};
        rows = new ArrayList<>();
    }
    
    public BasicInfoModel(ArrayList<ArrayList<Object>> rowset){
        ColumnNames = new String[]{"Name", "Race", "Type", "Class", "Alignment", "Level", "HP", "AC" , "AtkBonus"};
        rows = rowset;
    }
    
    public void addRow(String Name, String Race, String Type, String Class, String Alignment, Integer Level, Integer HP, Integer AC, Integer AtkBonus){
        ArrayList<Object> newrow = new ArrayList<>();
        newrow.add(Name);
        newrow.add(Race);
        newrow.add(Type);
        newrow.add(Class);
        newrow.add(Alignment);
        newrow.add(Level);
        newrow.add(HP);
        newrow.add(AC);
        newrow.add(AtkBonus);
        
        rows.add(newrow);
    }
    
    public void setTable(ArrayList<ArrayList<Object>> rowset){
        rows = rowset;
    }
    
    
}
