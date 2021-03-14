package com.softwarecrafter.springbootsample.middleware.services;

import com.softwarecrafter.springbootsample.middleware.dto.NoteDTO;
import org.bson.types.ObjectId;

import java.util.List;

public interface NoteService {

    List<NoteDTO> findAllNotes();

    NoteDTO findById(ObjectId id);

    NoteDTO create(NoteDTO noteDTO);

    NoteDTO delete(ObjectId id);

    NoteDTO update(NoteDTO noteDTO);
}
