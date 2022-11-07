package by.losevsa.meetupapi.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import by.losevsa.meetupapi.entity.Meetup;
import by.losevsa.meetupapi.exception.MeetupNotFoundException;
import by.losevsa.meetupapi.repository.MeetupRepository;

/**
 * The Default implementation of {@link MeetupService}.
 */
@Service
public class DefaultMeetupService implements MeetupService {

    private static final Logger LOG = LoggerFactory.getLogger(DefaultMeetupService.class);

    private final MeetupRepository meetupRepository;

    /**
     * Instantiates a new Default meetup service.
     *
     * @param meetupRepository the meetup repository
     */
    public DefaultMeetupService(MeetupRepository meetupRepository) {
        this.meetupRepository = meetupRepository;
    }

    @Override
    public void create(Meetup meetup) {
        meetup = meetupRepository.save(meetup);
        LOG.info("Successfully created meetup with id {}", meetup.getId());
    }

    @Override
    public List<Meetup> getAll() {
        LOG.info("Getting all meetups");
        return meetupRepository.findAll();
    }

    @Override
    public Meetup get(long id) {
        Meetup meetup = meetupRepository.findById(id);
        if (meetup == null) {
            LOG.warn("Can't get meetup with id {}", id);
            throw new MeetupNotFoundException(id);
        }

        LOG.info("Successfully got meetup with id {}", id);
        return meetup;
    }

    @Override
    public void update(long id, Meetup meetup) {
        if (meetupRepository.findById(id) == null) {
            LOG.warn("Can't update meetup with id {}", id);
            throw new MeetupNotFoundException(id);
        }

        meetup.setId(id);
        meetupRepository.merge(meetup);
        LOG.info("Successfully updated meetup with id {}", id);
    }

    @Override
    public void delete(long id) {
        Meetup meetup = meetupRepository.findById(id);
        if (meetup == null) {
            LOG.warn("Can't delete meetup with id {}", id);
            throw new MeetupNotFoundException(id);
        }

        meetupRepository.remove(meetup);
        LOG.info("Successfully deleted meetup with id {}", id);
    }
}
