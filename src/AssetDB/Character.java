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
public class Character {
    
    private String  Name;
    private String  Race;
    private String  Class;
    private Integer Level;
    private String  Alignment;
    private HashMap<String, Integer> Abilities;
    private HashMap<String, Integer>   Skills;
    
    /**
     *Creates a Dungeons and Dragons 4.0 character with user provided Stats.
     * 
     * @param name Name of the Character
     * @param race Race of the Character
     * @param classname Class of the Character
     * @param level Character's current Level
     * @param alignment Character's current Alignment
     * @param AbilityScores HashMap Containing Ability Scores for the character
     * @param SkillScores   HashMap containing Skill Scores for the character
     */
    public Character (
            String name,
            String race,
            String classname,
            Integer level,
            String alignment,
            HashMap<String, Integer> AbilityScores,
            HashMap<String, Integer> SkillScores)
    {
     Name = name;
     Race = race;
     Class = classname;
     Level = level;
     Abilities = AbilityScores;
     Skills = SkillScores;
    }
    
    /*
    Atribute Changing Methods
    */
    
    /**
     *Changes the Character's name attribute.
     * @param name Name you would rename the character with.
     */
    public void setName(String name){
        this.Name = name;
    }
    
    /**
     * Changes the Character's race attribute.
     * @param race Race you would like to change the character to.
     */
    public void setRace(String race){
        this.Race = race;
    }
    
    /**
     * Changes the Character's class attribute.
     * @param classname Class you would like to change the character to.
     */
    public void setClass(String classname){
        this.Class = classname;
    }
    
    public void setLevel(Integer level){
        this.Level = level;
    }
    
    public void setAbilityScore(String ability, Integer score){
        this.Abilities.put(ability, score);
    }
    
    public void setSkillScore(String skill, Integer score){
        this.Skills.put(skill, score);
    }
    
    
    /*
    Atribute Retrieval Methods
    */
    
    /**
     * Returns character's name attribute
     * @return This Character's Name attribute.
     */
    public String getName(){
        return this.Name;
    }
    
    /**
     * Returns character's Race attribute.
     * @return Character's Race attribute.
     */
    public String getRace(){
        return this.Race;
    }
    
    /**
     * Returns this character's Class attribute.
     * @return Character's Class attribute.
     */
    public String getCharacterClass(){
        return this.Class;
    }
    
    /**
     * Returns Character's Alignment attribute.
     * @return Character's Alignment attribute.
     */
    public String getAlignment(){
        return this.Alignment;
    }
    
    /**
     * Returns character's Level attribute.
     * @return Character's Level attribute.
     */
    public Integer getLevel(){
        return this.Level;
    }
    
    /**
     * Returns the score of a given ability name.
     * @param ability name of the ability.
     * @return score associated with the parameter. ability.
     */
    public Integer getAbilityScore(String ability){
        return this.Abilities.get(ability);
    }
    
    public Integer getSkillScore(String skill){
        return this.Skills.get(skill);
    }
}
