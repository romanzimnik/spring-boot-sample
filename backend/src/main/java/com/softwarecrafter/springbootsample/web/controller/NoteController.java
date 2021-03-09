package com.softwarecrafter.springbootsample.web.controller;

import com.softwarecrafter.springbootsample.middleware.dto.NoteDTO;
import com.softwarecrafter.springbootsample.middleware.services.NoteService;
import com.softwarecrafter.springbootsample.persistence.model.Note;
import com.softwarecrafter.springbootsample.web.exception.NoteIdMismatchException;
import com.softwarecrafter.springbootsample.web.exception.NoteNotFoundException;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

/**
 * @author roman (romanzimnik) from software-crafter.com
 */
@RestController
@RequestMapping("/api/note")
public class NoteController {

    private static final Logger LOGGER = LoggerFactory.getLogger(NoteController.class);

    private final NoteService service;

    @Autowired
    public NoteController(NoteService service) {
        this.service = service;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Iterable<NoteDTO> findAll() {
        return service.findAllNotes();
    }

    @GetMapping("/{id}")
    public Optional<NoteDTO> findOne(@PathVariable ObjectId id) {
        return service.findById(id)
                .orElseThrow(() -> (new NoteNotFoundException));
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public NoteDTO create(@RequestBody @Valid NoteDTO note) {
        return service.create(note);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable ObjectId id) {
        service.delete(id);
    }

    @PutMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public NoteDTO update(@RequestBody NoteDTO note) {
        return service.update(note);
    }
}

