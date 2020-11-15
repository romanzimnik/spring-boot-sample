package com.softwarecrafter.springbootsample.common;

import com.softwarecrafter.springbootsample.persistence.model.Book;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

public final class Utils {

    private Utils() {
    }

    public static Book createRandomBook() {
        final Book book = new Book();
        book.setTitle(randomAlphabetic(10));
        book.setAuthor(randomAlphabetic(15));
        return book;
    }
}
