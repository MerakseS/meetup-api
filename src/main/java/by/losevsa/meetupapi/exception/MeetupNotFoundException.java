package by.losevsa.meetupapi.exception;

import by.losevsa.meetupapi.entity.Meetup;

/**
 * Thrown to indicate that {@link Meetup} not found.
 */
public class MeetupNotFoundException extends RuntimeException {

    /**
     * Instantiates a new Meetup not found exception.
     *
     * @param message the detail message. The detail message is saved for
     *          later retrieval by the {@link #getMessage()} method.
     */
    public MeetupNotFoundException(String message) {
        super(message);
    }
}
