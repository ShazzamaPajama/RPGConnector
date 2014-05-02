/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Networking.Server;

import javax.json.JsonObject;

/**
 *
 * @author Shazzama.Pajama
 */
public class UserMessageProcessor {
    private RPGConnectorServer Server;
    private String UserName;
    
    
    public UserMessageProcessor(RPGConnectorServer server){
        Server = server;
        UserName = "";
    }
    
    public void ProcessMessage(JsonObject message){
        try{
        switch(message.getString("Message")){
            case "UpdateName": 
                this.UpdateName(message);
                break;
            
            case "UpdateChat":
                this.UpdateChat(UserName, message);
                break;
                
            case "UpdateToken":
                this.UpdateToken(message);
                break;
                
            case "UpdateColor":
                this.UpdateColor(message);
                break;
        }
        }catch(NullPointerException ex){
            
        }
    }
    
    
    public void UpdateName(JsonObject message){
        try{
            this.UserName = message.getString("Name");
        }catch(NullPointerException ex){   
        }
    }
    
    public void UpdateChat(String name, JsonObject message){
        try{
            String Name = name;
            String ChatMessage = message.getString("ChatMessage");
            this.Server.Updatechat(name, Name);
            
        }catch(NullPointerException ex){
            
        }
    }
    
    public void UpdateColor (JsonObject message){
        try{
            int row = message.getInt("CellRow");
            int col = message.getInt("CellCol");
            String Color = message.getString("Color");
            
            this.Server.UpdateCellColor(row, col, Color);
            
        }catch(NullPointerException ex){
            
        }
    }
    
    public void UpdateToken(JsonObject message){
        try{
            int row = message.getInt("CellRow");
            int col = message.getInt("CellCol");
            String Token = message.getString("Token");
            
            this.Server.UpdateCellToken(row, col, Token);
        }catch(NullPointerException ex){
            
        }
    }
    
    
}
