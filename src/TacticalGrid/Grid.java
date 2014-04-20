/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TacticalGrid;

/**
 *
 * @author Shazzama.Pajama
 */
public class Grid {
    private Cell[][] Board;
    private String Name;
    
    /**
     *
     * @param name
     */
    public Grid(String name){
        Board = new Cell[20][20];
        Name = name;
        
        for(int x=0; x<20; x++){
            for(int y=0; y<20; y++){
             Board[x][y] = new Cell(x,y,this);   
            }
        }
    }
    
    /**
     *
     * @param x
     * @param y
     * @param color
     */
    public void setCellColor(int x, int y, String color){
        Board[x][y].setColor(color);
    }
    
    /**
     *
     * @param x
     * @param y
     * @param t
     */
    public void setCellToken(int x, int y, Token t){
        Board[x][y].setToken(t);
    }
    
}
