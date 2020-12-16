package com.softwarecrafter.springbootsample.client;

import com.google.gson.Gson;
import com.softwarecrafter.springbootsample.common.Utils;
import com.softwarecrafter.springbootsample.persistence.model.Note;
import org.apache.http.HttpResponse;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

/**
 * @author roman (rzett) from software-crafter.com
 */
public class ClientHandler {

    private CloseableHttpClient client;
    private final String SERVER_ROOT = "http://localhost:8081/api/notes";
    Gson gson = new Gson();

    /**
     * Initializing the HttpClient by HttpClientbuilder.
     */
    public ClientHandler() {
        this.client = HttpClientBuilder.create().build();
    }

    /**
     * Method for creating a set of n notes, leveraged by using the Utils class and persisting it to the configured
     * MongoDB instance.
     */
    public void createNotes() {

        List<Note> listOfNotes = Utils.generateListOfNotes(5);

        try {
            for(Note note : listOfNotes) {
                HttpResponse response = Request.Post(SERVER_ROOT)
                        .bodyString(gson.toJson(note), ContentType.APPLICATION_JSON).execute().returnResponse();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * Method for retrieving all notes from database.
     */
    public void getAllNotes() {

        try {
            HttpResponse response = Request.Get(SERVER_ROOT).execute().returnResponse();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * Method for updating the persisted set of data in the database.
     */
    public void updateNotes() {

        Gson gson = new Gson();

        try {

            HttpResponse allNotes = Request.Get(SERVER_ROOT).execute().returnResponse();
            String notes = EntityUtils.toString(allNotes.getEntity());
            List<Note> noteList = Arrays.asList(gson.fromJson(notes, Note[].class));

            for (ListIterator<Note> iterator = noteList.listIterator(); iterator.hasNext();) {
                Note note = iterator.next();
                note.setTitle(note.getTitle().replace("Title", "NewTitle"));

                HttpResponse response = Request.Put(SERVER_ROOT + "/" + note.getId())
                        .bodyString(gson.toJson(note), ContentType.APPLICATION_JSON).execute().returnResponse();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * Mehod for deleting the whole chosen selection.
     */
    public void deleteNotes() {

        Gson gson = new Gson();

        try {
            HttpResponse allNotes = Request.Get(SERVER_ROOT).execute().returnResponse();
            String notes = EntityUtils.toString(allNotes.getEntity());
            List<Note> noteList = Arrays.asList(gson.fromJson(notes, Note[].class));

            for(Note note : noteList) {
                HttpResponse response = Request.Delete(SERVER_ROOT + "/" + note.getId()).execute().returnResponse();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * Mehod for retrieving the first entry of a collection.
     */
    public void getFirst() {

        try {
            HttpResponse response = Request.Get(SERVER_ROOT + "/" + 0).execute().returnResponse();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
