package com.softwarecrafter.springbootsample.persistence.model;

import com.softwarecrafter.springbootsample.middleware.dto.NoteDTO;

import java.util.ArrayList;
import java.util.List;

public class NoteMapper {

    public static NoteDTO mapEntityIntoDto(Note entity) {
        NoteDTO dto = new NoteDTO();

        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setContent(entity.getContent());
        dto.setCreator(entity.getCreator());

        return dto;
    }

    public static Note mapDtoToEntity(NoteDTO dto) {
        return Note.getBuilder()
                .title(dto.getTitle())
                .creator(dto.getCreator())
                .content(dto.getContent())
                .build();
    }

    public static List<NoteDTO> mapEntitiesIntoDtos(List<Note> entities) {
        List<NoteDTO> dtos = new ArrayList<>();

        entities.forEach(e -> dtos.add(mapEntityIntoDto(e)));

        return dtos;
    }
}
