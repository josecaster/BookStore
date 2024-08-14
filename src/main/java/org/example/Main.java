package org.example;

import org.example.item.Books;
import org.example.item.Magazines;
import org.example.people.People;
import org.example.people.Reader;
import org.example.people.Worker;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world!");

        Books book1 = new Books(1,"Java programming 1","JC");
        Books book2 = new Books(3,"Java programming 2","JC");
        Magazines magazine1 = new Magazines(2,"Java Magazine 1","JC");
        Magazines magazine2 = new Magazines(4,"Java Magazine 2","JC");

        Worker worker = new Worker("Ruchika", "Adhin", 1);
        Reader reader = new Reader("Deborah", "Veira", 2);

        System.out.println(book1.price(worker));
        System.out.println(book1.price(reader));
        System.out.println(magazine1.price(worker));
        System.out.println(magazine1.price(reader));

        Books[] arrayOfBooks = new Books[2];
        arrayOfBooks[0] = book1;
        arrayOfBooks[1] = book2;

        Magazines[] arrayOfMagazines = new Magazines[]{magazine1,magazine2};

        drinks(new String[]{"Cola","Sprite","Ginger"}, new String[]{"Parbo", "Heineken"});





//        // FIRST IN FIRST OUT
//        Queue<String> queueOfMilk = new PriorityQueue<>();
//        queueOfMilk.add("Milk1");
//        queueOfMilk.add("Milk2");
//        queueOfMilk.add("Milk3");
//        queueOfMilk.add("Milk4");
//        queueOfMilk.poll();

        List<Magazines> listOfMagazines = new ArrayList<>();
        listOfMagazines.add(magazine1);
        listOfMagazines.add(magazine2);

        Set<People> setOfNames = new HashSet<>();
        setOfNames.add(worker);
        setOfNames.add(reader);

        Map<String, Books> mapOfBooks = new HashMap<>();
        mapOfBooks.put("ISBN-FM000000",book1);
        mapOfBooks.put("ISBN-FM000002",book2);


        Iterator<Magazines> iterator = listOfMagazines.iterator();
        while(iterator.hasNext()){
            Magazines next = iterator.next();
            System.out.println(next.getTitle());
        }

        List<Magazines> newListOfMagazines = new ArrayList<>();
        newListOfMagazines.add(magazine1);
        newListOfMagazines.add(magazine2);

        for(Magazines mag : newListOfMagazines){
            System.out.println(mag.getTitle());
        }

        for(int z = 0;  z <newListOfMagazines.size();z++){
            Magazines mag = newListOfMagazines.get(z);
            System.out.println(mag.getTitle());
        }

        newListOfMagazines.forEach(f -> System.out.println("New: "+f.getTitle()));

        newListOfMagazines.stream().sorted(Comparator.comparingInt(Magazines::getId).reversed()).forEach(f -> System.out.println("Sorted: "+f.getTitle()));



    }

    public static void drinks(String[] softdrinks, String[] beers){

    }

//    private static void extracted(Worker worker, Books jpBook, Reader reader, Magazines jpMag) {
//        System.out.println(worker.getType()+" "+ worker.getFirstName()+" Pays "+ jpBook.price(worker)+" for "+ jpBook.getTitle());
//        System.out.println(reader.getType()+" "+ reader.getFirstName()+" Pays "+ jpBook.price(reader)+" for "+ jpBook.getTitle());
//        System.out.println(worker.getType()+" "+ worker.getFirstName()+" Pays "+ jpMag.price(worker)+" for "+ jpMag.getTitle());
//        System.out.println(reader.getType()+" "+ reader.getFirstName()+" Pays "+ jpMag.price(reader)+" for "+ jpMag.getTitle());
//    }
}