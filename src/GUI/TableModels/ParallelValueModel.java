/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI.TableModels;

import java.util.ArrayList;
import java.util.ListIterator;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Shazzama.Pajama
 */
public abstract class ParallelValueModel extends AbstractTableModel {
   protected ArrayList<String> Labels;
   protected ArrayList<Object> Values;
   protected String[] Columns;
    

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
    
   @Override
    public void setValueAt(Object val, int row, int col){
        
    }
    
    public ListIterator<Object> getIterator(){
        return this.Values.listIterator();
    }
}
