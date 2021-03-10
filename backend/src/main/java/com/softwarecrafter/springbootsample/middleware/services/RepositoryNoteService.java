package com.softwarecrafter.springbootsample.middleware.services;

import com.softwarecrafter.springbootsample.middleware.dto.NoteDTO;
import com.softwarecrafter.springbootsample.persistence.model.Note;
import com.softwarecrafter.springbootsample.persistence.model.NoteMapper;
import com.softwarecrafter.springbootsample.persistence.repository.NoteRepository;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RepositoryNoteService implements NoteService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RepositoryNoteService.class);

    private NoteRepository repository;

    @Autowired
    RepositoryNoteService(NoteRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<NoteDTO> findAllNotes() {

        List<Note> notes = repository.findAll();

        return NoteMapper.mapEntitiesIntoDtos(notes);
    }

    @Override
    public NoteDTO findById(ObjectId id) {

        Note note = repository.findById(id);

        return NoteMapper.mapEntityIntoDto(note);
    }

    @Override
    public NoteDTO create(NoteDTO dto) {

        Note note = repository.save(NoteMapper.mapDtoToEntity(dto));

        return NoteMapper.mapEntityIntoDto(note);
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
