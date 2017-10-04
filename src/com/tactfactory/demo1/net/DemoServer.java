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
                Socket client = serverSocket.accept();
                System.out.println("> New client connection !");

                ObjectOutputStream cltStreamOut = new ObjectOutputStream(
                        client.getOutputStream());
                cltStreamOut.flush();

                // Input stream from Client.
                ObjectInputStream cltStreamIn = new ObjectInputStream(
                        client.getInputStream());
                String message = (String) cltStreamIn.readObject();
                System.out.println("Recieve data from client [" + client.getInetAddress().getHostAddress() + "] : " + message);

                // Output stream to Client.
                cltStreamOut.writeObject("ok from server");
                cltStreamOut.flush();
                System.out.println("> Send data to client");

                System.out.println("> Close client ressources");
                cltStreamIn.close();
                cltStreamOut.close();
                client.close();
            }

            System.out.println("> Close server ressources");
            serverSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
