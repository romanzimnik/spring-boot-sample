package com.softwarecrafter.springbootsample.middleware.dto;

import com.softwarecrafter.springbootsample.persistence.model.Todo;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

public class TodoDTO {

    private String creator;

    private LocalDateTime creationTime;

    @Size(max = Todo.MAX_LENGTH_DESCRIPTION)
    private String description;

    private String id;

    private String modifier;

    private LocalDateTime modificationTime;

    @NotEmpty
    @Size(max = Todo.MAX_LENGTH_TITLE)
    private String title;

    public TodoDTO() {
    }

    public String getCreator() {
        return creator;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public String getDescription() {
        return description;
    }

    public String getId() {
        return id;
    }

    public String getModifier() {
        return modifier;
    }

    public LocalDateTime getModificationTime() {
        return modificationTime;
    }

    public String getTitle() {
        return title;
    }

    public void setCreatedByUser(String creator) {
        this.creator = creator;
    }

    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setModifiedByUser(String modifier) {
        this.modifier = modifier;
    }

    public void setModificationTime(LocalDateTime modificationTime) {
        this.modificationTime = modificationTime;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("creator", this.creator)
                .append("creationTime", this.creationTime)
                .append("description", this.description)
                .append("id", this.id)
                .append("modifier", this.modifier)
                .append("modificationTime", this.modificationTime)
                .append("title", this.title)
                .toString();
    }
}
