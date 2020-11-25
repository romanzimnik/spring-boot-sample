package com.softwarecrafter.springbootsample.common;

import com.softwarecrafter.springbootsample.persistence.model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Helper class to avoid boilerplate code.
 *
 * @author roman (rzett) from software-crafter.com
 */
public final class Utils {

    private static int COUNTER = 0;

    private Utils() {
    }

    /**
     *
     * @param counter used to modify id, title and author attributes of a book entity.
     * @return one Book entity
     */
    public static Book createRandomBook(long counter) {
        final Book book = new Book();
        book.setId(counter);
        book.setTitle("Title" + counter);
        book.setAuthor("Author" + counter);
        return book;
    }

    /**
     *
     * @param amount of books to create.
     * @return List of Books.
     */
    public static List<Book> generateListOfBooks(int amount) {
        List<Book> listOfBooks = new ArrayList<>();
        IntStream.range(0, amount).forEach(e -> listOfBooks.add(createRandomBook(e)));
        return listOfBooks;
    }
}
