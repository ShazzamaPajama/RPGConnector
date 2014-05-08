/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Networking.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringReader;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.json.*;
/**
 *
 * @author Shazzama.Pajama
 */
public class UserThread extends Thread {
    private final RPGConnectorServer Server;
    private final UserMessageProcessor MessageReader;
    private final Socket Client;
    private final BufferedReader ClientReader;
    private StringReader reader;
    private JsonReader ObjectReader;
    PrintWriter ClientWriter;
    
    public UserThread(Socket client, RPGConnectorServer server) throws IOException{
        // get client, server, message processor
        Server = server;
        MessageReader = new UserMessageProcessor(Server);
        Client = client;
        ClientReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
        ClientWriter = new PrintWriter(Client.getOutputStream(), true);
        Server.addClientOutput(ClientWriter);
        
    }
    
    
    @Override
    public void run(){
        
        while(true){
            try {
                String Message = ClientReader.readLine();
                reader = new StringReader(Message);
                
                ObjectReader = Json.createReader(reader);
                JsonObject JsonMessage = ObjectReader.readObject();
                
                MessageReader.ProcessMessage(JsonMessage);
                
                
            } catch (IOException | JsonException ex) {
                Logger.getLogger(UserThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
}
