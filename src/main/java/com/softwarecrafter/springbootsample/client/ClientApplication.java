package com.softwarecrafter.springbootsample.client;

import java.util.Arrays;

/**
 * This is a sample client application you can use from command line executing it with one of those program arguments
 * listed within the switch case instruction.
 *
 * @author roman (rzett) from software-crafter.com
 */
public class ClientApplication {

    public static void main(String[] args) {

        ClientHandler client = new ClientHandler();

        if(Arrays.stream(args).count() == 1) {
            switch (args[0]) {
                case "create":
                    client.createNotes();
                    break;
                case "read-all":
                    client.getAllNotes();
                    break;
                case "read-first":
                    client.getFirst();
                    break;
                case "update":
                    client.updateNotes();
                    break;
                case "delete":
                    client.deleteNotes();
                    break;
            }
        }
    }
}
