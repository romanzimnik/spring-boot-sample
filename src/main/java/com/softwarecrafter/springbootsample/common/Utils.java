package com.softwarecrafter.springbootsample.common;

import com.softwarecrafter.springbootsample.persistence.model.Note;

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
     * @param counter used to modify id, title and author attributes of a note entity.
     * @return one Note entity
     */
    public static Note createRandomNote(long counter) {
        final Note note = new Note();
        note.setId(counter);
        note.setTitle("Title" + counter);
        note.setAuthor("Author" + counter);
        return note;
    }

    /**
     *
     * @param amount of notes to create.
     * @return List of Notes.
     */
    public static List<Note> generateListOfNotes(int amount) {
        List<Note> listOfNotes = new ArrayList<>();
        IntStream.range(0, amount).forEach(e -> listOfNotes.add(createRandomNote(e)));
        return listOfNotes;
    }
}
