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
public abstract class ParallelValueModel extends AbstractTableModel {
   protected ArrayList<String> Labels;
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
    public boolean isCellEditable(int row, int col){
        if (col == 0){
            return false;
        }else{
            return true;
        }
    }
    
   
}
