/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AssetDB;

/**
 *
 * @author paul.koroski
 */
public class Character {
    
    private String  Name;
    private String  Race;
    private String  Class;
    private int     Level;
    private String  Alignment;
    private AbilityValueMap Abilities;
    private SkillValueMap   Skills;
    
    
    public Character (
            String name,
            String race,
            String classname,
            int level,
            String alignment,
            AbilityValueMap AbilityScores,
            SkillValueMap SkillScores)
    {
     Name = name;
     Race = race;
     Class = classname;
     Level = level;
     Abilities = AbilityScores;
     Skills = SkillScores;
    }
}
