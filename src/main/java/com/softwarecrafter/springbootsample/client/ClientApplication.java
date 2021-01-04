package com.softwarecrafter.springbootsample.client;

import com.softwarecrafter.springbootsample.client.note.NoteClientHandler;
import com.softwarecrafter.springbootsample.client.todo.TodoClientHandler;

import java.util.Arrays;

/**
 * This is a sample client application you can use from command line executing it with one of those program arguments
 * listed within the switch case instruction.
 *
 * @author roman (rzett) from software-crafter.com
 */
public class ClientApplication {

    public static void main(String[] args) {

        NoteClientHandler noteClient = new NoteClientHandler();
        TodoClientHandler todoClient = new TodoClientHandler();

        if(Arrays.stream(args).count() == 1) {
            switch (args[0]) {
                case "note":
                    noteClient.execute(args[1]);
                    break;
                case "todo":
                    todoClient.execute(args[1]);
                    break;
            }
        }
    }
}
