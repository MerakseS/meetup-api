package by.losevsa.eventscrud.service;

import java.util.List;

import by.losevsa.eventscrud.entity.Event;

public interface EventService {

    void create(Event event);

    List<Event> getAll();

}
