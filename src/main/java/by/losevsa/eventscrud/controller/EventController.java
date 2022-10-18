package by.losevsa.eventscrud.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import by.losevsa.eventscrud.entity.Event;
import by.losevsa.eventscrud.service.EventService;

/**
 * Rest controller for the {@link Event} entity.
 */
@RestController
@RequestMapping("/events")
public class EventController {

    private final EventService eventService;

    /**
     * Instantiates a new Event controller.
     *
     * @param eventService the event service
     */
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    /**
     * Endpoint to create new Event.
     *
     * @param event the event
     * @return ResponseEntity with HttpStatus.CREATED if event was created successfully
     */
    @PostMapping
    public ResponseEntity<Object> create(@RequestBody Event event) {
        eventService.create(event);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * Endpoint to get all events.
     *
     * @return the {@link List} of {@link Event}s
     */
    @GetMapping
    public List<Event> getAll() {
        return eventService.getAll();
    }

    /**
     * Endpoint to get {@link Event} by id.
     *
     * @param id the id of the Event
     * @return the event by id
     */
    @GetMapping("/{id}")
    public Event get(@PathVariable long id) {
        return eventService.get(id);
    }

    /**
     * Endpoint to update event by id.
     *
     * @param id the id of the Event
     * @param event new event
     * @return ResponseEntity with HttpStatus.OK if event was updated successfully
     */
    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable long id, @RequestBody Event event) {
        eventService.update(id, event);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Endpoint to delete event by id.
     *
     * @param id the id of the Event
     * @return ResponseEntity with HttpStatus.OK if event was deleted successfully
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable long id) {
        eventService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
