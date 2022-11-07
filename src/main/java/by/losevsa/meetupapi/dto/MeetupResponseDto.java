package by.losevsa.meetupapi.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * A DTO for the {@link by.losevsa.meetupapi.entity.Meetup} entity
 */
public class MeetupResponseDto implements Serializable {

    private long id;
    private String title;
    private String description;
    private String organizer;
    private LocalDateTime time;
    private String venue;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOrganizer() {
        return organizer;
    }

    public void setOrganizer(String organizer) {
        this.organizer = organizer;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MeetupResponseDto entity = (MeetupResponseDto) o;
        return Objects.equals(this.id, entity.id) &&
            Objects.equals(this.title, entity.title) &&
            Objects.equals(this.description, entity.description) &&
            Objects.equals(this.organizer, entity.organizer) &&
            Objects.equals(this.time, entity.time) &&
            Objects.equals(this.venue, entity.venue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, organizer, time, venue);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
            "id = " + id + ", " +
            "title = " + title + ", " +
            "description = " + description + ", " +
            "organizer = " + organizer + ", " +
            "time = " + time + ", " +
            "venue = " + venue + ")";
    }
}