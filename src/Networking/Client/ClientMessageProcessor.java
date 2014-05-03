/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Networking.Client;

import javax.json.JsonObject;

/**
 *
 * @author Shazzama.Pajama
 */
public class ClientMessageProcessor {
    RPGConnectorClient Client;
    
    public ClientMessageProcessor(RPGConnectorClient client){
        Client = client;
    }
    
    
    public synchronized void ProcessMessage(JsonObject message){
        try {
            switch (message.getString("MessageType")) {
                case "UpdateCellColor":
                    this.UpdateCellColorCommand(message);
                    break;

                case "UpdateCellToken":
                    this.UpdateCellTokenCommand(message);
                    break;
                    
                case "UpdateChat":
                    this.UpdateChatCommand(message);
                    break;
            }
        } catch (NullPointerException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    
    public void UpdateCellColorCommand(JsonObject message){
        int CellRow = message.getInt("CellRow");
        int CellCol = message.getInt("CellCol");
        String Color = message.getString("Color");
        
        this.Client.UpdateCellColor(CellRow, CellCol, Color);
    }
    
    public void UpdateCellTokenCommand(JsonObject message){
        int CellRow = message.getInt("CellRow");
        int CellCol = message.getInt("CellCol");
        String Token = message.getString("Token");
        
        this.Client.UpdateCellToken(CellRow, CellCol, Token);
    }
    
    public void UpdateChatCommand(JsonObject message){
        String UserName = message.getString("UserName");
        String ChatMessage = message.getString("ChatMessage");
        
        this.Client.UpdateChat(UserName, ChatMessage);
    }
}
