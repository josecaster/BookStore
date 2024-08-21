package org.example.people;

import jakarta.persistence.Entity;

@Entity
public class Worker extends People{
    public Worker(String firstName, String lastName, int id) {
        super(firstName, lastName, id,"Worker");
    }
}
