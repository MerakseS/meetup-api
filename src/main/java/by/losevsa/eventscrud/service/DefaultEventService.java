package by.losevsa.eventscrud.service;

import java.util.List;
import static java.lang.String.format;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import by.losevsa.eventscrud.entity.Event;
import by.losevsa.eventscrud.repository.EventRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class DefaultEventService implements EventService {

    private static final Logger LOG = LoggerFactory.getLogger(DefaultEventService.class);

    private final EventRepository eventRepository;

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
            throw new EntityNotFoundException(format("Event with id %d doesn't exist.", id));
        }

        LOG.info(format("Successfully got event with id %d", id));
        return event;
    }
}
