/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AssetDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.sqlite.SQLiteConfig;

/**
 *Class used to edit databases used by RPGConnector
 * @author paul.koroski
 */
public class DBManager {
    private ArrayList<Character> Characters;
    private Connection Database;
    private Statement stmt;
    
    /**
     *Creates and connects to a file named DND.db if it does not already exist.
     * Creates empty character, item, skillset, and abilityset tables if they do not exist.
     */
    public DBManager(){
        Characters = new ArrayList<>();
        String SQLString;
        try {
            SQLiteConfig config = new SQLiteConfig();
            config.enforceForeignKeys(true);
            Database = DriverManager.getConnection("jdbc:sqlite:DND.db", config.toProperties());
            stmt = Database.createStatement();
            
            //Character basic data table creation
            SQLString = "CREATE TABLE IF NOT EXISTS Characters "
                    + "(Name TEXT NOT NULL,"
                    + " Race TEXT NOT NULL,"
                    + " Type TEXT NOT NULL,"
                    + " Class TEXT NOT NULL,"
                    + " Alignment TEXT NOT NULL,"
                    + " Level INTEGER NOT NULL,"
                    + " HitPoints INTEGER NOT NULL,"
                    + " ArmorClass INTEGER NOT NULL,"
                    + " AtkBonus INTEGER NOT NULL,"
                    + " Description TEXT NOT NULL,"
                    + " ExtraAbilities TEXT NOT NULL,"
                    + " PRIMARY KEY (Name, Race, Type))";
            this.stmt.executeUpdate(SQLString);
            
            
            SQLString = "CREATE TABLE IF NOT EXISTS SkillSets "
                    + "(Name TEXT NOT NULL,"
                    + " Race TEXT NOT NULL,"
                    + " Type TEXT NOT NULL,"
                    + " Acrobatics INTEGER,"
                    + " Arcana INTEGER,"
                    + " Athletics INTEGER,"
                    + " Bluff INTEGER,"
                    + " Diplomacy INTEGER,"
                    + " Dungeoneering INTEGER,"
                    + " Endurance INTEGER,"
                    + " Heal INTEGER,"
                    + " History INTEGER,"
                    + " Insight INTEGER,"
                    + " Intimidate INTEGER,"
                    + " Nature INTEGER,"
                    + " Perception INTEGER,"
                    + " Religion INTEGER,"
                    + " Stealth INTEGER,"
                    + " Streetwise INTEGER,"
                    + " Thievery INTEGER,"
                    + " PRIMARY KEY (Name, Race, Type),"
                    + " FOREIGN KEY (Name, Race, Type) REFERENCES Characters(Name, Race, Type) ON DELETE CASCADE ON UPDATE CASCADE)";
            this.stmt.executeUpdate(SQLString);
            
            SQLString = "CREATE TABLE IF NOT EXISTS AbilitySets "
                    + "(Name TEXT NOT NULL,"
                    + " Race TEXT NOT NULL,"
                    + " Type TEXT NOT NULL,"
                    + " Strength INTEGER NOT NULL,"
                    + " Constitution INTEGER NOT NULL,"
                    + " Dexterity INTEGER NOT NULL,"
                    + " Intelligence INTEGER NOT NULL,"
                    + " Wisdom INTEGER NOT NULL,"
                    + " Charisma INTEGER NOT NULL,"
                    + " PRIMARY KEY (Name, Race, Type)"
                    + " FOREIGN KEY (Name, Race, Type) REFERENCES Characters(Name, Race, Type) ON DELETE CASCADE ON UPDATE CASCADE)";
            this.stmt.executeUpdate(SQLString);
           
            SQLString = "CREATE TABLE IF NOT EXISTS Items "
                    + "(Name TEXT NOT NULL, "
                    + "Type TEXT NOT NULL, "
                    + "Price TEXT NOT NULL, "
                    + "Magic NUMERIC NOT NULL, "
                    + "Description TEXT NOT NULL,"
                    + "PRIMARY KEY (Name, Type))";
            this.stmt.executeUpdate(SQLString);
            
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Query Methods
    
    public ResultSet getAllCharacters() throws SQLException{
        ResultSet result;
        
        String SQL = "SELECT * FROM Characters";
        
        result = stmt.executeQuery(SQL);
        
        return result;
    }
    
    /**
     *Executes a query for a character with a specific stat in the Character's table
     * 
     * @param Stat Name of the stat the user is looking for
     * @param Val Value of the stat the user is looking for
     * @return set of characters that have corresponding value for the given stat
     * @throws SQLException syntax error / wrong column name
     */  
    public ResultSet QueryBasicStat(String Stat, String Val) throws SQLException{
        ResultSet result;
        String SQL;
        
        //Check to see if Stat being Queried is a Integer
        if(Stat.equals("Level") || Stat.equals("Hitpoints") || Stat.equals("ArmorClass") || Stat.equals("AtkBonus")){
            try{
                Integer value = Integer.parseInt(Val);
                
                SQL = "SELECT * FROM Characters "
                + "WHERE " + Stat + "= " + value;
                result = this.stmt.executeQuery(SQL);
                return result;
            }catch(NumberFormatException e){
                return null;
            }
        
            // Stat being queries is a String
        }else{
            SQL = "SELECT * FROM Characters "
                + "WHERE " + Stat + "='" + Val + "'";
            
            result = this.stmt.executeQuery(SQL);
            return result;
        }
    }
    
    /**
     *Execute Query for a character with a specific ability score
     * @param ability name of an ability
     * @param value value of the ability the user is searching for
     * @return set of character with the given ability score
     * 
     * @throws SQLException if the query fails, syntax error / wrong column name
     */
    public ResultSet AbilityQuery(String ability, String value) throws SQLException{
        String SQL;
        ResultSet result;
        
        SQL = "SELECT * FROM AbilitySets "
                + "WHERE " + ability + "= " + value;
        
        result = this.stmt.executeQuery(SQL);
        return result;
        
    }
    
    public ResultSet getAllAbilitySets() throws SQLException{
        String SQL;
        ResultSet result;
        
        SQL = "SELECT * FROM AbilitySets";
        
        result = stmt.executeQuery(SQL);
        
        return result;
    }
    
    /**
     *Executes a query for a character with a specific Skill score
     * @param skill name of a skill
     * @param value value of the skill the user is looking for
     * @return set of characters with the given skill score
     * @throws SQLException if query fails, syntax error / wrong column name
     */
    public ResultSet SkillQuery(String skill, String value) throws SQLException{
        String SQL;
        ResultSet result;
        
        SQL = "SELECT * FROM SkillSets "
                + "WHERE " + skill + "= " + value;
        
        result = this.stmt.executeQuery(SQL);
        
        return result;
    }
    
    public ResultSet getOneSkillAll(String Skill) throws SQLException{
        String SQL;
        ResultSet result;
        
        SQL = "SELECT Name, Race, Type, " + Skill + " FROM SkillSets";
        
        result = stmt.executeQuery(SQL);
        
        return result;
    }
    
    /**
     *Executes a query for a specific character
     * 
     * @param name name of the character
     * @param race race of the character
     * @param type type of the character
     * @return the character with the given name, race and type
     * @throws SQLException if query fails, syntax error
     */
    public ResultSet CharacterQuery(String name, String race, String type) throws SQLException{
        String SQL;
        ResultSet result;
        String Name = "'"+name+"'";
        String Race = "'"+race+"'";
        String Type = "'"+type+"'";
        
        SQL = "SELECT * FROM Characters"
                + " WHERE Name = " + Name +" AND "
                + " Race = " + Race + " AND "
                + " Type = " + Type;
        
        System.out.println(SQL);
        result = this.stmt.executeQuery(SQL);
        return result;
    }
    
    
    public void addBasicInfo(
            String Name, 
            String Race, 
            String Type, 
            String Class, 
            String Alignment,
            Integer Level,
            Integer HP, 
            Integer AC, 
            Integer ATK, 
            String Desc,
            String Extra) throws SQLException{
        
        //Prepare strings for sql statement
        String name = "'" + Name + "'";
        String race = "'" + Race + "'";
        String type = "'" + Type + "'";
        String classname = "'" + Class + "'";
        String align = "'" + Alignment + "'";
        String desc = "'" + Desc + "'";
        String extra = "'"+Extra+"'";
        
        
        
        
        String SQL = "INSERT OR REPLACE INTO Characters "
                + "VALUES ("
                +  name + ", "
                +  race + ", "
                +  type + ", "
                +  classname +", "
                +  align + ", "
                +  Level + ", "
                +  HP + ", "
                +  AC + ", "
                +  ATK + ", "
                +  desc + ", "
                +  extra +" )";
        
        stmt.executeUpdate(SQL);
    }
    
    public void addAbilitySet(String Name, String Race, String Type, Integer STR, Integer CON, Integer DEX, Integer INT, Integer WIS, Integer CHA) throws SQLException{
        String name = "'" + Name + "'";
        String race = "'" + Race + "'";
        String type = "'" + Type + "'";
        
        String SQL = "INSERT OR REPLACE INTO AbilitySets VALUES ("
                + name + ", "
                + race + ", "
                + type + ", "
                + STR + ", "
                + CON + ", "
                + DEX + ", "
                + INT + ", "
                + WIS + ", "
                + CHA + ")";
        
        stmt.execute(SQL);
    }
    
    public void addSkillSet(String Name, String Race, String Type) throws SQLException{
        String name = "'" + Name + "'";
        String race = "'" + Race + "'";
        String type = "'" + Type + "'";
        
        String SQL = "INSERT OR REPLACE INTO SkillSets (Name, Race, Type) VALUES ("
                + name + ", "
                + race + ", "
                + type + ")";
        
        stmt.executeUpdate(SQL);
    }
    
    public void updateSkill(String Name, String Race, String Type, String Skill, Integer Value) throws SQLException{
        String name = "'" + Name + "'";
        String race = "'" + Race + "'";
        String type = "'" + Type + "'";
        
        String SQL = "UPDATE SkillSets "
                + "SET " + Skill + " = " + Value
                + " WHERE Name = " + name
                + " AND Race = " + race
                + " AND Type = " + type;
        
        stmt.executeUpdate(SQL);
    }
    
    
    
    //Methods for creating jtable rows
    public ArrayList<ArrayList<Object>> getBasicInfoRows(ResultSet table) throws SQLException{
        ArrayList<ArrayList<Object>> ModelArray = new ArrayList<>();
        
        while(table.next()){
            String Name = table.getString("Name");
            String Race = table.getString("Race");
            String Type = table.getString("Type");
            String Class = table.getString("Class");
            String Align = table.getString("Alignment");
            Integer Level = table.getInt("Level");
            Integer HP = table.getInt("HitPoints");
            Integer AC = table.getInt("ArmorClass");
            Integer ATK = table.getInt("AtkBonus");
            
            ArrayList<Object> row = new ArrayList<>();
            row.add(Name);
            row.add(Race);
            row.add(Type);
            row.add(Class);
            row.add(Align);
            row.add(Level);
            row.add(HP);
            row.add(AC);
            row.add(ATK);
            
            ModelArray.add(row);
        }
        return ModelArray;
    }
    
    public ArrayList<ArrayList<Object>> getAbilityRows(ResultSet table) throws SQLException{
        ArrayList<ArrayList<Object>> ModelArray = new ArrayList<>();
        
        while(table.next()){
            String Name = table.getString("Name");
            String Race = table.getString("Race");
            String Type = table.getString("Type");
            Integer STR = table.getInt("Strength");
            Integer CON = table.getInt("Constitution");
            Integer DEX = table.getInt("Dexterity");
            Integer INT = table.getInt("Intelligence");
            Integer WIS = table.getInt("Wisdom");
            Integer CHA = table.getInt("Charisma");
            
            ArrayList<Object> row = new ArrayList<>();
            row.add(Name);
            row.add(Race);
            row.add(Type);
            row.add(STR);
            row.add(CON);
            row.add(DEX);
            row.add(INT);
            row.add(WIS);
            row.add(CHA);
            
            ModelArray.add(row);
        }
        return ModelArray;
    }
    
    public ArrayList<ArrayList<Object>> getSkillRows(String skill, ResultSet table) throws SQLException{
        ArrayList<ArrayList<Object>> ModelArray = new ArrayList<>();
        
        while(table.next()){
            String Name = table.getString("Name");
            String Race = table.getString("Race");
            String Type = table.getString("Type");
            Integer Skill = table.getInt(skill);
            
            ArrayList<Object> row = new ArrayList<>();
            row.add(Name);
            row.add(Race);
            row.add(Type);
            row.add(Skill);
            
            ModelArray.add(row);
        }
        return ModelArray;
    }
    
    public ArrayList<Object> getCharacterBasicInfo(String name, String race, String type) throws SQLException{
        ArrayList<Object> BasicInfo = new ArrayList<>();
        ResultSet results;
        String SQL;
        String Name = "'"+name+"'";
        String Race = "'"+race+"'";
        String Type = "'"+type+"'";
        
        SQL = "SELECT * FROM Characters WHERE "
                + "Name = " + Name + " AND Race = " + Race + " AND " + "Type = " + Type;
        
        results = stmt.executeQuery(SQL);
        
        results.next();
        
        BasicInfo.add(results.getString("Name"));
        BasicInfo.add(results.getString("Race"));
        BasicInfo.add(results.getString("Type"));
        BasicInfo.add(results.getString("Class"));
        BasicInfo.add(results.getString("Alignment"));
        BasicInfo.add(results.getInt("Level"));
        BasicInfo.add(results.getInt("Hitpoints"));
        BasicInfo.add(results.getInt("ArmorClass"));
        BasicInfo.add(results.getInt("AtkBonus"));
        
        return BasicInfo;
    }
    
    public ArrayList<Object> getCharacterAbilities(String name, String race, String type) throws SQLException{
        ArrayList<Object> AbilityInfo = new ArrayList<>();
        ResultSet results;
        String SQL;
        String Name = "'"+name+"'";
        String Race = "'"+race+"'";
        String Type = "'"+type+"'";
        
        SQL = "SELECT * FROM AbilitySets WHERE "
                + "Name = " + Name + " AND Race = " + Race + " AND " + "Type = " + Type;
        
        results = stmt.executeQuery(SQL);
        results.next();
        
        AbilityInfo.add(results.getInt("Strength"));
        AbilityInfo.add(results.getInt("Constitution"));
        AbilityInfo.add(results.getInt("Dexterity"));
        AbilityInfo.add(results.getInt("Intelligence"));
        AbilityInfo.add(results.getInt("Wisdom"));
        AbilityInfo.add(results.getInt("Charisma"));
        
        return AbilityInfo;
        
    }
    
    public ArrayList<Object> getCharacterSkills(String name, String race, String type) throws SQLException{
        ArrayList<Object> SkillInfo = new ArrayList<>();
        ResultSet results;
        String SQL;
        String Name = "'"+name+"'";
        String Race = "'"+race+"'";
        String Type = "'"+type+"'";
        
        SQL = "SELECT * FROM SkillSets WHERE "
                + "Name = " + Name + " AND Race = " + Race + " AND " + "Type = " + Type;
        
        results = stmt.executeQuery(SQL);
        
        results.next();
        
        SkillInfo.add(results.getInt("Acrobatics"));
        SkillInfo.add(results.getInt("Arcana"));
        SkillInfo.add(results.getInt("Athletics"));
        SkillInfo.add(results.getInt("Bluff"));
        SkillInfo.add(results.getInt("Diplomacy"));
        SkillInfo.add(results.getInt("Dungeoneering"));
        SkillInfo.add(results.getInt("Endurance"));
        SkillInfo.add(results.getInt("Heal"));
        SkillInfo.add(results.getInt("History"));
        SkillInfo.add(results.getInt("Insight"));
        SkillInfo.add(results.getInt("Intimidate"));
        SkillInfo.add(results.getInt("Nature"));
        SkillInfo.add(results.getInt("Perception"));
        SkillInfo.add(results.getInt("Religion"));
        SkillInfo.add(results.getInt("Stealth"));
        SkillInfo.add(results.getInt("Streetwise"));
        SkillInfo.add(results.getInt("Thievery"));
        
        return SkillInfo;
        
    }
    
    public String getCharacterDescription(String name, String race, String type) throws SQLException{
        String Name = "'"+name+"'";
        String Race = "'"+race+"'";
        String Type = "'"+type+"'";
        ResultSet result;
        
        String SQL = "SELECT Description FROM Characters WHERE "
                + "Name = " + Name + "AND Race = " + Race + "AND Type = " + Type;
        
        result = stmt.executeQuery(SQL);
        result.next();
        
        String Description = result.getString("Description");
        return Description;
    }
    
    public String getCharacterExtras(String name, String race, String type) throws SQLException{
        String Name = "'"+name+"'";
        String Race = "'"+race+"'";
        String Type = "'"+type+"'";
        ResultSet result;
        
        String SQL = "SELECT ExtraAbilities FROM Characters WHERE "
                + "Name = " + Name + "AND Race = " + Race + "AND Type = " + Type;
        
        result = stmt.executeQuery(SQL);
        result.next();
        
        String Extras = result.getString("ExtraAbilities");
        return Extras;        
    }
}
