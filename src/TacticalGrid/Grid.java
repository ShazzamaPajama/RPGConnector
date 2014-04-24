/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TacticalGrid;

/**
 *Grid represents a tactical grid made of cells that can be edited by
 * clients on an RPGConnectorServer
 * @author Shazzama.Pajama
 */
public class Grid {
    private Cell[][] Board;
    private String Name;
    
    /**
     *Creates a new 25 X 25 Grid object with
     * @param name Name of the grid
     */
    public Grid(String name){
        Board = new Cell[25][25];
        Name = name;
        
        for(int x=0; x<25; x++){
            for(int y=0; y<25; y++){
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
