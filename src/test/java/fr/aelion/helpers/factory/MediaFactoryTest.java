package fr.aelion.helpers.factory;

import fr.aelion.models.course.Media;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MediaFactoryTest {
    private MediaFactory mediaFactory;
    @BeforeEach
    void setUp() {
        mediaFactory = new MediaFactory();
    }

    @Test
    @DisplayName("Should get a Media instance")
    void getMedia() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        //assertEquals(true, mediaFactory.getMedia("video") instanceof Media);
        assertTrue(mediaFactory.getMedia("VIDEO") instanceof Media);
        assertTrue(1 == 1);
    }

    @Test
    @DisplayName("Should raised an ClassNotFoundException")
    void noClassFound() {
        assertThrows(
                ClassNotFoundException.class,
                () -> mediaFactory.getMedia("pdf")
        );
    }

    @Test
    @DisplayName("Shoud raised an exception if a class is not a Media descendant")
    void notAMedia() {
        assertThrows(
                Exception.class,
                () -> mediaFactory.getMedia("author")
        );
    }
}