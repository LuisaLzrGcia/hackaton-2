package org.generation.exceptions;

//Excepción lanzada cuando el número telefónico ingresado no es válido (por ejemplo, contiene letras o caracteres no permitidos).

public class InvalidPhoneNumberException extends RuntimeException {

    public InvalidPhoneNumberException(String invalidPhone) {
        super("Número telefónico inválido: " + invalidPhone + ". Solo se permiten dígitos numéricos.");
    }

}
