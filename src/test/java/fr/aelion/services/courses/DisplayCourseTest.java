package fr.aelion.services.courses;

import fr.aelion.models.course.Media;
import fr.aelion.models.course.Video;
import fr.aelion.repositories.course.Course;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DisplayCourseTest {

    private DisplayCourse displayCourse;
    private StringBuilder expected = new StringBuilder();
    @BeforeEach
    void setUp() {
        Course course = new Course();

        Media video = new Video();
        video.setTitle("Vidéo test");

        course.setTitle("Test");
        course.addMedia(video);

        // What i expect as output from displayCourse
        expected
                .append("Course : Test")
                .append("\n")
                .append("Vidéo test")
                .append("\n");

        displayCourse = new DisplayCourse();
        displayCourse.setCourse(course);

    }

    @Test
    @DisplayName("Should display the whole course")
    void displayBuilder() {
        assertEquals(expected.toString(), displayCourse.displayBuilder());
    }
}