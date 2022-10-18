package by.losevsa.eventscrud.exception;

import by.losevsa.eventscrud.entity.Event;

/**
 * Thrown to indicate that {@link Event} not found.
 */
public class EventNotFoundException extends RuntimeException {

    /**
     * Instantiates a new Event not found exception.
     *
     * @param message the detail message. The detail message is saved for
     *          later retrieval by the {@link #getMessage()} method.
     */
    public EventNotFoundException(String message) {
        super(message);
    }
}
