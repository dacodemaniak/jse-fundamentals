import fr.aelion.helpers.exceptions.StudentException;
import fr.aelion.models.Student;
import fr.aelion.repositories.StudentRepository;
import fr.aelion.user.LoginManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginManagerTest {
    public LoginManager loginManager;
    public StudentRepository studentRepository;
    @BeforeEach
    public void setup() throws StudentException {
        this.loginManager = new LoginManager("bond", "007");
        this.studentRepository = loginManager.getStudentRepository();
    }
    @Test
    @DisplayName("Login and password should be 'bond' and '007'")
    public void haveCredentials() {
        assertAll("Credentials",
                () -> assertEquals("bond", this.loginManager.getLogin()),
                () -> assertEquals("007", this.loginManager.getPassword())
        );
    }

    @Test
    @DisplayName("Should return 200 Ok if credentials was good")
    public void goodCredentials() {
        assertEquals("200 Ok", this.loginManager.login());
    }

    @Test
    @DisplayName("Should return 404 Not Found if bad credentials")
    public void badCredentials() throws StudentException {
        LoginManager loginManager = new LoginManager("toto", "tata");
        assertEquals("404 Not Found", loginManager.login());
    }

    @Test
    @DisplayName("Student should be logged in")
    public void studentLogin() {
        StudentRepository studentRepository = this.loginManager.getStudentRepository();
        Student student = studentRepository.findByLoginAndPassword("bond", "007");

        assertEquals(false, student.isLoggedIn());

        this.loginManager.login();

        assertEquals(true, student.isLoggedIn());
    }

    @Test
    @DisplayName("Student should be logged out")
    public void studentLogout() {
        Student student = this.studentRepository.findByLoginAndPassword("bond", "007");
        this.loginManager.login();
        this.loginManager.logout();
        assertEquals(false, student.isLoggedIn());
    }
}
