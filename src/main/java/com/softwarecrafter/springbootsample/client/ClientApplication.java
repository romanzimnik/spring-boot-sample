package com.softwarecrafter.springbootsample.client;

import java.util.Arrays;

/**
 * This is a sample client application you can use from command line executing it with one of those program arguments
 * listed within the switch case instruction.
 */
public class ClientApplication {

    public static void main(String[] args) {

        ClientHandler client = new ClientHandler();

        if(Arrays.stream(args).count() == 1) {
            switch (args[0]) {
                case "create":
                    client.createBooks();
                    break;
                case "read-all":
                    client.getAllBooks();
                    break;
                case "read-first":
                    client.getFirst();
                    break;
                case "update":
                    client.updateBooks();
                    break;
                case "delete":
                    client.deleteBooks();
                    break;
            }
        }
    }
}
