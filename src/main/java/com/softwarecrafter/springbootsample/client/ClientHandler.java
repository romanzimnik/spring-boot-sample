package com.softwarecrafter.springbootsample.client;

import com.google.gson.Gson;
import com.softwarecrafter.springbootsample.common.Utils;
import com.softwarecrafter.springbootsample.persistence.model.Book;
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

public class ClientHandler {

    private CloseableHttpClient client;
    private final String SERVER_ROOT = "http://localhost:8081/api/books";
    Gson gson = new Gson();

    /**
     * Initializing the HttpClient by HttpClientbuilder.
     */
    public ClientHandler() {
        this.client = HttpClientBuilder.create().build();
    }

    /**
     * Method for creating a set of n books, leveraged by using the Utils class and persisting it to the configured
     * MongoDB instance.
     */
    public void createBooks() {

        List<Book> listOfBooks = Utils.generateListOfBooks(5);

        try {
            for(Book book : listOfBooks) {
                HttpResponse response = Request.Post(SERVER_ROOT)
                        .bodyString(gson.toJson(book), ContentType.APPLICATION_JSON).execute().returnResponse();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * Method for retrieving all books from database.
     */
    public void getAllBooks() {

        try {
            HttpResponse response = Request.Get(SERVER_ROOT).execute().returnResponse();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * Method for updating the persisted set of data in the database.
     */
    public void updateBooks() {

        Gson gson = new Gson();

        try {

            HttpResponse allBooks = Request.Get(SERVER_ROOT).execute().returnResponse();
            String books = EntityUtils.toString(allBooks.getEntity());
            List<Book> bookList = Arrays.asList(gson.fromJson(books, Book[].class));

            for (ListIterator<Book> iterator = bookList.listIterator(); iterator.hasNext();) {
                Book book = iterator.next();
                book.setTitle(book.getTitle().replace("Title", "NewTitle"));

                HttpResponse response = Request.Put(SERVER_ROOT + "/" + book.getId())
                        .bodyString(gson.toJson(book), ContentType.APPLICATION_JSON).execute().returnResponse();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * Mehod for deleting the whole chosen selection.
     */
    public void deleteBooks() {

        Gson gson = new Gson();

        try {
            HttpResponse allBooks = Request.Get(SERVER_ROOT).execute().returnResponse();
            String books = EntityUtils.toString(allBooks.getEntity());
            List<Book> bookList = Arrays.asList(gson.fromJson(books, Book[].class));

            for(Book book : bookList) {
                HttpResponse response = Request.Delete(SERVER_ROOT + "/" + book.getId()).execute().returnResponse();
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
