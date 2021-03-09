package com.softwarecrafter.springbootsample.persistence.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

import static com.softwarecrafter.springbootsample.persistence.common.PreCondition.*;

@Document(collection = "Todo")
public class Todo {

    public static final int MAX_LENGTH_DESCRIPTION = 500;
    public static final int MAX_LENGTH_TITLE = 100;

    @Id
    private ObjectId id;

//    @Column(name = "created_by_user", nullable = false)
//    @CreatedBy
    @Field(value = "creator")
    private String creator;

//    @Column(name = "creation_time", nullable = false)
//    @Type(type = "org.jadira.usertype.dateandtime.threeten.PersistentZonedDateTime")
//    @CreatedDate
    @Field(value = "creationTime")
    private LocalDateTime creationTime;

//    @Column(name = "description", length = MAX_LENGTH_DESCRIPTION)
    @Field(value = "description")
    private String description;

//    @Column(name = "modified_by_user", nullable = false)
//    @LastModifiedBy
    @Field(value = "modifier")
    private String modifier;

//    @Column(name = "modification_time")
//    @Type(type = "org.jadira.usertype.dateandtime.threeten.PersistentZonedDateTime")
//    @LastModifiedDate
    @Field(value = "modificationTime")
    private LocalDateTime modificationTime;

//    @Column(name = "title", nullable = false, length = MAX_LENGTH_TITLE)
    @Field(value = "title")
    private String title;

    /**
     * Required by Hibernate.
     */
    private Todo() {
        super();
    }

    private Todo(Builder builder) {
        super();
        this.title = builder.title;
        this.description = builder.description;
        this.creator = builder.creator;
        this.modifier = builder.modifier;
        this.creationTime = builder.creationTime;
        this.modificationTime = builder.modificationTime;
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    String getCreator() {
        return creator;
    }

    LocalDateTime getCreationTime() {
        return creationTime;
    }

    String getDescription() {
        return description;
    }

    String getModifier() {
        return modifier;
    }

    LocalDateTime getModificationTime() {
        return modificationTime;
    }

    String getTitle() {
        return title;
    }

    private void requireValidTitleAndDescription(String title,
                                                 String description,
                                                 String creator,
                                                 String modifier,
                                                 LocalDateTime creationTime,
                                                 LocalDateTime modificationTime) {
        notNull(title, "Title cannot be null.");
        notEmpty(title, "Title cannot be empty.");
        isTrue(title.length() <= MAX_LENGTH_TITLE,
                "The maximum length of the title is <%d> characters.",
                MAX_LENGTH_TITLE
        );

        isTrue((description == null) || (description.length() <= MAX_LENGTH_DESCRIPTION),
                "The maximum length of the description is <%d> characters.",
                MAX_LENGTH_DESCRIPTION
        );
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

    /**
     * This entity is so simple that you don't really need to use the builder pattern
     * (use a constructor instead). I use the builder pattern here because it makes
     * the code a bit more easier to read.
     */
    public static class Builder {
        private String description;
        private String title;
        private LocalDateTime creationTime;
        // TODO change creator type to Person/User
        private String creator;
        // TODO change modifier type to Person/User
        private String modifier;
        private LocalDateTime modificationTime;

        private Builder() {}

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder creationTime(LocalDateTime creationTime) {
            this.creationTime = creationTime;
            return this;
        }

        public Builder creator(String creator) {
            this.creator = creator;
            return this;
        }

        public Builder modifier(String modifier) {
            this.modifier = modifier;
            return this;
        }

        public Builder modificationTime(LocalDateTime modificationTime) {
            this.modificationTime = modificationTime;
            return this;
        }

        public Todo build() {
            Todo build = new Todo(this);

            build.requireValidTitleAndDescription(
                    build.getTitle(),
                    build.getDescription(),
                    build.getCreator(),
                    build.getModifier(),
                    build.getCreationTime(),
                    build.getModificationTime());

            return build;
        }
    }
}
