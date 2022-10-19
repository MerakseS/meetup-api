package by.losevsa.meetupapi.controller;

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

import by.losevsa.meetupapi.entity.Meetup;
import by.losevsa.meetupapi.service.MeetupService;

/**
 * Rest controller for the {@link Meetup} entity.
 */
@RestController
@RequestMapping("/meetups")
public class MeetupController {

    private final MeetupService meetupService;

    /**
     * Instantiates a new Meetup controller.
     *
     * @param meetupService the meetup service
     */
    public MeetupController(MeetupService meetupService) {
        this.meetupService = meetupService;
    }

    /**
     * Endpoint to create new Meetup.
     *
     * @param meetup the meetup to create
     * @return ResponseEntity with HttpStatus.CREATED if meetup was created successfully
     */
    @PostMapping
    public ResponseEntity<Object> create(@RequestBody Meetup meetup) {
        meetupService.create(meetup);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * Endpoint to get all meetups.
     *
     * @return the {@link List} of {@link Meetup}s
     */
    @GetMapping
    public List<Meetup> getAll() {
        return meetupService.getAll();
    }

    /**
     * Endpoint to get {@link Meetup} by id.
     *
     * @param id the id of the Meetup
     * @return the meetup by id
     */
    @GetMapping("/{id}")
    public Meetup get(@PathVariable long id) {
        return meetupService.get(id);
    }

    /**
     * Endpoint to update meetup by id.
     *
     * @param id the id of the Meetup
     * @param meetup new meetup to update
     * @return ResponseEntity with HttpStatus.OK if meetup was updated successfully
     */
    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable long id, @RequestBody Meetup meetup) {
        meetupService.update(id, meetup);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Endpoint to delete meetup by id.
     *
     * @param id the id of the Meetup
     * @return ResponseEntity with HttpStatus.OK if meetup was deleted successfully
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable long id) {
        meetupService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
