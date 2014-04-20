/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TacticalGrid;

/**
 *test comment
 * @author Shazzama.Pajama
 */
public class Cell {
    private int     Xcoordinate;
    private int     Ycoordinate;
    private Token   Token;
    private String  Color;
    private Grid    Parent;
    
    /**
     *
     * @param x
     * @param y
     * @param p
     */
    public Cell(int x, int y, Grid p){
        Xcoordinate =   x;
        Ycoordinate =   y;
        Token =         null;
        Color =         "White";
        Parent =        p;
    }
   
    /**
     *
     * @param t
     */
    public void setToken(Token t){
       Token = t;
   }
   
    /**
     *
     * @param c
     */
    public void setColor(String c){
       Color = c;
   }
   
    /**
     *
     * @return
     */
    public int getX(){
       return Xcoordinate;
   }
   
    /**
     *
     * @return
     */
    public int getY(){
       return Ycoordinate;
   }
   
   
}
