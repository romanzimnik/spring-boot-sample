package com.softwarecrafter.springbootsample.common;

import com.softwarecrafter.springbootsample.persistence.model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public final class Utils {

    private static int COUNTER = 0;

    private Utils() {
    }

    public static Book createRandomBook(int counter) {
        final Book book = new Book();
//        int tmp = COUNTER++;
//        System.out.println(COUNTER);
        book.setId(counter);
        book.setTitle("Title" + counter);
        book.setAuthor("Author" + counter);
        return book;
    }

    public static List<Book> generateListOfBooks(int i) {
        List<Book> listOfBooks = new ArrayList<>();
        IntStream.range(0, i).forEach(e -> listOfBooks.add(createRandomBook(e)));
        return listOfBooks;
    }

    public static int getCounter() {
        return COUNTER;
    }
}
