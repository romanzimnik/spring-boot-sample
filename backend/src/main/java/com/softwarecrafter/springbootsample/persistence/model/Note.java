package com.softwarecrafter.springbootsample.persistence.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @author roman (rzett) from software-crafter.com
 */

@Document(collection = "Note")
public class Note {

    @Id
    private ObjectId id;

    @Field(value = "title")
    private String title;

    @Field(value = "Author")
    private String creator;

    public Note() {
        super();
    }

    public Note(String title, String creator) {
        super();
        this.title = title;
        this.creator = creator;
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((creator == null) ? 0 : creator.hashCode());
//        result = prime * result + (int) (id ^ (id >>> 32));
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Note other = (Note) obj;
        if (creator == null) {
            if (other.creator != null)
                return false;
        } else if (!creator.equals(other.creator))
            return false;
//        if (id != other.id)
//            return false;
        if (title == null) {
            return other.title == null;
        } else return title.equals(other.title);
    }

    @Override
    public String toString() {
        return "Note [title=" + title + ", author=" + creator + "]";
    }

}
