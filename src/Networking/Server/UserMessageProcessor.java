/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Networking.Server;

/**
 *
 * @author Shazzama.Pajama
 */
public class UserMessageProcessor {
    private RPGConnectorServer Server;
    private User client;
    
    
    public UserMessageProcessor(User c, RPGConnectorServer server){
        Server = server;
        client = c; 
    }
    
    
}
