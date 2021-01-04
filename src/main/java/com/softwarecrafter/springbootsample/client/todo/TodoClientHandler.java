package com.softwarecrafter.springbootsample.client.todo;

import com.google.gson.Gson;
import com.softwarecrafter.springbootsample.common.Utils;
import com.softwarecrafter.springbootsample.middleware.dto.TodoDTO;
import com.softwarecrafter.springbootsample.persistence.model.Note;
import com.softwarecrafter.springbootsample.persistence.model.Todo;
import org.apache.http.HttpResponse;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class TodoClientHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(TodoClientHandler.class);

    private CloseableHttpClient client;
    private final String SERVER_ROOT = "http://localhost:8081/api/todos";
    Gson gson = new Gson();

    /**
     * Initializing the HttpClient by HttpClientbuilder.
     */
    public TodoClientHandler() {
        this.client = HttpClientBuilder.create().build();
    }


    private void createTodos() {

        List<TodoDTO> listOfTodos = Utils.generateListOfTodos(5);

        LOGGER.info("Creating Todos...");

        try {
            for(TodoDTO todo : listOfTodos) {
                HttpResponse response = Request.Post(SERVER_ROOT)
                        .bodyString(gson.toJson(todo), ContentType.APPLICATION_JSON).execute().returnResponse();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        LOGGER.info("Todos created and persisted!");
    }

    /**
     * Method for retrieving all Todos from database.
     */
    private void getAllTodos() {

        try {
            HttpResponse response = Request.Get(SERVER_ROOT).execute().returnResponse();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * Method for updating the persisted set of data in the database.
     */
    private void updateTodos() {

        try {

            HttpResponse allTodos = Request.Get(SERVER_ROOT).execute().returnResponse();
            String todos = EntityUtils.toString(allTodos.getEntity());
            List<TodoDTO> todoList = Arrays.asList(gson.fromJson(todos, TodoDTO[].class));

            for (ListIterator<TodoDTO> iterator = todoList.listIterator(); iterator.hasNext();) {
                TodoDTO todo = iterator.next();
                todo.setTitle(todo.getTitle().replace("Title", "NewTitle"));

                HttpResponse response = Request.Put(SERVER_ROOT + "/" + todo.getId())
                        .bodyString(gson.toJson(todo), ContentType.APPLICATION_JSON).execute().returnResponse();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * Mehod for deleting the whole chosen selection.
     */
    private void deleteTodos() {

        try {
            HttpResponse allTodos = Request.Get(SERVER_ROOT).execute().returnResponse();
            String todos = EntityUtils.toString(allTodos.getEntity());
            List<TodoDTO> todoList = Arrays.asList(gson.fromJson(todos, TodoDTO[].class));

            for(TodoDTO todo : todoList) {
                HttpResponse response = Request.Delete(SERVER_ROOT + "/" + todo.getId()).execute().returnResponse();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * Mehod for retrieving the first entry of a collection.
     */
    private void getFirst() {

        try {
            HttpResponse response = Request.Get(SERVER_ROOT + "/" + 0).execute().returnResponse();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public void execute(String arg) {
        switch (arg) {
            case "create":
                createTodos();
                break;
            case "read-all":
                getAllTodos();
                break;
            case "read-first":
                getFirst();
                break;
            case "update":
                updateTodos();
                break;
            case "delete":
                deleteTodos();
                break;
        }
    }
}
