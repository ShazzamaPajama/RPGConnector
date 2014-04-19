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
public class AbilityValueMap {
    private final HashMap<String, Integer> Abilities;
    
    
    public AbilityValueMap(){
        Abilities = new HashMap<>();
        
        Abilities.put("Strength", 0);
        Abilities.put("Constitution", 0);
        Abilities.put("Dexterity", 0);
        Abilities.put("Intelligence", 0);
        Abilities.put("Wisdom", 0);
        Abilities.put("Charisma", 0);
    }
    
    
    public void ChangeScore(String Ability, int Value){
        if (Abilities.containsKey(Ability)){
            Abilities.put(Ability, Value);
        }
        
    }
    
    public Integer getScore(String Ability){
        if (Abilities.containsKey(Ability)){
            return Abilities.get(Ability);
        
        }else{
            return null;
        }
        
    }
}
