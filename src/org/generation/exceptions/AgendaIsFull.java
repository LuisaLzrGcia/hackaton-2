package org.generation.exceptions;

public class AgendaIsFull extends Exception {
    public AgendaIsFull() {
        super("⚠️ La agenda está llena.");
    }
}
