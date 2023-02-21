package fr.aelion.services.courses;

import fr.aelion.repositories.course.Course;

public class DisplayCourse {
    private Course course;

    public void setCourse(Course course) {
        this.course = course;
    }

    public void display() {
        System.out.println("Course : " + course.getTitle());
        // Next display the list of title of specific Medias
        course.getMedias().forEach(media -> {
            System.out.println(media.getTitle());
        });
    }
}
