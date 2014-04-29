/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Networking.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 *
 * @author Shazzama.Pajama
 */
public class UserThread extends Thread {
    RPGConnectorServer Server;
    UserMessageProcessor MessageReader;
    Socket Client;
    BufferedReader ClientReader;
    User   user;
    
    public UserThread(Socket client, RPGConnectorServer server) throws IOException{
        Server = server;
        MessageReader = new UserMessageProcessor(user, Server);
        Client = client;
        ClientReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
    }
    
    
    
}
