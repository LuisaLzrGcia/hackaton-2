package org.generation.service;

import org.generation.exceptions.ContactNotFoundException;
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

    //--- Buscar por nombre
    public Contact findByName(String name) {
        Iterator<Contact> iterator =contacts.iterator();
        while (iterator.hasNext()){
            Contact contact = iterator.next();
            if (contact.getNameContact().equals(name)){
                return contact;
            }
        }
        throw new ContactNotFoundException("No se encuentra el contacto con nombre: "+name);
    }


}
