package fr.aelion.run;

import fr.aelion.models.course.*;

import java.time.LocalDateTime;

public class CourseRun {
    private Course course = new Course();

    private Media video = new Video();
    private Media slide = new Slide();
    private Media document = new Document();

    public void run() {
        video.setAuthor(new Author());
        video.setTitle("Create Table");
        video.setDuration(LocalDateTime.now());
        video.setSummary("Learn how to create table");

        slide.setAuthor(new Author());
        slide.setTitle("Alter table");
        slide.setSummary("Learn how to alter a table");
        slide.setDuration(LocalDateTime.now());

        document.setTitle("Drop table");
        document.setSummary("Learn how to drop a table");
        document.setAuthor(new Author());
        document.setDuration(LocalDateTime.now());

        // Push Media to Course
        course.setTitle("SQL");
        course.addMedia(video);
        course.addMedia(slide);
        course.addMedia(document);

        // Display course
        course.display();
    }
}
