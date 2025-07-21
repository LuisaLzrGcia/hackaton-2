package org.generation.main;

import java.util.Scanner;

class Main {
     private static final Scanner scanner = new Scanner(System.in);
     private static final AgendaService agenda = new AgendaService();// cambiar la clase para el servicio de la agenda
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
        }
    } //main

    private static void menu(){
        System.out.println("""
            --- AGENDA ---
            1. Añadir contacto
            2. Existe contacto
            3. Listar contactos
            4. Buscar contacto
            5. Eliminar contacto
            6. Agenda llena?
            7. Espacios libres
            0. Salir
            Elige:
            """);
    } // menu

    private static void add(){
        System.out.println("Nombre: ");
        String n = scanner.nextLine();
        System.out.println("Teléfono: ");
        String t = scanner.nextLine();
        Contact c = new Contact(n,t);
        if (agenda.addContact(c)){
            System.out.println("Contacto añadido");
        } else if (agenda.existsContact(c)) {
            System.out.println("Ya existe ese nombre");
        }else {
            System.out.println("Agenda llena");
        }
    } // add
    // verifica si ingresando el nombre del contacto existe o no, usando la
    private static void exists(){
        System.out.println("Nombre a verificar: ");
        String n = scanner.nextLine();
        System.out.println(agenda.existsContact(new Contact (n,""))
        ? "Si existe" : "No existe"
        );
    } // exists
    // muestra en consola toda la lista de contactos
    private static void listAll(){
        agenda.listContacts().forEach(System.out::println);
    } //listAll
    // busca por nombre de contacto y devuelve el teléfono
    private static void search(){
        System.out.println("Nombre a buscar: ");
        Contact found = agenda.searchContactact(scanner.nextLine());
        System.out.println(found != null
                ? "Teléfono: " + found.getPhone()
                : "No encontrado");
    }//search
    // elimina el contacto por el nombre ingresado
    private static void delete(){
        System.out.println("Nombre a eleminar: ");
        Contact c = new Contact(scanner.nextLine(), "");
        System.out.println(agenda.deleteContact(c)
        ? "Eliminado"
        : "No existe");
    }//delete
    // verifica si la agenda esta llena o no
    private static void full(){
        System.out.println(agenda.agendaLlena()
        ? "Si, llena"
        : "Aun cabe");
    }//full
    //
    private static void freeSpaces(){
        System.out.println("Espacios libres: " + agenda.spaceLeft());
    }
}
