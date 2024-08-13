package org.example;

import org.example.item.Books;
import org.example.item.Magazines;
import org.example.people.Reader;
import org.example.people.Worker;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world!");

        Books jpBook = new Books(1,"Java programming","JC");
        Magazines jpMag = new Magazines(2,"Java Magazine","JC");

        Worker worker = new Worker("Ruchika", "Adhin", 1);
        Reader reader = new Reader("Deborah", "Veira", 2);

        System.out.println(jpBook.price(worker));
        System.out.println(jpBook.price(reader));
        System.out.println(jpMag.price(worker));
        System.out.println(jpMag.price(reader));


    }

//    private static void extracted(Worker worker, Books jpBook, Reader reader, Magazines jpMag) {
//        System.out.println(worker.getType()+" "+ worker.getFirstName()+" Pays "+ jpBook.price(worker)+" for "+ jpBook.getTitle());
//        System.out.println(reader.getType()+" "+ reader.getFirstName()+" Pays "+ jpBook.price(reader)+" for "+ jpBook.getTitle());
//        System.out.println(worker.getType()+" "+ worker.getFirstName()+" Pays "+ jpMag.price(worker)+" for "+ jpMag.getTitle());
//        System.out.println(reader.getType()+" "+ reader.getFirstName()+" Pays "+ jpMag.price(reader)+" for "+ jpMag.getTitle());
//    }
}