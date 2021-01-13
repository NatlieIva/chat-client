package ru.itsjava.service;

import lombok.SneakyThrows;
import ru.itsjava.model.User;
import ru.itsjava.util.Settings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientImpl implements Client {
//    private User user;

    @SneakyThrows
    @Override
    public void start() {
        Socket socket = new Socket(Settings.getValue("HOST"), Integer.parseInt(Settings.getValue("PORT")));

        if (socket.isConnected()) {
            System.out.println("I'm connected");

            MessageInputServiceImpl consoleReader = new MessageInputServiceImpl(System.in);
            MessageOutputServiceImpl serverWriter = new MessageOutputServiceImpl(socket.getOutputStream());

            new Thread(new SocketRunnable(socket)).start();

            System.out.println("Enter your login");
            String name = consoleReader.getMessage();
            System.out.println("Enter your password");
            String password = consoleReader.getMessage();
            User user = new User(name, password);

            serverWriter.printMessage("!auth!" + user.getName() + ":" + user.getPassword());

            while (true) {
                serverWriter.printMessage(consoleReader.getMessage());
            }
        }
    }
}
