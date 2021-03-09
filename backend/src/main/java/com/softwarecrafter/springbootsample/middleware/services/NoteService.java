package com.softwarecrafter.springbootsample.middleware.services;

import com.softwarecrafter.springbootsample.middleware.dto.NoteDTO;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Optional;

public interface NoteService {

    List<NoteDTO> findAllNotes();

    Optional<NoteDTO> findById(ObjectId id);

    NoteDTO create(NoteDTO noteDTO);

    NoteDTO delete(ObjectId id);

    NoteDTO update(NoteDTO noteDTO);
}
