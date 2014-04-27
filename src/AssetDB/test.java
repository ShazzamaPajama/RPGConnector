/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AssetDB;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Shazzama.Pajama
 */
public class test {
 
    
    public static void main(String[] args){
        DBManager test = new DBManager();
        
        try {
            test.addBasicInfo("john", "orc", "player", "paladin", "ng", 4, 52, 16, 5, "this is a test");
            test.addAbilitySet("john", "orc", "player", 12, 5, 7, 89, 9, 8);
            test.addSkillSet("john", "orc", "player");
            test.updateSkill("john", "orc", "player", "Perception", 9);
        } catch (SQLException ex) {
            Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        }
 
}
