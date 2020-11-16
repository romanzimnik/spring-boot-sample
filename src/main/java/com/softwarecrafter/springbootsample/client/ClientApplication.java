package com.softwarecrafter.springbootsample.client;

import java.util.Arrays;

public class ClientApplication {

    public static void main(String[] args) {

        ClientHandler client = new ClientHandler();

        if(Arrays.stream(args).count() == 1) {
            switch (args[0]) {
                case "create":
                    client.createBooks();
                case "list":
                case "delete":
                    client.deleteBooks();

            }
        }
    }
}
