/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Networking.Client;

import GUI.MPGUIGrid;
import GUI.PlayArea;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import javax.json.Json;
import javax.json.JsonObject;
import javax.swing.JTextArea;

/**
 *
 * @author Shazzama.Pajama
 */
public class RPGConnectorClient {
    private Socket Client;
    private PrintWriter ServerWriter;
    private ClientMessageBuilder MessageBuilder;
    private ClientThread ProcessingThread;
    private BufferedReader ServerReader;
    private PlayArea ClientScreen;
    
    
    public RPGConnectorClient(String Host, PlayArea MPGUI) throws IOException{
        Client = new Socket(Host, 1337);
        ServerWriter = new PrintWriter(Client.getOutputStream(), true);
        MessageBuilder = new ClientMessageBuilder();
        ServerReader = new BufferedReader(new InputStreamReader(Client.getInputStream()));
        ClientScreen = MPGUI;
    }
    
    public void StartClientThread(){
        new ClientThread(ServerReader, new ClientMessageProcessor(this)).start();
    }
    
    
    //Update Methods
    
    public synchronized void UpdateCellToken(int row, int col, String Token){
        
        
    }
    
    public synchronized void UpdateCellColor(int row, int col, String Color){
        
    }
    
    public synchronized void UpdateChat(String User, String ChatMessage){
        
    }
    
    //Message Methods
    public void sendColorUpdate(int row, int col, String Color){
        JsonObject message = MessageBuilder.UpdateColorMessage(row, col, Color);
        ServerWriter.println(message.toString());
    }
    
    public void sendTokenUpdate(int row, int col, String token){
        JsonObject message = MessageBuilder.UpdateTokenMessage(row, col, token);
        ServerWriter.println(message.toString());
    }
    
    public void sendChatUpdate(String ChatMessage){
        JsonObject message = MessageBuilder.ChatUpdateMessage(ChatMessage);
        ServerWriter.println(message.toString());
    }
}
