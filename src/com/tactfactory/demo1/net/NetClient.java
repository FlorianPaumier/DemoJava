package com.tactfactory.demo1.net;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Map.Entry;

public class NetClient implements Runnable {

    private String userName;

    private final Thread thread;
    private final Socket socket;

    private final DemoServer server;
    private ObjectOutputStream out;
    private ObjectInputStream in;
    private boolean isRunning = true;

    public NetClient(Socket socket, DemoServer server) {
        this.socket = socket;
        this.server = server;
        System.out.println(String.format("> New client connection from %s !", this.getIp()));

        try {
            this.out = new ObjectOutputStream(
                    this.socket.getOutputStream());
            this.out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            this.in = new ObjectInputStream(
                    this.socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.thread = new Thread(this);
        this.thread.setName(this.getIp());
        this.thread.start();

        this.userName = this.getIp();
    }

    @Override
    public void run() {
        while (this.isRunning) {
            try {
                String message = this.receiveMessage();

                if (message != null) {

                    if (message.startsWith("/")) {
                        if (message.contains("/setname")) {
                            String[] smsg = message.split(" ");
                            if (smsg.length > 1 && smsg.length < 3) {
                                this.userName = smsg[1];
                            }
                        }
                        if (message.contains("/blacklist")) {
                            for (Entry<String, NetClient> item : this.server.cacheClients.entrySet()) {
                                System.out.println(String.format("%s %s", item.getKey(), item.getValue().getUserName()));
                            }
                        }
                        if (message.contains("/ban")) {
//                        	String[] smsg = message.split(" ");
//                            if (smsg.length > 1 && smsg.length < 3) {
//                                this.userName = smsg[1];
//                            }

                        }
                    } else {
                        message = String.format("%s : %s", this.userName, message);
                        for (NetClient client : this.server.cacheClients.values()) {
                            client.sendMessage(message);
                        }
                    }
                } else {
                    Thread.sleep(100);
                }

            }catch (Exception e) {
                System.err.println("Error on client : " + this.getIp());
                this.isRunning = false;
                this.server.cacheClients.remove(this.getIp());
                this.close();
//                e.printStackTrace();
            }
        }
    }

    private Object getUserName() {
        // TODO Auto-generated method stub
        return null;
    }

    private void sendMessage(String message) {
        try {
            this.out.writeObject(message);
            this.out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("> Send data to client");
    }

    private String receiveMessage() {
        String message = null;

        try {
            message = (String) this.in.readObject();
            System.out.println("Recieve data from client [" + this.getIp() + "] : " + message);
        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
        } catch (IOException e) {
//            e.printStackTrace();
        }

        return message;
    }

    public void close() {
        System.out.println(String.format("> Close client ressources for %s", this.getIp()));
        try {
            if (this.in != null) {
                this.in.close();
            }
            if (this.out != null) {
                this.out.close();
            }
            this.socket.close();
        } catch (IOException e) {
        }
    }

    public String getIp() {
        return this.socket.getInetAddress().getHostAddress();
    }
}
