/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Shazzama.Pajama
 */
public class BasicInfoModel extends AbstractTableModel {
    String[]  ColumnNames;
    ArrayList<ArrayList<Object>> rows;
    
    
    
    public BasicInfoModel(){
        ColumnNames = new String[]{"Name", "Race", "Type", "Class", "Alignment", "Level", "HP", "AtkBonus"};
        rows = new ArrayList<>();
    }
    
    public BasicInfoModel(ArrayList<ArrayList<Object>> rowset){
        ColumnNames = new String[]{"Name", "Race", "Type", "Class", "Alignment", "Level", "HP", "AtkBonus"};
        rows = rowset;
    }
    
    public void addRow(String Name, String Race, String Type, String Class, String Alignment, Integer Level, Integer HP, Integer AtkBonus){
        ArrayList<Object> newrow = new ArrayList<>();
        newrow.add(Name);
        newrow.add(Race);
        newrow.add(Type);
        newrow.add(Class);
        newrow.add(Alignment);
        newrow.add(Level);
        newrow.add(HP);
        newrow.add(AtkBonus);
        
        rows.add(newrow);
    }
    
    @Override
    public int getRowCount() {
        return rows.size();
    }
    
    @Override
    public String getColumnName(int col){
        return ColumnNames[col];
    }
    
    @Override
    public int getColumnCount() {
        return ColumnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ArrayList<Object> row = rows.get(rowIndex);
        
        return row.get(columnIndex);
        
    }
    
}
