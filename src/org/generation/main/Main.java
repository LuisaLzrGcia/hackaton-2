package org.generation.service;

import org.generation.exceptions.AgendaIsFull;
import org.generation.exceptions.ContactNotFoundException;
import org.generation.model.Contact;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ContactServices {
    private final int capacidad = 10;
    private final List<Contact> contactos;

    public ContactServices() {
        contactos = new ArrayList<>();
    }

    //--- Agregar contacto con validación
    public void agregarContacto(Contact nuevo) throws AgendaIsFull {
        if (contactos.size() >= capacidad) {
            throw new AgendaIsFull();
        }
        if (contactos.contains(nuevo)) {
            System.out.println("❗ El contacto ya existe.");
            return;
        }
        contactos.add(nuevo);
    }

    //--- Listar todos los contactos
    public List<Contact> getContactos() {
        return contactos;
    }

    //--- Buscar por nombre
    public Contact findByName(String name) {
        for (Contact contact : contactos) {
            if (contact.getNameContact().equals(name)) {
                return contact;
            }
        }
        throw new ContactNotFoundException("No se encuentra el contacto con nombre: " + name);
    }

    //--- Buscar por teléfono
    public Contact findByPhone(String phone) {
        for (Contact contact : contactos) {
            if (contact.getPhoneContact().equals(phone)) {
                return contact;
            }
        }
        throw new ContactNotFoundException("No se encuentra el contacto con teléfono: " + phone);
    }
}
