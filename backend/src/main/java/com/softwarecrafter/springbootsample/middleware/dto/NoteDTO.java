package com.softwarecrafter.springbootsample.middleware.dto;

import com.google.gson.annotations.SerializedName;
import com.softwarecrafter.springbootsample.persistence.model.Note;
import com.softwarecrafter.springbootsample.persistence.model.Todo;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.bson.types.ObjectId;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

public class NoteDTO {

    @SerializedName("_id")
    private ObjectId id;

    @SerializedName("title")
    @Size(max = Note.MAX_LENGTH_TITLE)
    private String title;

    @SerializedName("creator")
    private String creator;

    @SerializedName("content")
    private String content;

    public NoteDTO() {
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", this.id)
                .append("creator", this.creator)
                .append("content", this.content)
                .append("title", this.title)
                .toString();
    }
}
