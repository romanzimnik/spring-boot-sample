package com.softwarecrafter.springbootsample.web;

import com.softwarecrafter.springbootsample.AbstractTest;
import com.softwarecrafter.springbootsample.persistence.model.Note;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NoteControllerTest extends AbstractTest {

    private final String SERVER_ROOT = "http://localhost:8081/api/notes";

    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    @Test
    public void getNoteList() throws Exception {

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(SERVER_ROOT)
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
        note.setId(10L);
        note.setTitle("Test Title");
        note.setAuthor("Test Author");

        String inputJson = super.mapToJson(note);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(SERVER_ROOT)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(201, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, "{\"id\":10,\"title\":\"Test Title\",\"author\":\"Test Author\"}");
    }

    @Test
    public void updateNote() throws Exception {

        Note note = new Note();
        note.setId(10L);
        note.setTitle("Test Title");
        note.setAuthor("Test Author");

        String inputJson = super.mapToJson(note);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(SERVER_ROOT)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(201, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, "{\"id\":10,\"title\":\"Test Title\",\"author\":\"Test Author\"}");

        note.setTitle("Test Title Update");
        note.setAuthor("Test Author Update");

        inputJson = super.mapToJson(note);
        mvcResult = mvc.perform(MockMvcRequestBuilders.post(SERVER_ROOT)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();

        status = mvcResult.getResponse().getStatus();
        assertEquals(201, status);
        content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, "{\"id\":10,\"title\":\"Test Title Update\",\"author\":\"Test Author Update\"}");
    }

    @Test
    public void deleteNote() throws Exception {

        Note note = new Note();
        note.setId(10L);
        note.setTitle("Test Title");
        note.setAuthor("Test Author");

        String inputJson = super.mapToJson(note);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(SERVER_ROOT)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(201, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, "{\"id\":10,\"title\":\"Test Title\",\"author\":\"Test Author\"}");

        mvc.perform(MockMvcRequestBuilders.delete(SERVER_ROOT + "/" + note.getId())
                .contentType(MediaType.APPLICATION_JSON).content(inputJson));

        mvcResult = mvc.perform(MockMvcRequestBuilders.get(SERVER_ROOT)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        content = mvcResult.getResponse().getContentAsString();
        Note[] noteList = super.mapFromJson(content, Note[].class);
        for (Note note1 : noteList) {
            System.out.println(note1.getId());
        }
        assertTrue(noteList.length == 0);

    }

}
