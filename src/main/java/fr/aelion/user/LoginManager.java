package fr.aelion.user;

import fr.aelion.helpers.exceptions.StudentException;
import fr.aelion.models.Student;
import fr.aelion.repositories.StudentRepository;

public class LoginManager {
    private String login;
    private String password;

    private StudentRepository studentRepository = new StudentRepository();
    public LoginManager(String login, String password) throws StudentException {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public StudentRepository getStudentRepository() {
        return this.studentRepository;
    }
    public String login() {

        return "404 Not Found";
        /**
         * if (this.studentRepository.findByLoginAndPassword(this.login, this.password)) {
         *  return "200 Ok"
         * }
         * return "404 Not Found"
         */
    }

    public void logout() {}
}
