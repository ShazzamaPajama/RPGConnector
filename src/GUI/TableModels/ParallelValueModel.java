/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI.TableModels;

import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Shazzama.Pajama
 */
public class ParallelValueModel extends AbstractTableModel {
    ArrayList<String> Labels;
    ArrayList<Object> Values;
    String[] Columns;
    
    public ParallelValueModel(String[] labels, Object[] values, String[] ColumnNames){
        Labels = new ArrayList<>();
        Values = new ArrayList<>();
        Columns = ColumnNames;
        
        Labels.addAll(Arrays.asList(labels));
        Values.addAll(Arrays.asList(values));
    }
    
    public ParallelValueModel(String[]labels, String[] ColumnNames){
        Labels = new ArrayList<>();
        Values = new ArrayList<>();
        Columns = ColumnNames;
        
        Labels.addAll(Arrays.asList(labels));
        for(String i : Labels){
            Values.add("");
        }
    }

    @Override
    public String getColumnName(int col){
        return Columns[col];
    }
    
    @Override
    public int getRowCount() {
        return Labels.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if(columnIndex == 0){
            return Labels.get(rowIndex);
        }else{
            return Values.get(rowIndex);
        }
    }
    
    @Override
    public boolean isCellEditable(int row, int col){
        if (col == 0){
            return false;
        }else{
            return true;
        }
    }
}
