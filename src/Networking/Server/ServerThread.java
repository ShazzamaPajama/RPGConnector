/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Networking.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Shazzama.Pajama
 */
public class ServerThread extends Thread{
    private ServerSocket ServerConnection;
    private RPGConnectorServer Server;
    
    public ServerThread(ServerSocket servercon, RPGConnectorServer server){
        ServerConnection = servercon;
        Server = server;
    }
    
    
    
    @Override
    public void run(){
        while(true){
            try {
                Socket client = ServerConnection.accept();
                new UserThread(client, Server).start();
                
            } catch (IOException ex) {
                Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
