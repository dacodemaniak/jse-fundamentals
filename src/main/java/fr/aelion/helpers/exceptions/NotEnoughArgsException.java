package fr.aelion.helpers.exceptions;

public class NotEnoughArgsException extends Exception {
    public NotEnoughArgsException() {
        super("Title or Duration was not provided");
    }
}
