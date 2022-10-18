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

@RestController
@RequestMapping("/events")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody Event event) {
        eventService.create(event);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public List<Event> getAll() {
        return eventService.getAll();
    }

    @GetMapping("/{id}")
    public Event get(@PathVariable long id) {
        return eventService.get(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable long id, @RequestBody Event event) {
        eventService.update(id, event);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable long id) {
        eventService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
