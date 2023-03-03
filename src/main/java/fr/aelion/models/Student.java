package fr.aelion.models;

public class Student extends Person {
    private int id;

    private String login;
    private String password;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
    public void setLogin(String login) {
        this.login = login;
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

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

}
