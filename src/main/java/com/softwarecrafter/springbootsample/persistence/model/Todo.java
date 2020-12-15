package com.softwarecrafter.springbootsample.persistence.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.ZonedDateTime;

import static com.softwarecrafter.springbootsample.persistence.common.PreCondition.*;

@Document(collection = "Todo")
public class Todo {

    public static final int MAX_LENGTH_DESCRIPTION = 500;
    public static final int MAX_LENGTH_TITLE = 100;

    @Id
    private Long id;

//    @Column(name = "created_by_user", nullable = false)
//    @CreatedBy
    private String createdByUser;

//    @Column(name = "creation_time", nullable = false)
//    @Type(type = "org.jadira.usertype.dateandtime.threeten.PersistentZonedDateTime")
//    @CreatedDate
    private ZonedDateTime creationTime;

//    @Column(name = "description", length = MAX_LENGTH_DESCRIPTION)
    private String description;

//    @Column(name = "modified_by_user", nullable = false)
//    @LastModifiedBy
    private String modifiedByUser;

//    @Column(name = "modification_time")
//    @Type(type = "org.jadira.usertype.dateandtime.threeten.PersistentZonedDateTime")
//    @LastModifiedDate
    private ZonedDateTime modificationTime;

//    @Column(name = "title", nullable = false, length = MAX_LENGTH_TITLE)
    private String title;

//    @Version
    private long version;

    /**
     * Required by Hibernate.
     */
    private Todo() {}

    private Todo(Builder builder) {
        this.title = builder.title;
        this.description = builder.description;
    }

    static Builder getBuilder() {
        return new Builder();
    }

    Long getId() {
        return id;
    }

    String getCreatedByUser() {
        return createdByUser;
    }

    ZonedDateTime getCreationTime() {
        return creationTime;
    }

    String getDescription() {
        return description;
    }

    String getModifiedByUser() {
        return modifiedByUser;
    }

    ZonedDateTime getModificationTime() {
        return modificationTime;
    }

    String getTitle() {
        return title;
    }

    long getVersion() {
        return version;
    }

    void update(String newTitle, String newDescription) {
        requireValidTitleAndDescription(newTitle, newDescription);

        this.title = newTitle;
        this.description = newDescription;
    }

    private void requireValidTitleAndDescription(String title, String description) {
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
                .append("createdByUser", this.createdByUser)
                .append("creationTime", this.creationTime)
                .append("description", this.description)
                .append("id", this.id)
                .append("modifiedByUser", this.modifiedByUser)
                .append("modificationTime", this.modificationTime)
                .append("title", this.title)
                .append("version", this.version)
                .toString();
    }

    /**
     * This entity is so simple that you don't really need to use the builder pattern
     * (use a constructor instead). I use the builder pattern here because it makes
     * the code a bit more easier to read.
     */
    static class Builder {
        private String description;
        private String title;

        private Builder() {}

        Builder description(String description) {
            this.description = description;
            return this;
        }

        Builder title(String title) {
            this.title = title;
            return this;
        }

        Todo build() {
            Todo build = new Todo(this);

            build.requireValidTitleAndDescription(build.getTitle(), build.getDescription());

            return build;
        }
    }
}
