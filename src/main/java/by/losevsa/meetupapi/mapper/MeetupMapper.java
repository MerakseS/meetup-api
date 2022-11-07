package by.losevsa.meetupapi.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import by.losevsa.meetupapi.dto.MeetupRequestDto;
import by.losevsa.meetupapi.dto.MeetupResponseDto;
import by.losevsa.meetupapi.entity.Meetup;

/**
 * The Mapper class for {@link Meetup} using {@link ModelMapper}.
 */
@Component
public class MeetupMapper {

    private final ModelMapper modelMapper;

    /**
     * Instantiates a new Meetup mapper.
     *
     * @param modelMapper the model mapper
     */
    public MeetupMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    /**
     * Map request dto to meetup meetup.
     *
     * @param meetupRequestDto the meetup request dto to map
     * @return the meetup
     */
    public Meetup mapRequestDtoToMeetup(MeetupRequestDto meetupRequestDto) {
        return modelMapper.map(meetupRequestDto, Meetup.class);
    }

    /**
     * Map meetup to response dto meetup response dto.
     *
     * @param meetup the meetup to map
     * @return the meetup response dto
     */
    public MeetupResponseDto mapMeetupToResponseDto(Meetup meetup) {
        return modelMapper.map(meetup, MeetupResponseDto.class);
    }

    /**
     * Map meetup list to response dto list.
     *
     * @param meetupList the meetup list
     * @return the list
     */
    public List<MeetupResponseDto> mapMeetupListToResponseDto(List<Meetup> meetupList) {
        return meetupList.stream()
            .map(this::mapMeetupToResponseDto)
            .collect(Collectors.toList());
    }

}
