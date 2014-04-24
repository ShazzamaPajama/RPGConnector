/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Networking;

import javax.json.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *The UserThread represents a User's Connection to the server. JSON messages
 * from the client are received and processed 
 * @author Shazzama.Pajama
 */
public class UserThread extends Thread {
    private Socket Client;
    private ServerSocket Server;
    private BufferedReader ClientInput;
    private String ClientName;
    
    /**
     *
     * @param server
     * @param client
     * @throws IOException
     */
    public UserThread(ServerSocket server, Socket client) throws IOException {
        Server = server;
        Client = client;
        ClientInput = new BufferedReader(new InputStreamReader(Client.getInputStream()));
    }
    
    /**
     * This method starts the thread receiving incoming messages from the client
     */
    @Override
    public void run(){
        
    }
}
