package fr.aelion.repositories;

import fr.aelion.helpers.builders.students.StudentBuilder;
import fr.aelion.helpers.exceptions.StudentException;
import fr.aelion.models.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository {
    private List<Student> students = new ArrayList<>();

    public StudentRepository() throws StudentException {
        this.populate();
    }

    public Student findByLoginAndPassword(String login, String password) {
        for (Student student : this.students) {
            if (student.getUsername() == login && student.getPassword() == password) {
                return student;
            }
        }
        return null;
    }

    public int size() {
        return this.students.size();
    }
    private void populate() throws StudentException {
        StudentBuilder builder = StudentBuilder.getInstance();
        builder
                .firstName("Jean-Luc")
                .lastName("Aubert")
                .email("jean-luc.aubert@aelion.fr")
                .password("truc")
                .username("truc");

        this.students.add((Student) builder.build());

        builder = StudentBuilder.getInstance();
        builder
                .firstName("Jean")
                .lastName("Talut")
                .email("jean.talut@voiture.com")
                .password("truc")
                .username("truc");


    }
}
