package org.generation.exceptions;

// Excepción personalizada para alertar cuando el usuario
// no ingresa ningún nombre al intentar crear o buscar un contacto.
// Se lanza cuando el campo de nombre está vacío.

public class EmptyNameException extends Exception {
    public EmptyNameException() {
        super("El nombre no puede estar vacío");
    }

    public EmptyNameException(String message) {
        super(message);
    }
}