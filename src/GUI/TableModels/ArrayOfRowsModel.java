/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI.TableModels;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Shazzama.Pajama
 */
public abstract class ArrayOfRowsModel extends AbstractTableModel {
    protected String[]  ColumnNames;
    protected ArrayList<ArrayList<Object>> rows;
    
    public void removeAll(){
        rows.removeAll(rows);
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
    
    public ArrayList<Object> getRow(int RowIndex){
        return rows.get(RowIndex);
    }
    
}
