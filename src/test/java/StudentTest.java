import fr.aelion.models.Student;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class StudentTest {
    Student student;

    @BeforeEach()
    void setUp() {
        student = new Student("Aubert", "Jean-Luc", "jean-luc.aubert@aelion.fr");
    }

    @Test
    @DisplayName("Standared properties should be 'Aubert', 'Jean-Luc', 'jean-luc.aubert@aelion.fr")
    void testStdProperties() {
        student.setPhoneNumber("06 55 21 54 87");
        assertAll("Aubert Jean-Luc jean-luc.aubert@aelion.fr",
                () -> assertEquals("Aubert", student.getLastName()),
                () -> assertEquals("Jean-Luc", student.getFirstName()),
                () -> assertEquals("jean-luc.aubert@aelion.fr", student.getEmail()),
                () -> assertEquals("06 55 21 54 87", student.getPhoneNumber())
        );
    }

    @Test
    @DisplayName("Student should have 'Casper' as lastName")
    void testPublicAttribute() {
        Student student = new Student("Tartempion", "Jules", "jt@test.com");
        student.setLastName("Casper");
        assertEquals("Casper", student.getLastName());
    }

}
