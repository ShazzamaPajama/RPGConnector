/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Networking.Server;

import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author Shazzama.Pajama
 */
public class User {
    private String Username;
    private Socket Client;
    
    
    public User(String name, Socket connection){
        Username = name;
        Client = connection;
        
    }
    
    public String getName(){
        return this.Username;
    }
    
    public Socket getClient(){
        return this.Client;
    }
    
}
