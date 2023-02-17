import fr.aelion.user.LoginManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginManagerTest {
    public LoginManager loginManager;
    @BeforeEach
    public void setup() {
        this.loginManager = new LoginManager("bond", "007");
    }
    @Test
    @DisplayName("Login and password should be 'bond' and '007'")
    public void haveCredentials() {
        assertAll("Credentials",
                () -> assertEquals("bond", this.loginManager.getLogin()),
                () -> assertEquals("007", this.loginManager.getPassword())
        );
    }
}
