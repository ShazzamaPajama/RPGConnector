/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Networking.Client;

import java.math.BigDecimal;
import javax.json.Json;
import javax.json.JsonObject;

/**
 *
 * @author Shazzama.Pajama
 */
public class ClientMessageBuilder {
    
    public ClientMessageBuilder(){
        
    }
    
    public JsonObject ChatUpdateMessage(String ChatMessage){
        JsonObject message = Json.createObjectBuilder()
                .add("MessageType", "UpdateChat")
                .add("ChatMessage", ChatMessage)
                .build();
        
        return message;
    }
}
