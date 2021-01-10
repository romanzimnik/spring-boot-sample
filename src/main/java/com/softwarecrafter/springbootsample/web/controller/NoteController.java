package com.softwarecrafter.springbootsample.web.controller;

import com.softwarecrafter.springbootsample.persistence.model.Note;
import com.softwarecrafter.springbootsample.persistence.repository.NoteRepository;
import com.softwarecrafter.springbootsample.web.exception.NoteIdMismatchException;
import com.softwarecrafter.springbootsample.web.exception.NoteNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * @author roman (romanzimnik) from software-crafter.com
 */
@RestController
@RequestMapping("/api/notes")
public class NoteController {

    @Autowired
    private NoteRepository noteRepository;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Note> findAll() {
        return noteRepository.findAll();
    }

    @GetMapping("/{id}")
    public Note findOne(@PathVariable Long id) {
        return noteRepository.findById(id)
                .orElseThrow(NoteNotFoundException::new);
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Note create(@RequestBody Note note) {
        return noteRepository.save(note);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        noteRepository.findById(id)
                .orElseThrow(NoteNotFoundException::new);
        noteRepository.deleteById(id);
    }

    @PutMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Note updateNote(@RequestBody Note note, @PathVariable Long id) {
        if (!note.getId().equals(id)) {
            throw new NoteIdMismatchException();
        }
        noteRepository.findById(id)
                .orElseThrow(NoteNotFoundException::new);
        return noteRepository.save(note);
    }
}

