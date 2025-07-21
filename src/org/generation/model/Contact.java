package org.generation.model;

public class Contact {
    private String name;
    private String phone;

    public Contact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    // dos contactos se consideran iguales solo si el nombre coincide.
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Contact other = (Contact) obj;
        return name.equalsIgnoreCase(other.name);
    }

    @Override
    public String toString() {
        return name + ": " + phone;
    }
}
