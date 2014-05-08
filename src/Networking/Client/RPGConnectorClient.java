/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Networking.Client;

import GUI.PlayArea;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.HashMap;
import javax.json.JsonObject;

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
    private HashMap<String, Color> ColorMap;
    
    
    public RPGConnectorClient(String Host, PlayArea MPGUI) throws IOException{
        if (Host.equals("Local")){
            Client = new Socket(InetAddress.getLocalHost(), 1337);
        }else{
            Client = new Socket(Host, 1337);
        }
        System.out.println("Connected to server");
        ServerWriter = new PrintWriter(Client.getOutputStream(), true);
        MessageBuilder = new ClientMessageBuilder();
        ServerReader = new BufferedReader(new InputStreamReader(Client.getInputStream()));
        ClientScreen = MPGUI;
        this.initColorMap();
        
        
        
        this.StartClientThread();
        
    }
    
    private void StartClientThread(){
        new ClientThread(ServerReader, new ServerMessageProcessor(this)).start();
    }
    
    
    //Update Methods
    
    public synchronized void UpdateCellToken(int row, int col, String Token){
        ClientScreen.ChangeCellToken(row, col, Token);
        
    }
    
    public synchronized void UpdateCellColor(int row, int col, String Color){
        if (ColorMap.containsKey(Color)){
            ClientScreen.changeCellColor(row, col, ColorMap.get(Color));
        }
    }
    
    public synchronized void UpdateChat(String User, String ChatMessage){
        String Chat = User +": " + ChatMessage;
        ClientScreen.addMessage(Chat);
        
    }
    
    public synchronized void UpdateNamelist(String name){
        ClientScreen.addName(name);
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
    
    public void sendNameUpdate(String name){
        JsonObject message = MessageBuilder.UpdateNameMessage(name);
        ServerWriter.println(message.toString());
    }
    
    private void initColorMap(){
        ColorMap = new HashMap<>();
        
        ColorMap.put("White", Color.WHITE);
        ColorMap.put("Green", Color.GREEN.brighter());
        ColorMap.put("Red", Color.RED.brighter());
        ColorMap.put("Blue", Color.BLUE.brighter());
        ColorMap.put("Orange", Color.ORANGE);
        ColorMap.put("Black", Color.BLACK);
    }
}
