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

/**
 *
 * @author paul.koroski
 */
public class DBManager {
    private ArrayList<Character> Characters;
    private Connection Database;
    private Statement stmt;
    private String SQLString;
    
    /**
     *
     */
    public DBManager(){
        Characters = new ArrayList<>();
        
        try {
            Database = DriverManager.getConnection("jdbc:sqlite:Characters.db");
            stmt = Database.createStatement();
            SQLString = "CREATE TABLE IF NOT EXISTS Characters "
                    + "( ";
            
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    
}
