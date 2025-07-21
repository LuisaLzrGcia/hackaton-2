package org.generation.service;

import org.generation.model.Contact;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ContactServices {
    private final List<Contact> contacts = new ArrayList<>();

    //--- Agregar contacto
    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    //--- Listar contactos
    public List<Contact> getContacts() {
        return contacts;
    }


}
