package org.example.item;

import org.example.people.People;

public class Magazines extends LibraryItem{
    public Magazines(int id, String title, String author) {
        super(id, title, author);
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
