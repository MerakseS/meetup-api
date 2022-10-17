package by.losevsa.eventscrud.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import by.losevsa.eventscrud.entity.Event;
import by.losevsa.eventscrud.repository.EventRepository;

@Service
public class DefaultEventService implements EventService {

    private static final Logger LOG = LoggerFactory.getLogger(DefaultEventService.class);

    private final EventRepository eventRepository;

    public DefaultEventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public List<Event> getAll() {
        LOG.info("Getting all events.");
        return eventRepository.findAll();
    }
}
