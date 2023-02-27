package fr.aelion.helpers.dto;

import fr.aelion.models.course.Media;
import fr.aelion.models.course.Video;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.*;

class DtoMapperTest {

    private DtoMapper mapper;
    private Media video = new Video();
    private MediaListDto dto = new MediaListDto();
    @BeforeEach
    void setUp() {
        mapper = new DtoMapper();

    }

    @Test
    void map() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        MediaListDto mappedDto = (MediaListDto) mapper.map(video, dto);
        assertAll(
                () -> assertEquals(video.getTitle(), mappedDto.title),
                () -> assertEquals(video.getDuration(), mappedDto.duration),
                () -> assertEquals(video.getSummary(), mappedDto.summary)
        );
    }
}