package by.losevsa.eventscrud.service;

import java.util.List;

import by.losevsa.eventscrud.entity.Event;

public interface EventService {

    void create(Event event);

    List<Event> getAll();

    Event get(long id);

    void update(long id, Event event);

    void delete(long id);

}
