/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TacticalGrid;

/**
 * A Cell represents a single cell in a tactical grid
 * 
 * @author Shazzama.Pajama
 */
public class Cell {
    private int     Xcoordinate;
    private int     Ycoordinate;
    private Token   Token;
    private String  Color;
    private Grid    Parent;
    
    /**
     *Creates a new Cell object with specifiec coordinates
     * @param x X coordinate
     * @param y Y coordinate
     * @param parent Grid that the cell belongs to. 
     */
    public Cell(int x, int y, Grid parent){
        Xcoordinate =   x;
        Ycoordinate =   y;
        Token =         null;
        Color =         "White";
        Parent =        parent;
    }
   
    /**
     *Changes the token that is currently in this cell
     * @param t
     */
    public void setToken(Token t){
       Token = t;
   }
   
    /**
     *Changes the color that is currently in this cell
     * @param c
     */
    public void setColor(String c){
       //change or rgb
        Color = c;
   }
   
    /**
     *Returns the Cell's X coordinate
     * @return X coordinate
     */
    public int getX(){
       return Xcoordinate;
   }
   
    /**
     *Returns the Cells Y coordinate
     * @return Y coordinate
     */
    public int getY(){
       return Ycoordinate;
   }
   
   
}
