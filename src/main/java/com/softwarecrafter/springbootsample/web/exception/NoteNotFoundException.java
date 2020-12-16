package com.softwarecrafter.springbootsample.web.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class NoteNotFoundException extends RuntimeException {

    public NoteNotFoundException() {
        super();
    }

    public NoteNotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public NoteNotFoundException(final String message) {
        super(message);
    }

    public NoteNotFoundException(final Throwable cause) {
        super(cause);
    }
}

