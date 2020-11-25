package com.softwarecrafter.springbootsample.web;

import com.softwarecrafter.springbootsample.AbstractTest;
import com.softwarecrafter.springbootsample.persistence.model.Book;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BookControllerTest extends AbstractTest {

    private final String SERVER_ROOT = "http://localhost:8081/api/books";

    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    @Test
    public void getBookList() throws Exception {

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(SERVER_ROOT)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Book[] bookList = super.mapFromJson(content, Book[].class);
        assertTrue(bookList.length > 0);

    }

    @Test
    public void createBook() throws Exception {

        Book book = new Book();
        book.setId(10L);
        book.setTitle("Test Title");
        book.setAuthor("Test Author");

        String inputJson = super.mapToJson(book);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(SERVER_ROOT)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(201, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, "{\"id\":10,\"title\":\"test title\",\"author\":\"test author\"}");
    }

    public void updateBook() throws Exception {

        Book book = new Book();
        book.setId(10L);
        book.setTitle("Test Title");
        book.setAuthor("Test Author");

        String inputJson = super.mapToJson(book);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(SERVER_ROOT)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(201, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, "{\"id\":10,\"title\":\"Test Title\",\"author\":\"Test Author\"}");

        book.setTitle("Test Title Update");

        inputJson = super.mapToJson(book);
        mvcResult = mvc.perform(MockMvcRequestBuilders.post(SERVER_ROOT)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();

        status = mvcResult.getResponse().getStatus();
        assertEquals(201, status);
        content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, "{\"id\":10,\"title\":\"Test Title Update\",\"author\":\"Test Author\"}");

    }

}
