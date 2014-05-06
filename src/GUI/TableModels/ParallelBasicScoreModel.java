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
public class ParallelBasicScoreModel extends ParallelValueModel {
    private ArrayList<Integer> Values;
    
    public ParallelBasicScoreModel(){
        String[] titles = new String[] {"Level", "HP", "AC", "ATKBonus"};
        Labels = new ArrayList<>();
        Values = new ArrayList<>();
        Columns = new String[]{"BasicInfo", "Values"};
        
        Labels.addAll(Arrays.asList(titles));
        for (String i: Labels){
            Values.add(0);
        }        
    }
    
    public ParallelBasicScoreModel(ArrayList<Integer> values){
        String[] titles = new String[] {"Level", "HP", "AC", "ATKBonus"};
        Labels = new ArrayList<>();
        Values = values;
        Columns = new String[]{"BasicValues", "Values"};
        
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
                Values.add(row, Integer.parseInt(val.toString()));
            }catch(NumberFormatException ex){
                
            }
            
        }
    }
    
    public ListIterator getIterator(){
        return Values.listIterator();
    }
}
