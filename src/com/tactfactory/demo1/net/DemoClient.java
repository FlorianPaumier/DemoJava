package com.tactfactory.demo1.net;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class DemoClient implements Runnable {

    boolean isRunning = true;
    private Socket socket;
    private Scanner inKbd;
    private ObjectOutputStream out;
    private ObjectInputStream in;
    private Thread thread;

    public DemoClient(String host) {
        try {
            this.socket = new Socket(host, 8080);

            this.out = new ObjectOutputStream(this.socket.getOutputStream());
            this.out.flush();

            this.in = new ObjectInputStream(this.socket.getInputStream());

            this.inKbd = new Scanner(System.in);

            this.thread = new Thread(this);
            this.thread.start();
        } catch (Exception e) {
            // TODO: handle exception
        }


        String val = "";

        while(isRunning ){
            val = this.sendMessage();

            if (val.equals("quit")) {
                isRunning = false;
            }
        }
    }

    private void displayNewMessage() {
        try {
            String message = (String) this.in.readObject();
            System.out.println(message);
        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
        } catch (IOException e) {
//            e.printStackTrace();
        }
    }

    private String sendMessage() {
        System.out.print("say : ");
        String val = inKbd.nextLine();

        if (!val.equals("")) {
            try {
                this.out.writeObject(val);
                this.out.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return val;
    }

    public void close() {
        try {
            this.out.close();
            this.in.close();
            this.socket.close();
            this.inKbd.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while(isRunning) {
            this.displayNewMessage();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        DemoClient client = new DemoClient("127.0.0.1");
    }



}
