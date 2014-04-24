/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Networking;

import TacticalGrid.Grid;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Shazzama.Pajama
 */
public class RPGConnectorServer extends Thread {
    private Grid                            TacticalGrid;
    private Vector<PrintWriter>             ClientOutput;
    private ServerSocket                    Server;
    private Socket                          Incoming;
    
    public RPGConnectorServer(String Gridname) throws IOException{
        TacticalGrid = new Grid(Gridname);
        ClientOutput = new Vector<>();
        
        Server = new ServerSocket(1337);
        
    }
    
    @Override
    public void run(){
        while(true){
            try {
                this.Incoming = Server.accept();
                PrintWriter ClientWriter = new PrintWriter(this.Incoming.getOutputStream(), true);
                ClientOutput.add(ClientWriter);
                new UserThread(this.Server, this.Incoming).start();
                
            } catch (IOException ex) {
                Logger.getLogger(RPGConnectorServer.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
}
