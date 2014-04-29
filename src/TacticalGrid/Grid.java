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
     *Creates a new 20 X 20 Grid object with
     * @param name Name of the grid
     */
    public Grid(String name){
        Board = new Cell[20][20];
        Name = name;
        
        for(int row=0; row<20; row++){
            for(int col=0; col<20; col++){
             Board[row][col] = new Cell(row,col,this);   
            }
        }
    }
    
    /**
     *
     * @param row
     * @param col
     * @param color
     */
    public void setCellColor(int row, int col, String color){
        Board[row][col].setColor(color);
    }
    
    /**
     *
     * @param row
     * @param col
     * @param t
     */
    public void setCellToken(int row, int col, String t){
        Board[row][col].setToken(t);
    }
    
}
