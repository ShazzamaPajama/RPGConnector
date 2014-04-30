/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI.TableModels;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Shazzama.Pajama
 */
public class ParallelBasicModel extends ParallelValueModel {
    private ArrayList<Object> Values;
    
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
    
    public ParallelBasicModel(ArrayList<Object> values){
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
    
    
}
