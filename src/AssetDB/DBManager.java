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
 *
 * @author paul.koroski
 */
public class DBManager {
    private ArrayList<Character> Characters;
    private Connection Database;
    private Statement stmt;
    
    /**
     *Creates and connects to a file named DND.db if it does not already exist.
     * Creates empty character, skillset, and abilityset tables if they do not exist.
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
                    + " Class TEXT,"
                    + " Alignment TEXT NOT NULL,"
                    + " Level INTEGER,"
                    + " HitPoints INTEGER NOT NULL,"
                    + " AtkBonus INTEGER NOT NULL,"
                    + " Description TEXT,"
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
           
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Query Methods
    
    public ResultSet QueryBasicStat(String Stat, String Val) throws SQLException{
        ResultSet result;
        String SQL;
        
        //Check to see if Stat being Queried is a Integer
        if(Stat.equals("Level") || Stat.equals("Hitpoints") || Stat.equals("AtkBonus")){
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
    
    public ResultSet AbilityQuery(String ability, Integer value) throws SQLException{
        String SQL;
        ResultSet result;
        
        SQL = "SELECT * FROM Abilities "
                + "WHERE ability = " + value;
        
        result = this.stmt.executeQuery(SQL);
        return result;
        
    }
    
}
