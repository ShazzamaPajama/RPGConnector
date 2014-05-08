/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI.TableModels;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Shazzama.Pajama
 */
public class ItemTableModel extends AbstractTableModel {
    private String[] ColumnNames;
    private ArrayList<ArrayList<Object>> table;
    
    public ItemTableModel(){
      
            ColumnNames = new String[]{"Name", "Type", "Price"};
            table = new ArrayList<>();
            
        
    }
    
    public void addRows(ResultSet rows) throws SQLException{
        while(rows.next()){
            ArrayList<Object> row = new ArrayList<>();
            row.add(rows.getString("Name"));
            row.add(rows.getString("Type"));
            row.add(rows.getInt("Price"));
            
            table.add(row);
        }
    }
    
    @Override
    public String getColumnName(int Colindex){
        return ColumnNames[Colindex];
    }
    
    @Override
    public int getRowCount() {
        return table.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return table.get(rowIndex).get(columnIndex);
    }
    
    public String getName(int row){
        return (String)table.get(row).get(0);
    }
    
    public String getType(int row){
        return (String)table.get(row).get(1);
    }
    
    
}
