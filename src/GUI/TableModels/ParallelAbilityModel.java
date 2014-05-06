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
public class ParallelAbilityModel extends ParallelValueModel{
   private ArrayList<Integer> Values;
    
    public ParallelAbilityModel(){
        String[] titles = new String[] {"STR", "CON", "DEX", "INT", "WIS", "CHA"};
        Labels = new ArrayList<>();
        Values = new ArrayList<>();
        Columns = new String[]{"Ability", "Values"};
        
        Labels.addAll(Arrays.asList(titles));
        for (String i: Labels){
            Values.add(0);
        }        
    }
    
    public ParallelAbilityModel(ArrayList<Integer> values){
        String[] titles = new String[] {"STR", "CON", "DEX", "INT", "WIS", "CHA"};
        Labels = new ArrayList<>();
        Values = values;
        Columns = new String[]{"Ability", "Values"};
        
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
    public void setValueAt(Object val, int rowIndex, int colIndex){
        if(colIndex == 1){
            try{
                Values.add(rowIndex, Integer.parseInt(val.toString()));
            }catch(NumberFormatException ex){
                
            }
            
        }
    }
    
    public ListIterator getIterator(){
        return Values.listIterator();
    }
}
