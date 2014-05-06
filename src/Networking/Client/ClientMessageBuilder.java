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
    
    public JsonObject UpdateTokenMessage(int row, int col, String token){
        JsonObject message = Json.createObjectBuilder()
                .add("MessageType", "UpdateToken")
                .add("CellRow", row)
                .add("CellCol", col)
                .add("Token", token)
                .build();
        
        return message;
    }
    
    public JsonObject UpdateColorMessage(int row, int col, String color){
        JsonObject message = Json.createObjectBuilder()
                .add("MessageType", "UpdateColor")
                .add("CellRow", row)
                .add("CellCol", col)
                .add("Color", color)
                .build();
        
        return message;
    }
    
    public JsonObject UpdateNameMessage(String username){
        JsonObject message = Json.createObjectBuilder()
                .add("MessageType", "UpdateName")
                .add("Name", username)
                .build();
        
        return message;
    }
}
