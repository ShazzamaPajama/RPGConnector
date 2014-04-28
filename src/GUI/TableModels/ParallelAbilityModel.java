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
public class ParallelAbilityModel extends ParallelValueModel{
   
    public ParallelAbilityModel(){
        String[] titles = new String[] {"STR", "CON", "DEX", "INT", "WIS", "CHA"};
        Labels = new ArrayList<>();
        Values = new ArrayList<>();
        Columns = new String[]{"Ability", "Values"};
        
        Labels.addAll(Arrays.asList(titles));
        for (String i: Labels){
            Values.add("");
        }        
    }
    
    public ParallelAbilityModel(ArrayList<Object> values){
        String[] titles = new String[] {"STR", "CON", "DEX", "INT", "WIS", "CHA"};
        Labels = new ArrayList<>();
        Values = values;
        Columns = new String[]{"Ability", "Values"};
        
        Labels.addAll(Arrays.asList(titles));       
    }
}
