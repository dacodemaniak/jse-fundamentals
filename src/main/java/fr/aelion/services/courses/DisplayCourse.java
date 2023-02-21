package fr.aelion.services.courses;

import fr.aelion.repositories.course.Course;

public class DisplayCourse {
    private Course course;

    public void setCourse(Course course) {
        this.course = course;
    }

    public String displayBuilder() {
        final String[] output = new String[1];

        output[0] = "Course : " + course.getTitle() + "\n";
        // Next display the list of title of specific Medias
        course.getMedias().forEach(media -> {
            output[0] += media.getTitle() + "\n";
        });
        return output[0];
    }
}
