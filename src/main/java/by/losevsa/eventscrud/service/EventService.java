package by.losevsa.eventscrud.service;

import java.util.List;

import by.losevsa.eventscrud.entity.Event;
import by.losevsa.eventscrud.exception.EventNotFoundException;

/**
 * The business logic interface for {@link Event}.
 */
public interface EventService {

    /**
     * Create event.
     *
     * @param event the event to create
     */
    void create(Event event);

    /**
     * Gets all events.
     *
     * @return the {@link List} of events
     */
    List<Event> getAll();

    /**
     * Get event by id.
     *
     * @param id the id of the event
     * @return the event by id
     * @throws EventNotFoundException if Event with that id doesn't exist
     */
    Event get(long id);

    /**
     * Update event by id.
     *
     * @param id the id of the event
     * @param event the updated event
     * @throws EventNotFoundException if Event with that id doesn't exist
     */
    void update(long id, Event event);

    /**
     * Delete event by id.
     *
     * @param id the id of the event
     * @throws EventNotFoundException if Event with that id doesn't exist
     */
    void delete(long id);

}
