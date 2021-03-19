package com.softwarecrafter.springbootsample.persistence.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import static com.softwarecrafter.springbootsample.persistence.common.PreCondition.*;

/**
 * @author roman (rzett) from software-crafter.com
 */
@Document(collection = "Note")
public class Note {

    public static final int MAX_LENGTH_TITLE = 100;

    @Id
    private ObjectId id;

    @Field(value = "title")
    private String title;

    @Field(value = "Author")
    private String creator;

    @Field(value = "content")
    private String content;

    public Note() {
        super();
    }

    public Note(Builder builder) {
        super();
        this.title = builder.title;
        this.creator = builder.creator;
        this.content = builder.content;
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
        return new ToStringBuilder(this)
                .append("title", this.title)
                .append("author", this.creator)
                .append("content", this.content)
                .toString();
    }

    private void requireValidTitle(String title,
                                   String description,
                                   String content) {
        notNull(title, "Title cannot be null.");
        notEmpty(title, "Title cannot be empty.");
        isTrue(title.length() <= MAX_LENGTH_TITLE,
                "The maximum length of the title is <%d> characters.",
                MAX_LENGTH_TITLE
        );
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    public static class Builder {
        private String title;
        private String creator;
        private String content;

        private Builder() {}

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder creator(String creator) {
            this.creator = creator;
            return this;
        }

        public Builder content(String content) {
            this.content = content;
            return this;
        }

        public Note build() {
            Note build = new Note(this);

            build.requireValidTitle(
                    build.getTitle(),
                    build.getCreator(),
                    build.getContent());

            return build;
        }
    }

}
