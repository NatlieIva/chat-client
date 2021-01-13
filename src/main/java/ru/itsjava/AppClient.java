package ru.itsjava;

import ru.itsjava.service.ClientImpl;

public class AppClient {
    public static void main(String[] args){
        new ClientImpl().start();
    }
}
