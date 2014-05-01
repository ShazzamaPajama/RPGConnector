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
        
        switch(message.getString("Message")){
            case "UpdateName": 
                this.UpdateName(message);
                break;
             
        }
    }
    
    
    public void UpdateName(JsonObject message){
        try{
            this.UserName = message.getString("Name");
            
        }catch(NullPointerException ex){
            
        }
    }
    
}
