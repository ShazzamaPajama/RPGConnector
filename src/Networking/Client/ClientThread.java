/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Networking.Client;

import java.io.BufferedReader;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

/**
 *
 * @author Shazzama.Pajama
 */
public class ClientThread extends Thread {
    private BufferedReader ServerReader;
    private ClientMessageProcessor MessageReader;
    private JsonReader JsonObjectBuilder;
    
    public ClientThread(BufferedReader reader, ClientMessageProcessor MessageProcessor){
        ServerReader = reader;
        MessageReader = MessageProcessor;
    }
    
    public void run(){
        
        while (true){
            JsonObjectBuilder = Json.createReader(ServerReader);
            JsonObject message = JsonObjectBuilder.readObject();
            MessageReader.ProcessMessage(message);
             
        }
    }
}
