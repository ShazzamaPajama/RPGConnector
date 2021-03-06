/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Networking.Server;

import TacticalGrid.Grid;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.json.JsonObject;
import javax.swing.JOptionPane;

/**
 *
 * @author Shazzama.Pajama
 */
public class RPGConnectorServer {

    private ArrayList<PrintWriter> ClientOutputStreams;
    private ArrayList<String> Names;
    private ServerMessageBuilder MessageBuilder;
    private ServerThread ConnectionReceiver;
    private Grid TacticalGrid;
    private ServerSocket ServerConnection;

    public RPGConnectorServer() {
        try {
            ClientOutputStreams = new ArrayList<>();
            MessageBuilder = new ServerMessageBuilder();
            TacticalGrid = new Grid("NewGrid");
            Names = new ArrayList<>();

            ServerConnection = new ServerSocket(1337);
            this.StarServerThread();
            JOptionPane.showMessageDialog(null, "Server Started\n" + "Server Address: "
                    + InetAddress.getLocalHost().toString());

        } catch (IOException ex) {
            Logger.getLogger(RPGConnectorServer.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public RPGConnectorServer(Grid oldergrid) {

    }

    //Adding Client Methods
    public synchronized void addClientOutput(PrintWriter clientwriter) {
        this.ClientOutputStreams.add(clientwriter);
    }

    public synchronized void addName(String name) {
        Names.add(name);
    }

    //Cell Updating Methods
    public synchronized void UpdateCellColor(int row, int col, String Color) {
        //Update Cell Color
        this.TacticalGrid.setCellColor(row, col, Color);

        //Send update message to all users
        JsonObject message = MessageBuilder.UpdateCellColorMessage(row, col, Color);
        for (PrintWriter client : ClientOutputStreams) {
            client.println(message.toString());
        }

    }

    public synchronized void UpdateCellToken(int row, int col, String Token) {
        //update cell token
        this.TacticalGrid.setCellToken(row, col, Token);

        //Send Update message to all users
        JsonObject message = MessageBuilder.UpdateCellTokenMessage(row, col, Token);
        for (PrintWriter client : ClientOutputStreams) {
            client.println(message.toString());
        }
    }

    //Chat Methods
    public synchronized void Updatechat(String name, String chatmsg) {
        JsonObject message = MessageBuilder.UpdateChatMessage(name, chatmsg);

        for (PrintWriter client : ClientOutputStreams) {
            client.println(message);
        }

    }

    //UserList update methods
    public synchronized void PopulateUserList(PrintWriter clientout) {
        for (String name : this.Names) {

            JsonObject message = MessageBuilder.UpdateNameListMessage(name);
            clientout.println(message.toString());

        }
    }

    public synchronized void UpdateUserlist(String Name) {
        JsonObject message = MessageBuilder.UpdateNameListMessage(Name);
        for (PrintWriter client : ClientOutputStreams) {
            client.println(message.toString());
        }
    }

    //Server Thread messages
    private void StarServerThread() {
        new ServerThread(ServerConnection, this).start();
    }
}
