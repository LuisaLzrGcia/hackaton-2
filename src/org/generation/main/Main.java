package org.generation.main;

import java.util.List;
import java.util.Scanner;

import org.generation.exceptions.AgendaIsFull;
import org.generation.exceptions.ContactAlreadyExistsException;
import org.generation.exceptions.ContactNotFoundException;
import org.generation.exceptions.EmptyNameException;
import org.generation.exceptions.InvalidContactException;
import org.generation.model.Contact;
import org.generation.service.ContactServices;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        // 1. Preguntar capacidad deseada
        System.out.print("¿Cuántos contactos deseas poder almacenar? (Enter = 10 por defecto): ");
        String line = scanner.nextLine().trim();
        int cap;
        if (line.isEmpty()) {
            cap = 10;
        } else {
            try {
                cap = Integer.parseInt(line);
                if (cap <= 0) throw new NumberFormatException();
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido. Se usará capacidad por defecto (10).");
                cap = 10;
            }
        }

        ContactServices service = new ContactServices(cap);
        System.out.println("Capacidad de la agenda: " + service.availableSlots() + " contactos.\n");

        boolean salir = false;
        while (!salir) {
            mostrarMenu();
            String opt = scanner.nextLine().trim();
            switch (opt) {
                case "1":
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Teléfono (10 dígitos): ");
                    String telefono = scanner.nextLine();
                    try {
                        service.addContact(new Contact(nombre, telefono));
                        System.out.println("Contacto añadido.");
                    } catch (ContactAlreadyExistsException e) {
                        System.out.println("! Ya existe ese contacto.");
                    } catch (InvalidContactException | EmptyNameException e) {
                        System.out.println("! Datos inválidos: " + e.getMessage());
                    }
                    break;

                case "2":
                    System.out.print("Nombre a buscar: ");
                    nombre = scanner.nextLine();
                    boolean existe = service.contactExists(new Contact(nombre, "0000000000"));
                    System.out.println(
                        existe ? "Existe en la agenda." : "No existe."
                    );
                    break;

                case "3":
                    List<Contact> all = service.getContacts();
                    if (all.isEmpty()) {
                        System.out.println("La agenda está vacía.");
                    } else {
                        System.out.println("Contactos:");
                        all.forEach(c -> System.out.println(" - " + c));
                    }
                    break;

                case "4":
                    System.out.print("Nombre a buscar: ");
                    nombre = scanner.nextLine();
                    try {
                        Contact c = service.findByName(nombre);
                        System.out.println("Teléfono: " + c.getPhone());
                    } catch (ContactNotFoundException e) {
                        System.out.println("! " + e.getMessage());
                    }
                    break;

                case "5":
                    System.out.print("Nombre a eliminar: ");
                    nombre = scanner.nextLine();
                    try {
                        Contact toDelete = service.findByName(nombre);
                        service.deleteContact(toDelete);
                        System.out.println("Eliminado.");
                    } catch (ContactNotFoundException e) {
                        System.out.println("! " + e.getMessage());
                    }
                    break;

                case "6":
                    System.out.println(
                        service.isFull()
                            ? "Agenda llena."
                            : "Aún hay espacio."
                    );
                    break;

                case "7":
                    System.out.println("Espacios libres: " + service.availableSlots());
                    break;

                case "0":
                    salir = true;
                    System.out.println("Saliendo... ¡Hasta luego!");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
            System.out.println();
        }
        scanner.close();
    }//main
    private static void mostrarMenu() {
        System.out.println("=== MENÚ DE AGENDA ===");
        System.out.println("1. Añadir contacto");
        System.out.println("2. Verificar existencia");
        System.out.println("3. Listar contactos");
        System.out.println("4. Buscar por nombre");
        System.out.println("5. Eliminar contacto");
        System.out.println("6. ¿Agenda llena?");
        System.out.println("7. Espacios libres");
        System.out.println("0. Salir");
        System.out.print("Selecciona: ");
    }//menu
}