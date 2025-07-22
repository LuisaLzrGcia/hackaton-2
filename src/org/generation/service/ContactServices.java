package org.generation.service;

import org.generation.exceptions.ContactAlreadyExistsException;
import org.generation.exceptions.ContactNotFoundException;
import org.generation.exceptions.EmptyNameException;
import org.generation.exceptions.InvalidContactException;
import org.generation.model.Contact;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ContactServices {
    private final List<Contact> contacts = new ArrayList<>();
    private int capacity;

    // Constructor con capacidad por defecto
    public ContactServices() {
        this(10); // llama al otro constructor con 10
    }

    // Constructor con capacidad personalizada
    public ContactServices(int maxCapacity) {
        if (maxCapacity <= 0) {
            throw new IllegalArgumentException("La capacidad debe ser mayor a 0.");
        }
        this.capacity = maxCapacity;
    }

    // Verificar si un contacto es valido
    public void validateContact(Contact contact) {
        if (contact == null) {
            throw new InvalidContactException("El contacto no puede ser null.");
        }

        if (contact.getName() == null || contact.getName().isBlank()) {
            throw new EmptyNameException("El nombre no puede estar vacío.");
        }


        if (contact.getPhone() == null || contact.getPhone().isBlank()) {
            throw new InvalidContactException("El teléfono no puede estar vacío.");
        }

        if (!contact.getPhone().matches("\\d{10}")) {
            throw new InvalidContactException("El teléfono debe contener solo dígitos y tener 10 caracteres.");
        }
    }


    //--- Agregar contacto
    public void addContact(Contact contact) {

        validateContact(contact);

        if (contactExists(contact)) {
            throw new ContactAlreadyExistsException("El contacto ya existe en la agenda.");
        }

        if (isFull()) {
            throw new IllegalArgumentException("El contacto ya existe en la agenda.");
        }

        contacts.add(contact);

    }

    //--- Listar contactos
    public List<Contact> getContacts() {
        return contacts;
    }

    //--- Buscar por nombre
    public Contact findByName(String name) {
        Iterator<Contact> iterator = contacts.iterator();
        while (iterator.hasNext()) {
            Contact contact = iterator.next();
            if (contact.getName().equals(name)) {
                return contact;
            }
        }
        throw new ContactNotFoundException("No se encuentra el contacto con nombre: " + name);
    }

    //--- Buscar por telefono
    public Contact findByPhone(String phone) {
        Iterator<Contact> iterator = contacts.iterator();
        while (iterator.hasNext()) {
            Contact contact = iterator.next();
            if (contact.getPhone().equals(phone)) {
                return contact;
            }
        }
        throw new ContactNotFoundException("No se encuentra el contacto con telefono: " + phone);
    }

    //--- El contacto existe
    public boolean contactExists(Contact currentContact) {
        Iterator<Contact> iterator = contacts.iterator();
        while (iterator.hasNext()) {
            Contact contact = iterator.next();
            if (contact.getName().equalsIgnoreCase(currentContact.getName())) {
                return true;
            }
        }
        return false;
    }

    //--- Modificar telefono de un contacto
    public void updatePhone(String name, String newPhone) {
        Contact contact = findByName(name); // buscar contacto

        if (contact == null) {
            throw new ContactNotFoundException("No se encontró el contacto con nombre: " + name);
        }

        // Validar nuevo teléfono
        if (newPhone == null || newPhone.isBlank()) {
            throw new InvalidContactException("El teléfono no puede estar vacío.");
        }

        if (!newPhone.matches("\\d{10}")) {
            throw new InvalidContactException("El teléfono debe tener 10 dígitos.");
        }

        contact.setPhone(newPhone);
    }


    //--- Eliminar un contacto de la agenda
    public void deleteContact(Contact contact) {
        validateContact(contact);

        if (contactExists(contact)) {
            contacts.remove(contact);
        } else {
            throw new ContactNotFoundException("No se encontro el contacto '" + contact.getName() + "' para eliminar.");
        }
    }

    public boolean isFull() {
        return (contacts.size() == capacity);
    }

    public int availableSlots() {
        return capacity - contacts.size();
    }

}
