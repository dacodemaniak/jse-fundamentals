import fr.aelion.helpers.exceptions.StudentException;
import fr.aelion.models.Student;
import fr.aelion.repositories.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class StudentRepositoryTest {
    StudentRepository studentRepository;
    @BeforeEach
    public void setup() throws StudentException {
        studentRepository = new StudentRepository();
    }

    @Test
    @DisplayName("Student list should have 100 elements")
    public void studentInstanciationTest() throws SQLException {
        List<Student> students = studentRepository.findAll();
        assertEquals(100, students.size());
    }

    @Test
    @DisplayName("Should have Adam Xavière 17 as first result")
    public void firstStudentMustMatch() throws SQLException {
        List<Student> students = studentRepository.findAll();
        Student student = students.get(0);

        assertAll(
                () -> assertEquals("Adam", student.getLastName()),
                () -> assertEquals(17, student.getId()),
                () -> assertEquals("Xavière", student.getFirstName())
        );
    }
}
