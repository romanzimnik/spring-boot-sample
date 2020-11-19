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
import java.util.List;

public class ClientHandler {

    private CloseableHttpClient client;
    private final String SERVER_ROOT = "http://localhost:8081/api/books";
    Gson gson = new Gson();

    public ClientHandler() {
        this.client = HttpClientBuilder.create().build();
    }

    public void createBooks() {

        List<Book> listOfBooks = Utils.generateListOfBooks(5);

        try {
            for(Book book : listOfBooks) {
                HttpResponse response = Request.Post(SERVER_ROOT).bodyString(gson.toJson(book), ContentType.APPLICATION_JSON).execute().returnResponse();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public void deleteBook() {

        try {
            HttpResponse response = Request.Delete(SERVER_ROOT + "/" + "0").execute().returnResponse();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public void deleteBooks() {

        Gson gson = new Gson();

        try {
            HttpResponse allBooks = Request.Get(SERVER_ROOT).execute().returnResponse();
            String books = EntityUtils.toString(allBooks.getEntity());
            Book[] bookList = gson.fromJson(books, Book[].class);

            for(Book book : bookList) {
                HttpResponse response = Request.Delete(SERVER_ROOT + "/" + book.getId()).execute().returnResponse();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
