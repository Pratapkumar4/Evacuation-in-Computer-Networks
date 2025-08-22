package org.example;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
//
//class ClientHandler implements Runnable {
//    private Socket socket;
//
//    public ClientHandler(Socket socket) {
//        this.socket = socket;
//    }
//    public void run() {
//        try {
//            // Handle communication with the client
//            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
//            String message = (String) ois.readObject();
//            System.out.println("Received: " + message);
//
//            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
//            oos.writeObject("ack");
//
//            ois.close();
//            oos.close();
//            socket.close();
//        } catch (Exception e) {
//            System.out.println("Error handling client: " + e);
//        }
//    }
//}

class ClientHandler implements Runnable {
    private Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try (ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
             ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream())) {

            String message = (String) ois.readObject();
            System.out.println("Received message: " + message);

            oos.writeObject("ack");
            System.out.println("Sent ack to client");

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error handling client: " + e);
        }
    }
}