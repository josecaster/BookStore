package org.example.item;

import org.example.people.People;

public class Books extends LibraryItem{
    public Books(int id, String title, String author) {
        super(id, title, author);
    }

    @Override
    public double price(People people) {
        if(people.getType().equalsIgnoreCase("Worker")){
            return 1;
        } else if(people.getType().equalsIgnoreCase("Reader")){
            return 6;
        }
        return 0;
    }
}
