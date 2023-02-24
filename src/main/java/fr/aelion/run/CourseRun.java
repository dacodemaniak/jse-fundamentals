package fr.aelion.run;

import fr.aelion.helpers.builders.medias.MediaBuilder;
import fr.aelion.helpers.builders.medias.VideoBuilder;
import fr.aelion.helpers.exceptions.NoMediaTypeException;
import fr.aelion.helpers.exceptions.NotEnoughArgsException;
import fr.aelion.models.course.*;
import fr.aelion.repositories.course.Course;
import fr.aelion.services.courses.DisplayCourse;

public class CourseRun {
    private Course course = new Course();

    public CourseRun(){
        this.course.setTitle("SQL");
        this.makeCourse();
    }

    public void run() {
        DisplayCourse displayCourse = new DisplayCourse();
        displayCourse.setCourse(this.course);
        System.out.println(displayCourse.displayBuilder());
    }
    private void makeCourse() {

        MediaBuilder videoBuilder = new VideoBuilder();
        videoBuilder.setMediaType("video");
        videoBuilder
                .title("Create Table")
                .summary("Créer une table")
                .duration(5.35F)
                .author(new Author());

        MediaBuilder slideBuilder = new VideoBuilder();
        slideBuilder.setMediaType("slide");
        slideBuilder
                .title("Alter table")
                .summary("Modifier une table")
                .duration(3.30F)
                .author(new Author());

        MediaBuilder docBuilder = new VideoBuilder();
        docBuilder.setMediaType("document");
        docBuilder
                .title("Drop table")
                .summary("Supprimer une table")
                .duration(1.10F)
                .author(new Author());

        MediaBuilder badBuilder = new VideoBuilder();
        badBuilder
                .title("Not in the list")
                .duration(0.10F);

        try {
            this.course.addMedia(videoBuilder.build());
        } catch (NoMediaTypeException e) {
            System.out.println(e.getMessage());
        } catch (NotEnoughArgsException e) {
            System.out.println(e.getMessage());
        }

        try {
            this.course.addMedia(slideBuilder.build());
        } catch (NoMediaTypeException e) {
            System.out.println(e.getMessage());
        } catch (NotEnoughArgsException e) {
            System.out.println(e.getMessage());
        }

        try {
            this.course.addMedia(docBuilder.build());
        } catch (NoMediaTypeException e) {
            System.out.println(e.getMessage());
        } catch (NotEnoughArgsException e) {
            System.out.println(e.getMessage());
        }

        try {
            this.course.addMedia(badBuilder.build());
        } catch (NoMediaTypeException e) {
            System.out.println(e.getMessage());
            badBuilder.setMediaType("video");
        } catch (NotEnoughArgsException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                this.course.addMedia(badBuilder.build());
            } catch (Exception e) {
                System.out.println("So bad... One more error");
            }
        }
    }
}
