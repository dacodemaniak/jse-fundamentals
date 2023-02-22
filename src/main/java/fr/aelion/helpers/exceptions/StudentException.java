package fr.aelion.helpers.exceptions;

public class StudentException extends Exception {
    private StudentException(String message) {
        super(message);
    }

    public static StudentException noNameException() {
        return new StudentException("No Name was provided");
    }

    public static StudentException noMailException() {
        return new StudentException("No Email was provided");
    }

    public static StudentException noUsernameException() {
        return new StudentException("No username was provided");
    }

    public static StudentException noPasswordException() {
        return new StudentException("No password was provided");
    }
}
