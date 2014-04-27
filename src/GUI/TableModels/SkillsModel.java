/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI.TableModels;

import java.util.ArrayList;

/**
 *
 * @author Shazzama.Pajama
 */
public class SkillsModel extends ArrayOfRowsModel{
    
    public SkillsModel(String skill){
        ColumnNames = new String[]{"Name", "Race", "Type", skill};
        rows = new ArrayList<>();
    }
    
    public void addRow(String Name, String Race, String Type, Integer Value){
        ArrayList<Object> newrow = new ArrayList<>();
        newrow.add(Name);
        newrow.add(Race);
        newrow.add(Type);
        newrow.add(Value);
        
        rows.add(newrow);
    }
}
