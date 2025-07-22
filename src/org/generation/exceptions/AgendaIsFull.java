package org.generation.exceptions;

public class AgendaIsFull extends RuntimeException {
    public AgendaIsFull() {
        super("⚠️ La agenda está llena.");
    }
}
