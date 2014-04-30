/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI.TableModels;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListIterator;

/**
 *
 * @author Shazzama.Pajama
 */
public class ParallelBasicModel extends ParallelValueModel {
    private ArrayList<String> Values;
    
    public ParallelBasicModel(){
        String[] titles = new String[] {"Name", "Race", "Type", "Class", "Alignment"};
        Labels = new ArrayList<>();
        Values = new ArrayList<>();
        Columns = new String[]{"BasicInfo", "Values"};
        
        Labels.addAll(Arrays.asList(titles));
        for (String i: Labels){
            Values.add("");
        }        
    }
    
    public ParallelBasicModel(ArrayList<String> values){
        String[] titles = new String[] {"Name", "Race", "Type", "Class", "Alignment"};
        Labels = new ArrayList<>();
        Values = values;
        Columns = new String[]{"BasicInfo", "Values"};
        
        Labels.addAll(Arrays.asList(titles));
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
    public void setValueAt(Object val, int row, int col){
        if(col == 1){
            try{
                Values.add(row, (String)val);
            }catch(NumberFormatException ex){
                
            }
            
        }
    }
    
    public ListIterator getIterator(){
        return Values.listIterator();
    }
    
}
