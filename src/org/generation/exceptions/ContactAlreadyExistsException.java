package org.generation.exceptions;

// Excepción lanzada cuando se intenta crear un contacto que ya existe en el sistema.
public class ContactAlreadyExistsException extends RuntimeException {

    public ContactAlreadyExistsException(String contactName) {
        super("El contacto '" + contactName + "' ya existe en la agenda. "
                + "Intente con un nombre diferente.");
    }
}