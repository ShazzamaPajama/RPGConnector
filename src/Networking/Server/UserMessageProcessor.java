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
    
    
    public UserMessageProcessor(RPGConnectorServer server){
        Server = server;
    }
    
    public void ProcessMessage(JsonObject message){
        
    }
    
    
}
