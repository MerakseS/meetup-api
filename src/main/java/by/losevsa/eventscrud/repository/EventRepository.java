package by.losevsa.eventscrud.repository;

import java.util.List;

import by.losevsa.eventscrud.entity.Event;

public interface EventRepository {

    Event save(Event event);

    List<Event> findAll();

    Event findById(long id);

    Event findReferenceById(long id);

    void merge(Event event);

}
