/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Networking;

import javax.json.*;
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
 *RPGConnectorServer hosts a Tactical grid that multiple clients are able to edit.
 * RPGConnectorServer also supports connections from android devices that wish to
 * import the server's database.
 * @author Shazzama.Pajama
 */
public class RPGConnectorServer extends Thread {
    private Grid                            TacticalGrid;
    private Vector<PrintWriter>             ClientOutput;
    private ServerSocket                    Server;
    private Socket                          Incoming;
    
    /**
     *Creates an RPGConnector Server thread on port 1337 that multiple clients
     * can connect to.
     * @param Gridname name of the grid being used.
     * @throws IOException If server cannot start
     */
    public RPGConnectorServer(String Gridname) throws IOException{
        TacticalGrid = new Grid(Gridname);
        ClientOutput = new Vector<>();
        
        Server = new ServerSocket(1337);
        
    }
    
    /**
     * Executes the RPGConnector Thread to start accepting connections
     */
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
