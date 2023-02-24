package fr.aelion.helpers.strategies.student;

import fr.aelion.models.Student;

public class LastNameFirstNameStrategy implements IHelloStrategy {
    @Override
    public String greetings(Student student) {
        return student.getLastName() + " " + student.getFirstName();
    }
}
