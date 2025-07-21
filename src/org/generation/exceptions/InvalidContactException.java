package org.generation.exceptions;

//Excepción lanzada cuando el número telefónico ingresado no es válido (por ejemplo, contiene letras o caracteres no permitidos).

public class InvalidContactException extends RuntimeException {

    public InvalidContactException(String message) {
        super(message);
    }

}
