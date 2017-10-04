package com.tactfactory.demo1.net;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class DemoClient {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 8080);

            ObjectOutputStream srvStreamOut = new ObjectOutputStream(socket.getOutputStream());
            srvStreamOut.writeObject("Hello W!");
            srvStreamOut.flush();

            ObjectInputStream srvStreamIn = new ObjectInputStream(socket.getInputStream());
            String responce = (String) srvStreamIn.readObject();

            srvStreamIn.close();
            srvStreamOut.close();
            socket.close();



        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
