package fr.aelion.helpers.dto;

import fr.aelion.models.course.Media;
import fr.aelion.models.course.Video;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

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
    void map() {
        String[] fields = {"title", "duration"};
        assertArrayEquals(fields, mapper.map(video, dto));
    }
}