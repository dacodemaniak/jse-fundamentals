package fr.aelion.helpers;

import fr.aelion.helpers.builders.students.StudentBuilder;
import fr.aelion.helpers.exceptions.StudentException;
import fr.aelion.models.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentBuilderTest {

    private StudentBuilder studentBuilder = StudentBuilder.getInstance();
    @BeforeEach
    void setUp() {
        studentBuilder
                .firstName("Jean-Luc")
                .lastName("Aubert")
                .email("jean-luc.aubert@aelion.fr")
                .phoneNumber("06 23 23 23 23")
                .username("jlaubert")
                .password("dacodemaniak");
    }

    @Test
    @DisplayName("Should get a Student instance")
    void build() throws StudentException {
        assertTrue(studentBuilder.build() instanceof Student);
    }

    @Test
    @DisplayName("Shoud throw an Exception")
    void noStudent() {
        StudentBuilder builder = StudentBuilder.getInstance();
        builder
                .firstName("Casper")
                .username("LeFantôme");
        assertThrows(StudentException.class, () -> builder.build());
    }

    @Test
    @DisplayName("Should throw an Exception with 'No name was provided'")
    void noNameException() {
        StudentBuilder builder = StudentBuilder.getInstance();
        builder
                .firstName("Casper")
                .username("LeFantôme")
                .password("whoooooo")
                .email("casper@lefantome.com");
        try {
            Student student = (Student) builder.build();
        } catch (StudentException e) {
            assertEquals("No Name was provided", e.getMessage());
        }
    }

}