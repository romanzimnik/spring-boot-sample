package com.softwarecrafter.springbootsample.middleware.services;

import com.softwarecrafter.springbootsample.middleware.dto.NoteDTO;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepositoryNoteService implements NoteService {
    @Override
    public List<NoteDTO> findAllNotes() {
        return null;
    }

    @Override
    public NoteDTO findById(ObjectId id) {
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
