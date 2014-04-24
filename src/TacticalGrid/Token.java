/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TacticalGrid;

/**
 * Token represents a token that can be
 * added to a Tactical Grid.
 * 
 * @author Shazzama.Pajama
 */
public class Token {
    String Name;
    String Description;
    //add image
    
    /**
     * Creates a new Token object
     * @param name token's name
     * @param desc token's description
     */
    public Token(String name, String desc){
        Name = name;
        Description = desc;
    }
}
