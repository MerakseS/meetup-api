package by.losevsa.eventscrud.repository;

import java.util.List;

import by.losevsa.eventscrud.entity.Event;

/**
 * The interface for interaction with database.
 */
public interface EventRepository {

    /**
     * Save event to database.
     *
     * @param event the event to save
     * @return the event with updated id field
     */
    Event save(Event event);

    /**
     * Get all events from database.
     *
     * @return the {@link List} of events
     */
    List<Event> findAll();

    /**
     * Get Event from database by id or null, if event with that id doesn't exist.
     *
     * @param id the id of the Event
     * @return the {@link Event} or null, if event with that id doesn't exist.
     */
    Event findById(long id);

    /**
     * Update event in database.
     *
     * @param event the event to update
     */
    void merge(Event event);

    /**
     * Remove event from database.
     *
     * @param event the event to remove
     */
    void remove(Event event);

}
