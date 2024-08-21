package org.example.item;

import jakarta.persistence.Entity;
import org.example.people.People;

@Entity
public class Books extends LibraryItem {
    public Books(Integer id, String title, String author) {
        super(id, title, author);
    }

    public Books() {
        super(null, null, null);
    }

    @Override
    public void doSomething() {
        super.doSomething();
        System.out.println("This is child");
    }

    @Override
    public double price(People people, int durationInDays) {
        if (durationInDays < 30) {
            if (people.getType().equalsIgnoreCase("Worker")) {
                return 0;
            } else if (people.getType().equalsIgnoreCase("Reader")) {
                return 2;
            }
        } else {
            if (people.getType().equalsIgnoreCase("Worker")) {
                return 1;
            } else if (people.getType().equalsIgnoreCase("Reader")) {
                return 6;
            }
        }
        return 0;
    }
}
