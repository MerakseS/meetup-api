package by.losevsa.meetupapi.exception;

import static java.lang.String.format;

import by.losevsa.meetupapi.entity.Meetup;

/**
 * Thrown to indicate that {@link Meetup} not found.
 */
public class MeetupNotFoundException extends RuntimeException {

    /**
     * Instantiates a new Meetup not found exception.
     *
     * @param id id of meetup that not found, used for message. The detail message is saved for
     *          later retrieval by the {@link #getMessage()} method.
     */
    public MeetupNotFoundException(long id) {
        super(format("Meetup with id %d doesn't exist.", id));
    }
}
