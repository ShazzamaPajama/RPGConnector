/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AssetDB;

import java.util.HashMap;


/**
 *
 * @author paul.koroski
 */
public class SkillValueMap {
    private final HashMap<String, Integer> Skills;
    
    
    public SkillValueMap(){
        Skills = new HashMap<>();
    }
    
    
    public void addSkill(String Skill, int Value){
        Skills.put(Skill, Value);
    }
    
    public void changeSkill(String Skill, int Value){
        if(Skills.containsKey(Skill)){
            Skills.put(Skill, Value);
        }
    }
    
    public Integer getSkill(String Skill){
        return Skills.get(Skill);
    }
    
}
