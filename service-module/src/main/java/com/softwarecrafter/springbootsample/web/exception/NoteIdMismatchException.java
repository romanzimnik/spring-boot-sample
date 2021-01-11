package com.softwarecrafter.springbootsample.web.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class NoteIdMismatchException extends RuntimeException {

    public NoteIdMismatchException() {
        super();
    }

    public NoteIdMismatchException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public NoteIdMismatchException(final String message) {
        super(message);
    }

    public NoteIdMismatchException(final Throwable cause) {
        super(cause);
    }
}
