package com.tactfactory.demo1.net;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class DemoClient {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 8080);
            ObjectOutputStream srvStreamOut = new ObjectOutputStream(socket.getOutputStream());
            srvStreamOut.flush();
            ObjectInputStream srvStreamIn = new ObjectInputStream(socket.getInputStream());

            Scanner in = new Scanner(System.in);
            String val = "";

            do {
                System.out.print("say : ");
                val = in.nextLine();

                if (val.equals("quit")) {
                    break;
                }

                if (!val.equals("")) {
                    srvStreamOut.writeObject(val);
                    srvStreamOut.flush();

                    String responce = (String) srvStreamIn.readObject();


                    if (!responce.equals("ok from server")) {
                        System.err.println("No server responce !");
                    }
                }
            } while(true);

            srvStreamOut.close();
            srvStreamIn.close();
            socket.close();
            in.close();

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
