package org.example.item;

import jakarta.persistence.Entity;
import org.example.people.People;

@Entity
public class Magazines extends LibraryItem{
    public Magazines(Integer id, String title, String author) {
        super(id, title, author);
    }

    public Magazines() {
        super();
    }

    @Override
    public double price(People people, int durationInDays) {
        if(people.getType().equalsIgnoreCase("Worker")){
            return 0;
        } else if(people.getType().equalsIgnoreCase("Reader")){
            return 5;
        }
        return 0;
    }


}
