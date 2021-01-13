package ru.itsjava.service;

import java.io.OutputStream;
import java.io.PrintWriter;

public class MessageOutputServiceImpl implements MessageOutputService {

    private final PrintWriter writer;


    public MessageOutputServiceImpl(OutputStream outputStream) {
        writer = new PrintWriter(outputStream);
    }

    @Override
    public void printMessage(String message) {
        writer.println(message);
        writer.flush();
    }
}
