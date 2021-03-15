package com.softwarecrafter.springbootsample.web;

import com.google.gson.Gson;
import com.softwarecrafter.springbootsample.AbstractTest;
import com.softwarecrafter.springbootsample.persistence.model.Note;
import com.softwarecrafter.springbootsample.web.controller.NoteController;
import org.apache.commons.codec.CharEncoding;
import org.bson.types.ObjectId;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.codec.Utf8;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.nio.charset.Charset;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NoteControllerTest extends AbstractTest {

    private final String SERVER_ROOT = "http://localhost:8081/api/note";

//    @InjectMocks
    @Autowired
    private NoteController noteController;

    private MockMvc mvc;

    private Gson gson;

    @Override
    @Before
    public void setUp() {
        super.setUp();
        this.gson = new Gson();
        this.mvc = MockMvcBuilders.standaloneSetup(noteController)
                .setControllerAdvice().alwaysExpect(
                        MockMvcResultMatchers.content().contentType("application/json")).build();
    }

    @Test
    public void getNoteList() throws Exception {

        MvcResult mvcResult = mvc.perform(get(SERVER_ROOT)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Note[] noteList = super.mapFromJson(content, Note[].class);
        assertTrue(noteList.length > 0);
    }

    @Test
    public void createNote() throws Exception {

        Note note = new Note();
        note.setId(new ObjectId());
        note.setTitle("Test Title");
        note.setCreator("Test Author");
        note.setContent("Test Content");

        String inputJson = super.mapToJson(note);
        MvcResult mvcResult = mvc.perform(
                post(SERVER_ROOT)
                    .contentType(MediaType.APPLICATION_JSON_VALUE)
                    .content(inputJson))
                .andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(201, status);
        String content = mvcResult.getResponse().getContentAsString();

        Note response = gson.fromJson(content, Note.class);
        assertEquals(note, response);
    }

    @Test
    public void updateNote() throws Exception {

        Note note = new Note();
        note.setId(new ObjectId());
        note.setTitle("Test Title");
        note.setCreator("Test Author");
        note.setContent("Test Content");

        String inputJson = super.mapToJson(note);
        MvcResult mvcResult = mvc.perform(post(SERVER_ROOT)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(201, status);
        String content = mvcResult.getResponse().getContentAsString();

        Note response = gson.fromJson(content, Note.class);
        assertEquals(note, response);

        note.setTitle("Test Title Update");
        note.setCreator("Test Author Update");
        note.setContent("Test Content Update");

        inputJson = super.mapToJson(note);
        mvcResult = mvc.perform(post(SERVER_ROOT)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();

        status = mvcResult.getResponse().getStatus();
        assertEquals(201, status);
        content = mvcResult.getResponse().getContentAsString();

        response = gson.fromJson(content, Note.class);
        assertEquals(note, response);
    }

    @Test
    public void deleteNote() throws Exception {

        Note note = new Note();
        note.setId(new ObjectId());
        note.setTitle("Test Title");
        note.setCreator("Test Author");
        note.setContent("Test Content");
//
        String inputJson = super.mapToJson(note);
//        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(SERVER_ROOT)
//                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
//
//        int status = mvcResult.getResponse().getStatus();
//        assertEquals(201, status);
//        String content = mvcResult.getResponse().getContentAsString();
//
//        Note response = gson.fromJson(content, Note.class);
//        assertEquals(note, response);
//
//        mvc.perform(MockMvcRequestBuilders.delete(SERVER_ROOT + "/" + note.getId())
//                .contentType(MediaType.APPLICATION_JSON).content(inputJson));
//
//        mvcResult = mvc.perform(MockMvcRequestBuilders.get(SERVER_ROOT)
//                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
//
//        content = mvcResult.getResponse().getContentAsString();
//        Note[] noteList = super.mapFromJson(content, Note[].class);
//        for (Note note1 : noteList) {
//            System.out.println(note1.getId());
//        }
//        assertEquals(noteList.length, 0);

        MvcResult mvcResult = this.mvc.perform(
                delete(SERVER_ROOT + "/" + note.getId()))
                .andExpect(status().isOk()).andReturn();

        System.out.println(mvcResult.toString());

    }

}
