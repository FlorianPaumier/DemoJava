package com.tactfactory.demo1.net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

/** Main server. */
public class DemoServer {

    /** Listener socket */
    private ServerSocket serverSocket;

    /** Memory of connected client */
    HashMap<String, NetClient> cacheClients = new HashMap<String, NetClient>();

    /** State of main thread */
    private boolean isRunning = true;

    public void start() {
        try {
            this.serverSocket = new ServerSocket(8080);
            System.out.println("> Start server endpoint ! (listener)");

            while(this.isRunning ) {
                // Accept new connection from Client to Server.
                Socket clientSocket = this.serverSocket.accept();

                // Detect if DDOS or Spamm
                //TODO
                if (!cacheClients.containsKey(clientSocket.getInetAddress().getHostAddress())) {
                    // Create new Client object for multi-threading...
                    NetClient client = new NetClient(clientSocket, this);

                    // Add to memory of clients.
                    this.cacheClients.put(client.getIp(), client);
                } else {
//                    System.out.println("DDOS detected !! for : " + clientSocket.getInetAddress().getHostAddress());
                    clientSocket.close();
                }
            }

            System.out.println("> Close server ressources");
            serverSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new DemoServer().start();
    }
}
