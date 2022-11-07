package by.losevsa.meetupapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import by.losevsa.meetupapi.dto.MeetupRequestDto;
import by.losevsa.meetupapi.dto.MeetupResponseDto;
import by.losevsa.meetupapi.entity.Meetup;
import by.losevsa.meetupapi.mapper.MeetupMapper;
import by.losevsa.meetupapi.service.MeetupService;

/**
 * Rest controller for the {@link Meetup} entity.
 */
@RestController
@RequestMapping("/meetups")
public class MeetupController {

    private final MeetupMapper meetupMapper;
    private final MeetupService meetupService;

    /**
     * Instantiates a new Meetup controller.
     *
     * @param meetupMapper model mapper for Meetup
     * @param meetupService the meetup service
     */
    @Autowired
    public MeetupController(MeetupMapper meetupMapper, MeetupService meetupService) {
        this.meetupMapper = meetupMapper;
        this.meetupService = meetupService;
    }

    /**
     * Endpoint to create new Meetup.
     *
     * @param meetupRequestDto the meetup request DTO with data to create meetup
     * @return ResponseEntity with Created HTTP status, if meetup was created successfully
     */
    @PostMapping
    public ResponseEntity<Object> create(@RequestBody MeetupRequestDto meetupRequestDto) {
        Meetup meetup = meetupMapper.mapRequestDtoToMeetup(meetupRequestDto);
        meetupService.create(meetup);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * Endpoint to get all meetups.
     *
     * @return the {@link List} of {@link Meetup}s
     */
    @GetMapping
    public ResponseEntity<List<MeetupResponseDto>> getAll() {
        List<Meetup> meetupList = meetupService.getAll();
        List<MeetupResponseDto> meetupResponseDtoList = meetupMapper.mapMeetupListToResponseDto(meetupList);
        return ResponseEntity.ok(meetupResponseDtoList);
    }

    /**
     * Endpoint to get {@link Meetup} by id.
     *
     * @param id the id of the Meetup
     * @return the meetup by id
     */
    @GetMapping("/{id}")
    public ResponseEntity<MeetupResponseDto> get(@PathVariable long id) {
        Meetup meetup = meetupService.get(id);
        MeetupResponseDto meetupResponseDto = meetupMapper.mapMeetupToResponseDto(meetup);
        return ResponseEntity.ok(meetupResponseDto);
    }

    /**
     * Endpoint to update meetup by id.
     *
     * @param id the id of the Meetup
     * @param meetupRequestDto the meetup request DTO with data to update meetup
     * @return ResponseEntity with Ok Http status if meetup was updated successfully
     */
    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable long id,
        @RequestBody MeetupRequestDto meetupRequestDto) {
        Meetup meetup = meetupMapper.mapRequestDtoToMeetup(meetupRequestDto);
        meetupService.update(id, meetup);
        return ResponseEntity.ok().build();
    }

    /**
     * Endpoint to delete meetup by id.
     *
     * @param id the id of the Meetup
     * @return ResponseEntity with Ok Http status if meetup was deleted successfully
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable long id) {
        meetupService.delete(id);
        return ResponseEntity.ok().build();
    }
}
