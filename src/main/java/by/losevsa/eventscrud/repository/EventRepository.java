package by.losevsa.eventscrud.repository;

import java.util.List;

import by.losevsa.eventscrud.entity.Event;

public interface EventRepository {

    List<Event> findAll();
}
