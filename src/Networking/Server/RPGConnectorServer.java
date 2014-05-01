/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Networking.Server;

import TacticalGrid.Grid;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Shazzama.Pajama
 */
public class RPGConnectorServer {
    private ArrayList<PrintWriter> ClientOutputStreams;
    private ServerMessageBuilder MessageBuilder;
    private ServerThread ConnectionReceiver;
    private Grid TacticalGrid;
    private ServerSocket ServerConnection;
    
    public RPGConnectorServer(){
        ClientOutputStreams = new ArrayList<>();
        MessageBuilder = new ServerMessageBuilder();
        TacticalGrid = new Grid("NewGrid");
        
        try {
            ServerConnection = new ServerSocket(1337);
        } catch (IOException ex) {
            Logger.getLogger(RPGConnectorServer.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(1);
        }
        
        
    }
    
    public RPGConnectorServer(Grid oldergrid){
        
    }
    
    //Adding Client Methods
    
    
    public synchronized void addClientOutput(PrintWriter clientwriter){
        
    }
    

    
    //Cell Updating Methods
    
    public synchronized  void UpdateCellColor(){
        //Udate Cell Color
        
        //Send update message to all users
    }
    
    public synchronized void UpdateCellToken(){
        //update cell token
        
        //Send Update message to all users
    }
}
