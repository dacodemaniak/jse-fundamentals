package fr.aelion.repositories;

import fr.aelion.models.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository {
    public List<Student> students = new ArrayList<>();

    public StudentRepository() {
        this.populate();
    }

    private void populate() {
        // Make an instance of Student
        Student student = new Student("Aubert", "Jean-Luc", "jean-luc.aubert@aelion.fr");
        student.setUsername("jlaubert");
        student.setPassword("dacodemaniak");

        // Add student to list
        this.students.add(student);
    }
}
