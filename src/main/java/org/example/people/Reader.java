package org.example.people;

import jakarta.persistence.Entity;

@Entity
public class Reader extends People{
    public Reader(String firstName, String lastName, int id) {
        super(firstName, lastName, id,"Reader");
    }
}
