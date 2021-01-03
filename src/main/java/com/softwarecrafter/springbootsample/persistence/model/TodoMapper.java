package com.softwarecrafter.springbootsample.persistence.model;

import com.softwarecrafter.springbootsample.middleware.dto.TodoDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

public class TodoMapper {

    public static List<TodoDTO> mapEntitiesIntoDTOs(List<Todo> entities) {
        List<TodoDTO> dtos = new ArrayList<>();

        entities.forEach(e -> dtos.add(mapEntityIntoDTO(e)));

        return dtos;
    }

    static TodoDTO mapEntityIntoDTO(Todo entity) {
        TodoDTO dto = new TodoDTO();

        dto.setCreatedByUser(entity.getCreatedByUser());
        dto.setCreationTime(entity.getCreationTime());
        dto.setDescription(entity.getDescription());
        dto.setId(entity.getId());
        dto.setModifiedByUser(entity.getModifiedByUser());
        dto.setModificationTime(entity.getModificationTime());
        dto.setTitle(entity.getTitle());

        return dto;
    }

    static Page<TodoDTO> mapEntityPageIntoDTOPage(Pageable pageRequest, Page<Todo> source) {
        List<TodoDTO> dtos = mapEntitiesIntoDTOs(source.getContent());
        return new PageImpl<>(dtos, pageRequest, source.getTotalElements());
    }

}
