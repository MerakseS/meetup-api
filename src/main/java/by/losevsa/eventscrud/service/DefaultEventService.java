package by.losevsa.eventscrud.service;

import java.util.List;
import static java.lang.String.format;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import by.losevsa.eventscrud.entity.Event;
import by.losevsa.eventscrud.exception.EventNotFoundException;
import by.losevsa.eventscrud.repository.EventRepository;

/**
 * The Default implementation of {@link EventService}.
 */
@Service
public class DefaultEventService implements EventService {

    private static final Logger LOG = LoggerFactory.getLogger(DefaultEventService.class);

    private final EventRepository eventRepository;

    /**
     * Instantiates a new Default event service.
     *
     * @param eventRepository the event repository
     */
    public DefaultEventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public void create(Event event) {
        event = eventRepository.save(event);
        LOG.info(format("Successfully created event with id %d", event.getId()));
    }

    @Override
    public List<Event> getAll() {
        LOG.info("Getting all events");
        return eventRepository.findAll();
    }

    @Override
    public Event get(long id) {
        Event event = eventRepository.findById(id);
        if (event == null) {
            LOG.warn(format("Can't get event with id %d", id));
            throw new EventNotFoundException(format("Event with id %d doesn't exist.", id));
        }

        LOG.info(format("Successfully got event with id %d", id));
        return event;
    }

    @Override
    public void update(long id, Event event) {
        if (eventRepository.findById(id) == null) {
            LOG.warn(format("Can't update event with id %d", id));
            throw new EventNotFoundException(format("Event with id %d doesn't exist.", id));
        }

        event.setId(id);
        eventRepository.merge(event);
        LOG.info(format("Successfully updated event with id %d", id));
    }

    @Override
    public void delete(long id) {
        Event event = eventRepository.findById(id);
        if (event == null) {
            LOG.warn(format("Can't delete event with id %d", id));
            throw new EventNotFoundException(format("Event with id %d doesn't exist.", id));
        }

        eventRepository.remove(event);
        LOG.info(format("Successfully deleted event with id %d", id));
    }
}
