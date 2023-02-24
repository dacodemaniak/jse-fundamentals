package fr.aelion.models;

import fr.aelion.helpers.strategies.student.FirstNameLastNameStrategy;
import fr.aelion.helpers.strategies.student.IHelloStrategy;

public class Student extends Person {

    private String username;
    private String password;

    private Boolean isLoggedIn = false;

    private IHelloStrategy strategy = new FirstNameLastNameStrategy();

    public Student(String lastName, String firstName, String email) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
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

    public Boolean login(String username, String password) {
        if (username.equals(this.username) && password.equals(this.password)) {
            this.isLoggedIn = true;
            return true;
        }
        return false;
    }

    public void logout() {
        this.isLoggedIn = false;
    }
    public Boolean isLoggedIn() {
        return this.isLoggedIn;
    }

    public void isLoggedIn(boolean isLoggedIn) {
        this.isLoggedIn = isLoggedIn;
    }

    public void setStrategy(IHelloStrategy strategy) {
        this.strategy = strategy;
    }

    public String toString() {
        return this.strategy.greetings(this);
    }
}
