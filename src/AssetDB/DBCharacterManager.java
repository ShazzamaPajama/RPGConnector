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
public class DBCharacterManager {
    private ArrayList<Character> CharacterResults;
    private Connection Database;
    
    /**
     *
     */
    public DBCharacterManager(){
        CharacterResults = new ArrayList<>();
        
        try {
            Database = DriverManager.getConnection("jdbc:sqlite:Characters.db");
        } catch (SQLException ex) {
            Logger.getLogger(DBCharacterManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    
}
