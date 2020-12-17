package ru.itsjava;

import ru.itsjava.util.Settings;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class AppClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(Settings.getValue("HOST"), Integer.parseInt(Settings.getValue("PORT")));

        if (socket.isConnected()){
            System.out.println("I'm connected");

            PrintWriter serverWriter = new PrintWriter(socket.getOutputStream());
            serverWriter.println("Privet from client");
            serverWriter.flush();
        }
    }
}
