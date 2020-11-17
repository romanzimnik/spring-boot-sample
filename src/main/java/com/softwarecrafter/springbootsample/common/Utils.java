package com.softwarecrafter.springbootsample.common;

import com.softwarecrafter.springbootsample.persistence.model.Book;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

public final class Utils {

    private static int COUNTER = 0;
    private List<Book> listOfBooks;

    private Utils() {
    }

    public static Book createRandomBook() {
        final Book book = new Book();
        int tmp = COUNTER++;
        book.setTitle("Title" + tmp);
        book.setAuthor("Author" + tmp);
        return book;
    }

    public static Book createRandomBook(int i) {
        final Book book = new Book();
        int tmp = COUNTER + i++;
        book.setTitle("Title" + tmp);
        book.setAuthor("Author" + tmp);
        return book;
    }

    public static int getCOUNTER() {
        return COUNTER;
    }

    private static List<Book> generateListOfBooks(int i) {
        List<Book> listOfBooks = new ArrayList<>();
        IntStream.range(0, i).forEach(e -> listOfBooks.add(createRandomBook()));
        return listOfBooks;
    }
}
