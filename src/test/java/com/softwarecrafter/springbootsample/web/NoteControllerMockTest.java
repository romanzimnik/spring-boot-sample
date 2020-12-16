package com.softwarecrafter.springbootsample.web;

import com.softwarecrafter.springbootsample.persistence.repository.NoteRepository;
import com.softwarecrafter.springbootsample.web.controller.NoteController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(NoteController.class)
public class NoteControllerMockTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private NoteRepository repo;

    @Test
    public void getAllNotes() throws Exception {

        MvcResult result = mvc.perform( MockMvcRequestBuilders
                .get("/api/notes")

                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk()
//                .andExpect(MockMvcResultMatchers.jsonPath("$note").exists())
//                .andExpect(MockMvcResultMatchers.jsonPath("$note[*].id").isNotEmpty()

        )
        .andExpect(jsonPath("$").doesNotExist())
                .andReturn();

        String body = result.getResponse().getContentAsString();
        System.out.println("Body: " + body);

    }

}
