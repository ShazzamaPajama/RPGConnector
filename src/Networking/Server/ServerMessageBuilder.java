/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Networking.Server;

import java.math.BigDecimal;
import javax.json.Json;
import javax.json.JsonObject;

/**
 *
 * @author Shazzama.Pajama
 */
public class ServerMessageBuilder {
    
    public ServerMessageBuilder(){
        
    }
    
    public JsonObject UpdateCellColorMessage(int row, int col, String Color){
        JsonObject message = Json.createObjectBuilder()
                .add("MessageType", "UpdateCellColor")
                .add("CellRow", row)
                .add("CellCol", col)
                .add("Color", Color)
                .build();
        
        return message;
    }
    
    public JsonObject UpdateCellTokenMessage(int row, int col, String Token){
        JsonObject message = Json.createObjectBuilder()
                .add("MessageType", "UpdateCellToken")
                .add("CellRow", row)
                .add("CellCol", col)
                .add("Token", Token)
                .build();
        
        return message;
    }
    
    public JsonObject UpdateChatMessage(String UserName, String Message){
        JsonObject message = Json.createObjectBuilder()
                .add("MessageType", "UpdateChat")
                .add("UserName", UserName)
                .add("ChatMessage", Message)
                .build();
                
        return message;
    }
    
    public JsonObject UpdateNameListMessage(String name){
        JsonObject message = Json.createObjectBuilder()
                .add("MessageType", "UpdateNameList")
                .add("Name", name)
                .build();
        
        return message;
    }
    
    
}
