package org.generation.service;

import org.generation.exceptions.AgendaIsFull;
import org.generation.exceptions.ContactNotFoundException;
import org.generation.model.Contact;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ContactServices {
    private final int capacidad = 10;
    private final List<Contact> contacts = new ArrayList<>();

    //--- Agregar contacto con validación
    public void addContact(Contact contact) throws AgendaIsFull {
        if (contacts.size() >= capacidad) {
            throw new AgendaIsFull();
        }
        if (contacts.contains(contact)) {
            System.out.println("❗ El contacto ya existe.");
            return;
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
            if (contact.getNameContact().equals(name)) {
                return contact;
            }
        }
        throw new ContactNotFoundException("No se encuentra el contacto con nombre: " + name);
    }

    //--- Buscar por teléfono
    public Contact findByPhone(String phone) {
        Iterator<Contact> iterator = contacts.iterator();
        while (iterator.hasNext()) {
            Contact contact = iterator.next();
            if (contact.getPhoneContact().equals(phone)) {
                return contact;
            }
        }
        throw new ContactNotFoundException("No se encuentra el contacto con telefono: " + phone);
    }
}
