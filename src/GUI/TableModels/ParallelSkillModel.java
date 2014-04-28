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
public class ParallelSkillModel extends ParallelValueModel {
    
    public ParallelSkillModel(){
        String[] titles = new String[] {
            "Acrobatics",
            "Arcana",
            "Athletics",
            "Bluff",
            "Diplomacy",
            "Dungeoneering",
            "Endurance",
            "Heal",
            "History",
            "Insight",
            "Intimidate",
            "Nature",
            "Perception",
            "Religion",
            "Stealth",
            "Streetwise",
            "Tievery"
        };
        
        
        Labels = new ArrayList<>();
        Values = new ArrayList<>();
        Columns = new String[]{"Skill", "Values"};
        
        Labels.addAll(Arrays.asList(titles));
        for (String i: Labels){
            Values.add("");
        }
    }
    
    
    public ParallelSkillModel(ArrayList<Object> values){
        String[] titles = new String[] {
            "Acrobatics",
            "Arcana",
            "Athletics",
            "Bluff",
            "Diplomacy",
            "Dungeoneering",
            "Endurance",
            "Heal",
            "History",
            "Insight",
            "Intimidate",
            "Nature",
            "Perception",
            "Religion",
            "Stealth",
            "Streetwise",
            "Tievery"
        };
        
        
        Labels = new ArrayList<>();
        Values = new ArrayList<>();
        Columns = new String[]{"Skill", "Values"};
        
        Labels.addAll(Arrays.asList(titles));        
    }
}
