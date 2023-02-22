package fr.aelion.helpers.exceptions;

public class NoMediaTypeException extends Exception {
    public NoMediaTypeException() {
        super("No type was passed to Media");
    }
}
