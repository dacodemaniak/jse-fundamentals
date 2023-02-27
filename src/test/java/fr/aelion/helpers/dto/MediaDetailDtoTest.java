package fr.aelion.helpers.dto;

import fr.aelion.models.course.Author;
import fr.aelion.models.course.Video;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.*;

class MediaDetailDtoTest {
    private MediaDetailDto dto;
    private Video video;

    @BeforeEach
    void setUp() {
        dto = new MediaDetailDto();

        video = new Video();
        video.setTitle("Test video");
        video.setDuration(5.35F);
        video.setSummary("Résumé vidéo");
        video.setAuthor(new Author());
    }

    @Test
    void deserialize() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        DtoMapper mapper = new DtoMapper();
        dto = (MediaDetailDto) mapper.map(video, dto);
        assertAll(
                () -> assertEquals(video.getTitle(), dto.title),
                () -> assertEquals(video.getDuration(), dto.duration),
                () -> assertEquals(video.getSummary(), dto.summary),
                () -> assertEquals("V", dto.mediaType)
        );
    }
}