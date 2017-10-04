package com.tactfactory.demo1.net;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class DemoServer {

    public static void main(String[] args) {
        try {
            boolean isRunning = true;
            // Start listener of socket.
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("> Start server endpoint !");

            while(isRunning) {
                // Accept connection from Client to Server.
                Socket socket = serverSocket.accept();

                RemoteClient maxime = new RemoteClient(socket);
            }

            System.out.println("> Close server ressources");
            serverSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
