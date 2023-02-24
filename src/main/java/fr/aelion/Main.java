package fr.aelion;

import fr.aelion.run.CourseRun;
import fr.aelion.run.MediaRun;
import fr.aelion.run.StudentRun;
import fr.aelion.services.courses.DisplayCourse;

public class Main {

    public static void main(String[] args) {
        StudentRun studentRun = new StudentRun();
        studentRun.run();
    }

}