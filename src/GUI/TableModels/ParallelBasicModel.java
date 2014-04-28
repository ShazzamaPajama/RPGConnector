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
    
    public ParallelBasicModel(){
        String[] titles = new String[] {"Name", "Race", "Type", "Class", "Alignment", "Level", "HP", "AC", "ATKBonus"};
        Labels = new ArrayList<>();
        Values = new ArrayList<>();
        Columns = new String[]{"BasicInfo", "Values"};
        
        Labels.addAll(Arrays.asList(titles));
        for (String i: Labels){
            Values.add("");
        }
    }
    
    public ParallelBasicModel(ArrayList<Object> values){
        String[] titles = new String[] {"Name", "Race", "Type", "Class", "Alignment", "Level", "HP", "AC", "ATKBonus"};
        Labels = new ArrayList<>();
        Values = values;
        Columns = new String[]{"BasicInfo", "Values"};
        
        Labels.addAll(Arrays.asList(titles));
    }
    
}
