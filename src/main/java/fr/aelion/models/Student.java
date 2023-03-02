package fr.aelion.models;

import fr.aelion.helpers.strategies.student.FirstNameLastNameStrategy;
import fr.aelion.helpers.strategies.student.IHelloStrategy;

public class Student extends Person {
    private int id;

    private String username;
    private String password;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void setEmail(String email) {
        if (email.contains("@")) {
            this.email = email;
        }
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

}
