package com.softwarecrafter.springbootsample.middleware.dto;

import com.google.gson.annotations.SerializedName;
import com.softwarecrafter.springbootsample.persistence.model.Todo;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.bson.types.ObjectId;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

public class TodoDTO {

    @SerializedName("_id")
    private ObjectId id;

    @SerializedName("creator")
    private String creator;

    @SerializedName("creationTime")
    private LocalDateTime creationTime;

    @SerializedName("description")
    @Size(max = Todo.MAX_LENGTH_DESCRIPTION)
    private String description;

    @SerializedName("modifier")
    private String modifier;

    @SerializedName("modificationTime")
    private LocalDateTime modificationTime;

    @NotEmpty
    @Size(max = Todo.MAX_LENGTH_TITLE)
    @SerializedName("title")
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

    public ObjectId getId() {
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

    public void setId(ObjectId id) {
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
                .append("id", this.id)
                .append("title", this.title)
                .append("description", this.description)
                .append("creator", this.creator)
                .append("creationTime", this.creationTime)
                .append("modifier", this.modifier)
                .append("modificationTime", this.modificationTime)
                .toString();
    }
}
