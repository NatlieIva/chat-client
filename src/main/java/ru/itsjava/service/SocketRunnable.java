package ru.itsjava.service;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

import java.net.Socket;

@AllArgsConstructor
public class SocketRunnable implements Runnable {

    private final Socket socket;

    @SneakyThrows
    @Override
    public void run() {
        MessageInputServiceImpl serverReader = new MessageInputServiceImpl(socket.getInputStream());
        String serverMessage;
        while ((serverMessage = serverReader.getMessage()) != null) {
            System.out.println(serverMessage);
        }
    }
}
