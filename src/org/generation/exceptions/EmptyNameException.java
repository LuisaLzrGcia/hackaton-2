package org.generation.exceptions;

public class EmptyNameException extends Exception {
    public EmptyNameException() {
        super("El nombre no puede estar vacío");
    }

    public EmptyNameException(String message) {
        super(message);
    }
}