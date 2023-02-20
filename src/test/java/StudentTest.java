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
        assertAll("Aubert Jean-Luc jean-luc.aubert@aelion.fr",
                () -> assertEquals("Aubert", student.lastName),
                () -> assertEquals("Jean-Luc", student.firstName),
                () -> assertEquals("jean-luc.aubert@aelion.fr", student.getEmail())
        );
    }

    @Test
    @DisplayName("Student should have 'Casper' as lastName")
    void testPublicAttribute() {
        Student student = new Student("Tartempion", "Jules", "jt@test.com");
        student.lastName = "Casper";
        assertEquals("Casper", student.lastName);
    }

    @Test
    @DisplayName("Student should not have 'anonymous' as email")
    void testEmail() {
        Student student = new Student("Tartempion", "Jules", "jt@test.com");
        assertEquals(false, student.setEmail("anonymous"));
    }

}
