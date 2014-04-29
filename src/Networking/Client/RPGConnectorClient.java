/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Networking.Client;

import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author Shazzama.Pajama
 */
public class RPGConnectorClient {
    private Socket Client;
    private PrintWriter ClientOuputStream;
    private ClientMessageBuilder MessageBuilder;
    private ServerMessagesThread ProcessingThread;
    
    
    
}
