package com.softwarecrafter.springbootsample.client.note;

import com.google.gson.Gson;
import com.softwarecrafter.springbootsample.common.Utils;
import com.softwarecrafter.springbootsample.persistence.model.Note;
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

/**
 * @author roman (rzett) from software-crafter.com
 */
public class NoteClientHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(NoteClientHandler.class);

    private final CloseableHttpClient client;
    private final String SERVER_ROOT = "http://localhost:8081/api/note";
    Gson gson = new Gson();

    /**
     * Initializing the HttpClient by HttpClientbuilder.
     */
    public NoteClientHandler() {
        this.client = HttpClientBuilder.create().build();
    }

    /**
     * Method for creating a set of n notes, leveraged by using the Utils class and persisting it to the configured
     * MongoDB instance.
     */
    private void createNotes() {

        List<Note> listOfNotes = Utils.generateListOfNotes(5);

        LOGGER.info("Creating notes...");

        try {
            for(Note note : listOfNotes) {
                HttpResponse response = Request.Post(SERVER_ROOT)
                        .bodyString(gson.toJson(note), ContentType.APPLICATION_JSON).execute().returnResponse();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        LOGGER.info("Notes created and persisted!");
    }

    /**
     * Method for retrieving all notes from database.
     */
    private void getAllNotes() {

        try {
            HttpResponse response = Request.Get(SERVER_ROOT).execute().returnResponse();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * Method for updating the persisted set of data in the database.
     */
    private void updateNotes() {

        Gson gson = new Gson();

        try {

            HttpResponse allNotes = Request.Get(SERVER_ROOT).execute().returnResponse();
            String notes = EntityUtils.toString(allNotes.getEntity());
            Note[] noteList = gson.fromJson(notes, Note[].class);

            for (Note note : noteList) {
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
    private void deleteNotes() {

        try {
            HttpResponse allNotes = Request.Get(SERVER_ROOT).execute().returnResponse();
            String notes = EntityUtils.toString(allNotes.getEntity());
            Note[] noteList = gson.fromJson(notes, Note[].class);

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
                createNotes();
                break;
            case "read-all":
                getAllNotes();
                break;
            case "read-first":
                getFirst();
                break;
            case "update":
                updateNotes();
                break;
            case "delete":
                deleteNotes();
                break;
        }
    }
}
