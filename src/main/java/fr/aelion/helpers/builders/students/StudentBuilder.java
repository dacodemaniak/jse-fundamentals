package fr.aelion.helpers.builders.students;

import fr.aelion.helpers.exceptions.StudentException;
import fr.aelion.helpers.interfaces.Builder;
import fr.aelion.models.Student;

public class StudentBuilder implements Builder<Student> {
    private static StudentBuilder instance;
    private String lastName;
    private String firstName;
    private String phoneNumber;
    private String email;

    private String username;
    private String password;

    private StudentBuilder() {}

    public static StudentBuilder getInstance() {
        if (StudentBuilder.instance == null) {
            StudentBuilder.instance = new StudentBuilder();
        } else {
            StudentBuilder.instance
                    .email(null)
                    .password(null)
                    .username(null)
                    .lastName(null)
                    .firstName(null)
                    .phoneNumber(null);
        }
        return StudentBuilder.instance;
    }
    public StudentBuilder lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public StudentBuilder firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public StudentBuilder phoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public StudentBuilder email(String email) {
        this.email = email;
        return this;
    }

    public StudentBuilder username(String username) {
        this.username = username;
        return this;
    }

    public StudentBuilder password(String password) {
        this.password = password;
        return this;
    }
    @Override
    public Object build() throws StudentException {
        if (this.lastName == null) {
            throw StudentException.noNameException();
        }

        if (this.email == null) {
            throw StudentException.noMailException();
        }

        if (this.username == null) {
            throw StudentException.noUsernameException();
        }

        if (this.password == null) {
            throw StudentException.noPasswordException();
        }

        // Make the Student
        Student student = new Student();
        student.setLastName(this.lastName);
        student.setFirstName(this.firstName);
        student.setEmail(this.email);
        student.setLogin(this.username);
        student.setPassword(this.password);
        student.setPhoneNumber(this.phoneNumber);

        return student;
    }

}
