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
    private String  Type;
    private String  Race;
    private String  Class;
    private String  Alignment;
    private Integer Level;
    private Integer Hitpoints;
    private Integer AtkBonus;
    private String  Description;
    private final HashMap<String, Integer> Abilities;
    private final HashMap<String, Integer>   Skills;
    
    /**
     *Creates a Dungeons and Dragons 4.0 character with user provided Stats.
     * 
     * @param name Name of the Character
     * @param type Character's type (Player,NPC, Monster etc)
     * @param race Race of the Character
     * @param classname Class of the Character
     * @param level Character's current Level
     * @param alignment Character's current Alignment
     * @param hitpoints Character's HitPoints
     * @param AbilityScores HashMap Containing Ability Scores for the character
     * @param SkillScores   HashMap containing Skill Scores for the character
     */
    public Character (
            String name,
            String type,
            String race,
            String classname,
            String alignment,
            Integer level,
            Integer hitpoints,
            Integer atkbonus,
            String description,
            HashMap<String, Integer> AbilityScores,
            HashMap<String, Integer> SkillScores)
    {
     Name = name;
     Race = race;
     Type = type;
     Class = classname;
     Level = level;
     Hitpoints = hitpoints;
     AtkBonus = atkbonus;
     Description = description;
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
     * Set the Type of this character (Player, NPC , Monster, etc).
     * @param type Name of the type.
     */
    public void setType(String type){
        this.Type = type;
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
    
    public void setAlignment(String alignment){
        this.Alignment = alignment;
    }
    
    public void setHP(Integer hp){
        this.Hitpoints = hp;
    }
    
    public void setAtkBonus(Integer bonus){
        this.AtkBonus = bonus;
    }
    
    public void setDescription(String desc){
        this.Description = desc;
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
     * Returns a String containing the type of this character.
     * @return Character's type attribute.
     */
    public String getType(){
        return this.Type;
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
    
    public Integer getHP(){
        return this.Hitpoints;
    }
    
    public Integer getAtkBonus(){
        return this.AtkBonus;
    }
    
    public String getDescription(){
        return this.Description;
    }
    
    /**
     * Returns the score of a given ability name.
     * @param ability name of the ability.
     * @return score associated with the parameter. ability.
     */
    public Integer getAbilityScore(String ability){
        return this.Abilities.get(ability);
    }
    
    /**
     * Returns the score of a given sill name
     * @param skill name of a skill
     * @return score associated with the parameter skill
     */
    public Integer getSkillScore(String skill){
        return this.Skills.get(skill);
    }
    
    //Methods to Make sure important abilities and skills are not null
    
    public void AbNullToZero(){
        
        if(this.Abilities.get("STR") == null){
            this.Abilities.put("STR", 0);
        }
        if(this.Abilities.get("CON") == null){
            this.Abilities.put("CON", 0);
        }
        if(this.Abilities.get("DEX") == null){
            this.Abilities.put("DEX", 0);
        }
        if(this.Abilities.get("INT") == null){
            this.Abilities.put("INT", 0);
        }
        if(this.Abilities.get("WIS") == null){
            this.Abilities.put("WIS", 0);
        }
        if(this.Abilities.get("CHA") == null){
            this.Abilities.put("CHA", 0);
        }
    }
    
    public void SkillNullToZero(){
        
    }
}
