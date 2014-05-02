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
import javax.json.JsonObject;

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
        }
    }
    
    public RPGConnectorServer(Grid oldergrid){
        
    }
    
    //Adding Client Methods
    
    
    public synchronized void addClientOutput(PrintWriter clientwriter){
        this.ClientOutputStreams.add(clientwriter);
    }
    

    
    //Cell Updating Methods
    
    public synchronized  void UpdateCellColor(int row, int col, String Color){
        //Update Cell Color
        this.TacticalGrid.setCellColor(row, col, Color);
        
        
        //Send update message to all users
        JsonObject message = MessageBuilder.UpdateCellColorMessage(row, col, Color);
        for(PrintWriter client : ClientOutputStreams){
            client.println(message.toString());
        }
        
    }
    
    public synchronized void UpdateCellToken(int row, int col, String Token){
        //update cell token
        this.TacticalGrid.setCellToken(row, col, Token);
        
        //Send Update message to all users
        JsonObject message = MessageBuilder.UpdateCellTokenMessage(row, col, Token);
        for(PrintWriter client : ClientOutputStreams){
            client.println(message.toString());
        }
    }
    
    //Chat Methods
    
    public synchronized void Updatechat(String name, String chatmsg){
        JsonObject message = MessageBuilder.UpdateChatMessage(name, chatmsg);
        
        for(PrintWriter client : ClientOutputStreams){
            client.println(message);
        }
        
    }
    
    
    //Server Thread messages
    public void StarServerThread(){
        new ServerThread(ServerConnection, this).start();
    }
}
