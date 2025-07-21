package org.generation.exceptions;

// Excepción lanzada cuando no se encuentra un contacto con el nombre y apellido especificado.
public class ContactNotFoundException extends RuntimeException {

    public ContactNotFoundException(String message) {
        super(message);
    }
}