/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Networking.Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.json.Json;
import javax.json.JsonException;
import javax.json.JsonObject;
import javax.json.JsonReader;

/**
 *
 * @author Shazzama.Pajama
 */
public class ClientThread extends Thread {
    private BufferedReader ServerReader;
    private ServerMessageProcessor MessageReader;
    private JsonReader JsonObjectBuilder;
    
    public ClientThread(BufferedReader reader, ServerMessageProcessor MessageProcessor){
        ServerReader = reader;
        MessageReader = MessageProcessor;
    }
    
    public void run(){
        
        while (true){
            String JsonMessage;
            try {
                JsonMessage = ServerReader.readLine();
                StringReader stReader = new StringReader(JsonMessage);
                
                JsonObjectBuilder = Json.createReader(stReader);
                JsonObject message = JsonObjectBuilder.readObject();
                MessageReader.ProcessMessage(message);
                
            } catch (IOException | JsonException ex) {
                Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
            }
                
        }
    }
}
