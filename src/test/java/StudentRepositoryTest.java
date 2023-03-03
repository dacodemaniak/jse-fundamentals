import fr.aelion.helpers.exceptions.StudentException;
import fr.aelion.models.Student;
import fr.aelion.repositories.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StudentRepositoryTest {
    StudentRepository studentRepository;
    @BeforeEach
    public void setup() throws StudentException {
        studentRepository = new StudentRepository(Student.class);
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

    @Test
    @DisplayName("Student should be found with credentials : 'Blanchard.Sylvain' and 'aKAtVbCPtniTELjbMfnT'")
    void shouldBeFound() throws StudentException, SQLException {
        Student student = studentRepository.findByLoginAndPassword("Blanchard.Sylvain", "aKAtVbCPtniTELjbMfnT");
        assertTrue(student instanceof Student);
    }

    @Test
    @DisplayName("Should raised an exception if bad credentials")
    void shouldRaisedAnException() {
        assertThrows(
                StudentException.class,
                () -> studentRepository.findByLoginAndPassword("Aubert", "jlaubert")
        );
    }

    @Test
    @DisplayName("Shoud find a Student with id '53'")
    void shouldGetStudentById() throws StudentException, SQLException {
        Student student = studentRepository.find(53);
        assertAll(
                () -> assertTrue(student instanceof Student),
                () -> assertEquals("Perez", student.getLastName())
        );
    }

    @Test
    @DisplayName("Should raised a NotFoundException with id 200")
    void shouldNotFoundStudentWithId() throws StudentException, SQLException {

        assertThrows(
                StudentException.class,
                () -> studentRepository.find(200)
        );
    }

    /**
    @Test
    @DisplayName("Should return 'student' from model Student")
    void shouldReturnTableName() {
        assertEquals("student", studentRepository.getTableName());
    }

    @Test
    @DisplayName("Should give 'student s' from Student class")
    void shouldGiveAliasedTableName() {
        assertEquals("student s", studentRepository.getAliasedTableName());
    }

    @Test
    @DisplayName("Should get all attributes from model")
    void shouldListAllAttributes() {
        String[] expectedFields = {"email", "firstName", "id", "lastName", "login", "password", "phoneNumber"};
        String[] classFields = studentRepository.getFields();
        Arrays.sort(classFields);

        assertTrue(Arrays.equals(expectedFields, classFields));
    }

    @Test
    @DisplayName("Should return a comma separate list of column names")
    void shouldReturnCommaSeparatedList() {
        String expected = "s.email,s.first_name,s.id,s.last_name,s.login,s.password,s.phone_number";
        assertEquals(expected, studentRepository.getCommaSeparatedColumns());
    }

    @Test
    @DisplayName("Should return a full SELECT query")
    void shouldReturnFullSelectQuery() {
        String expected = "SELECT s.email,s.first_name,s.id,s.last_name,s.login,s.password,s.phone_number FROM student s;";

        assertEquals(expected, studentRepository.getSelectQuery());
    }
    **/
}
