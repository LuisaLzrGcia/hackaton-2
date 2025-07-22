package org.generation.exceptions;

public class AgendaFullException extends RuntimeException {
    public AgendaFullException(String message) {
        super(message);
    }
}
