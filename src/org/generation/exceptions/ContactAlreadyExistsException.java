package org.generation.exceptions;

// Excepción lanzada cuando se intenta crear un contacto que ya existe en el sistema.
public class ContactAlreadyExistsException extends RuntimeException {

    public ContactAlreadyExistsException(String message) {
        super(message);
    }
}