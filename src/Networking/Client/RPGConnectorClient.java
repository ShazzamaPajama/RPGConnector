/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Networking.Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author Shazzama.Pajama
 */
public class RPGConnectorClient {
    private Socket Client;
    private PrintWriter ServerWriter;
    private ClientMessageBuilder MessageBuilder;
    private ClientThread ProcessingThread;
    private BufferedReader ServerReader;
    
    
    public RPGConnectorClient(String Host) throws IOException{
        Client = new Socket(Host, 1337);
        ServerWriter = new PrintWriter(Client.getOutputStream(), true);
        MessageBuilder = new ClientMessageBuilder();
        ServerReader = new BufferedReader(new InputStreamReader(Client.getInputStream()));
    }
    
    public void StartClientThread(){
        new ClientThread(ServerReader).start();
    }
}
