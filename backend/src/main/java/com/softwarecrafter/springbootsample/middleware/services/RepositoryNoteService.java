package com.softwarecrafter.springbootsample.middleware.services;

import com.softwarecrafter.springbootsample.middleware.dto.NoteDTO;
import com.softwarecrafter.springbootsample.persistence.model.Note;
import com.softwarecrafter.springbootsample.persistence.model.NoteMapper;
import com.softwarecrafter.springbootsample.persistence.model.Todo;
import com.softwarecrafter.springbootsample.persistence.repository.NoteRepository;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RepositoryNoteService implements NoteService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RepositoryNoteService.class);

    private NoteRepository repository;

    @Autowired
    RepositoryNoteService(NoteRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<NoteDTO> findAllNotes() {

        List<Note> notes = repository.findAll();

        return NoteMapper.mapEntitiesIntoDtos(notes);
    }

    @Override
    public Optional<NoteDTO> findById(ObjectId id) {
        return null;
    }

    @Override
    public NoteDTO create(NoteDTO noteDTO) {
        return null;
    }

    @Override
    public NoteDTO delete(ObjectId id) {
        return null;
    }

    @Override
    public NoteDTO update(NoteDTO noteDTO) {
        return null;
    }
}
