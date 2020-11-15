package com.softwarecrafter.springbootsample.client;

import com.google.gson.Gson;
import com.softwarecrafter.springbootsample.common.Utils;
import com.softwarecrafter.springbootsample.persistence.model.Book;
import org.apache.http.HttpResponse;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;

public class ClientHandler {

    private CloseableHttpClient client;
    private final String SERVER_ROOT = "http://localhost:8081/api/books";

    public ClientHandler() {
        this.client = HttpClientBuilder.create().build();
//        this.client = HttpClient.newBuilder()
//                .version(HttpClient.Version.HTTP_1_1)
//                .followRedirects(HttpClient.Redirect.NORMAL)
//                .connectTimeout(Duration.ofSeconds(20))
//                .authenticator(Authenticator.getDefault())
//                .build();
    }

    public void createBooks() {

        Gson gson = new Gson();
        Book book1 = Utils.createRandomBook();
        Book book2 = Utils.createRandomBook();
        Book book3 = Utils.createRandomBook();

        try {
            HttpResponse response1 = Request.Post(SERVER_ROOT).bodyString(gson.toJson(book1), ContentType.APPLICATION_JSON).execute().returnResponse();
            HttpResponse response2 = Request.Post(SERVER_ROOT).bodyString(gson.toJson(book2), ContentType.APPLICATION_JSON).execute().returnResponse();
            HttpResponse response3 = Request.Post(SERVER_ROOT).bodyString(gson.toJson(book3), ContentType.APPLICATION_JSON).execute().returnResponse();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
