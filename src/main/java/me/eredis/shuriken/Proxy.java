package me.eredis.shuriken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Proxy implements Runnable {

    private ServerSocket serverSocket;

    public Proxy(int port) {
        try {
            this.serverSocket = new ServerSocket(port);

            System.out.println("Shuriken Proxy listening on port " + port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void listen() {
        while(!serverSocket.isClosed()) {
            try {
                Socket socket = serverSocket.accept();

                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                System.out.println(bufferedReader.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void run() {

    }
}
