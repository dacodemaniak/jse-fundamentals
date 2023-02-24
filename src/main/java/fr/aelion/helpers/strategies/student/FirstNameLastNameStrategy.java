package fr.aelion.helpers.strategies.student;

import fr.aelion.models.Student;

public class FirstNameLastNameStrategy implements IHelloStrategy {
    @Override
    public String greetings(Student student) {
        return student.getFirstName() + " " + student.getLastName();
    }
}
