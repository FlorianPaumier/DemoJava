package com.tactfactory.demo1.net;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class RemoteClient implements Runnable {

    private boolean isRunning = true;
    private Thread internalProcess;

    private Socket socket;
    private ObjectOutputStream out;
    private ObjectInputStream in;

    public RemoteClient(Socket socket) {
        this.socket = socket;
        System.out.println("> New client connection !");

        try {
            this.out = new ObjectOutputStream(
                    this.socket.getOutputStream());
            this.out.flush();

            this.in = new ObjectInputStream(
                    this.socket.getInputStream());

        } catch (Exception e) {
        }

        this.internalProcess = new Thread(this);
        this.internalProcess.setName(this.getIp());
        this.internalProcess.start();
    }

    @Override
    public void run() {
        while(isRunning) {
            try {
                String message = (String) this.in.readObject();
                System.out.println("Recieve data from client [" + this.getIp() + "] : " + message);

                // Output stream to Client.
                this.out.writeObject("ok from server");
                this.out.flush();
                System.out.println("> Send data to client");
            } catch (Exception e) {
                isRunning = false;
                this.close();
            }
        }
    }

    public String getIp() {
        return this.socket.getInetAddress().getHostAddress();
    }

    public void close() {
        System.out.println("> Close client ressources");
        try {
            this.in.close();
            this.out.close();
            this.socket.close();
        } catch (Exception e) {
        }
    }






}
