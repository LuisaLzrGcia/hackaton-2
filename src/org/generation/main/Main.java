package org.generation.service;


import org.generation.exceptions.ContactNotFoundException;
import org.generation.model.Contact;
import org.generation.service.ContactServices;

import java.util.List;
import java.util.Scanner;

class Main {
     private static final Scanner scanner = new Scanner(System.in);
     private static final ContactServices agenda = new ContactServices();// cambiar la clase para el servicio de la agenda
    public static void main(String[] args) {
        while (true){
            menu();
            int opt = Integer.parseInt(scanner.nextLine());
            switch (opt){
                case 1 -> add();
                case 2 -> exists();
                case 3 -> listAll();
                case 4 -> search();
                case 5 -> delete();
                case 6 -> full();
                case 7 -> freeSpaces();
                case 0 -> { System.out.println("Saliendo..."); return;}
                default -> System.out.println("Opción no valida");
            }
=======
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
            if (contact.getName().equals(name)) {
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
