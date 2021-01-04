package com.softwarecrafter.springbootsample.common;

import com.softwarecrafter.springbootsample.middleware.dto.TodoDTO;
import com.softwarecrafter.springbootsample.persistence.model.Note;
import com.softwarecrafter.springbootsample.persistence.model.Todo;
import com.softwarecrafter.springbootsample.persistence.model.TodoMapper;

import java.time.ZonedDateTime;
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

    public static TodoDTO createRandomTodo(long counter) {
        final Todo todo = Todo.getBuilder()
                .description("Description" + counter)
                .title("Title" + counter)
                .creationTime(ZonedDateTime.now())
                .creator("Creator" + counter)
                .modifier("Modifier" + counter)
                .modificationTime(ZonedDateTime.now())
                .build();
        return TodoMapper.mapEntityIntoDto(todo);
    }

    public static List<TodoDTO> generateListOfTodos(int amount) {
        List<TodoDTO> listOfTodos = new ArrayList<>();
        IntStream.range(0, amount).forEach(e -> listOfTodos.add(createRandomTodo(e)));
        return listOfTodos;
    }
}
