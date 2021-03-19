package com.softwarecrafter.springbootsample.web.controller;

import com.softwarecrafter.springbootsample.middleware.dto.NoteDTO;
import com.softwarecrafter.springbootsample.middleware.services.NoteService;
import com.softwarecrafter.springbootsample.web.exception.NoteNotFoundException;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author roman (romanzimnik) from software-crafter.com
 */
@RestController
@RequestMapping("/api/note")
@CrossOrigin(origins = "http://localhost:4200")
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
    public NoteDTO findOne(@PathVariable ObjectId id) {
        return service.findById(id);
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

