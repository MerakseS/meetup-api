package by.losevsa.meetupapi.service;

import java.util.List;

import by.losevsa.meetupapi.entity.Meetup;
import by.losevsa.meetupapi.exception.MeetupNotFoundException;

/**
 * The business logic interface for {@link Meetup}.
 */
public interface MeetupService {

    /**
     * Create meetup.
     *
     * @param meetup the meetup to create
     */
    void create(Meetup meetup);

    /**
     * Gets all meetups.
     *
     * @return the {@link List} of meetups
     */
    List<Meetup> getAll();

    /**
     * Get meetup by id.
     *
     * @param id the id of the meetup
     * @return the meetup by id
     * @throws MeetupNotFoundException if Meetup with that id doesn't exist
     */
    Meetup get(long id);

    /**
     * Update meetup by id.
     *
     * @param id the id of the meetup
     * @param meetup the updated meetup
     * @throws MeetupNotFoundException if Meetup with that id doesn't exist
     */
    void update(long id, Meetup meetup);

    /**
     * Delete meetup by id.
     *
     * @param id the id of the meetup
     * @throws MeetupNotFoundException if Meetup with that id doesn't exist
     */
    void delete(long id);

}
