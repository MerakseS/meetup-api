package by.losevsa.meetupapi.repository;

import java.util.List;

import by.losevsa.meetupapi.entity.Meetup;

/**
 * The interface for interaction with database.
 */
public interface MeetupRepository {

    /**
     * Save meetup to database.
     *
     * @param meetup the meetup to save
     * @return the meetup with updated id field
     */
    Meetup save(Meetup meetup);

    /**
     * Get all meetups from database.
     *
     * @return the {@link List} of meetups
     */
    List<Meetup> findAll();

    /**
     * Get Meetup from database by id or null, if meetup with that id doesn't exist.
     *
     * @param id the id of the Meetup
     * @return the {@link Meetup} or null, if meetup with that id doesn't exist.
     */
    Meetup findById(long id);

    /**
     * Update meetup in database.
     *
     * @param meetup the meetup to update
     */
    void merge(Meetup meetup);

    /**
     * Remove meetup from database.
     *
     * @param meetup the meetup to remove
     */
    void remove(Meetup meetup);

}
