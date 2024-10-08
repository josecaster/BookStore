package org.example;

import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.component.page.Push;
import com.vaadin.flow.component.page.Viewport;
import com.vaadin.flow.theme.Theme;
import org.example.item.Books;
import org.example.item.LibraryItemTypes;
import org.example.item.Magazines;
import org.example.people.People;
import org.example.people.Reader;
import org.example.people.Worker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;

@SpringBootApplication
@Theme(value = "theme1")
@Viewport(Viewport.DEVICE_DIMENSIONS)
@Push
public class Main implements AppShellConfigurator {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }












    private static void extracted() {
        System.out.println("Hello world!");

        Books book1 = new Books(1, "Java programming 1", "JC");
        Books book2 = new Books(3, "Java programming 2", "JC");
        Magazines magazine1 = new Magazines(2, "Java Magazine 1", "JC");
        Magazines magazine2 = new Magazines(4, "Java Magazine 2", "JC");

        Worker worker = new Worker("Ruchika", "Adhin", 1);
        Reader reader = new Reader("Deborah", "Veira", 2);

        System.out.println(book1.price(worker, 29));
        System.out.println(book1.price(reader, 61));
        System.out.println(magazine1.price(worker, 30));
        System.out.println(magazine1.price(reader, 30));

        Books[] arrayOfBooks = new Books[2];
        arrayOfBooks[0] = book1;
        arrayOfBooks[1] = book2;

        Magazines[] arrayOfMagazines = new Magazines[]{magazine1, magazine2};

        drinks(new String[]{"Cola", "Sprite", "Ginger"}, new String[]{"Parbo", "Heineken"});


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
        mapOfBooks.put("ISBN-FM000000", book1);
        mapOfBooks.put("ISBN-FM000002", book2);


        Iterator<Magazines> iterator = listOfMagazines.iterator();
        while (iterator.hasNext()) {
            Magazines next = iterator.next();
            System.out.println(next.getNaam());
        }

        List<Magazines> newListOfMagazines = new ArrayList<>();
        newListOfMagazines.add(magazine1);
        newListOfMagazines.add(magazine2);

        for (Magazines mag : newListOfMagazines) {
            System.out.println(mag.getNaam());
        }

        for (int i = 0; i < newListOfMagazines.size(); i++) {
            Magazines magazines = newListOfMagazines.get(i);
            System.out.println(magazines.getNaam());
        }

        newListOfMagazines.forEach(f -> System.out.println("New: " + f.getNaam()));

        newListOfMagazines.stream().sorted(Comparator.comparingInt(Magazines::getId).reversed()).forEach(f -> System.out.println("Sorted: " + f.getNaam()));

        List<String> types = LibraryItemTypes.getInstance().getTypes();
        System.out.println(types);


        List<String> types1 = LibraryItemTypes.getInstance().getTypes();
        System.out.println(types);
    }

    public static void drinks(String[] softdrinks, String[] beers) {

    }

//    private static void extracted(Worker worker, Books jpBook, Reader reader, Magazines jpMag) {
//        System.out.println(worker.getType()+" "+ worker.getFirstName()+" Pays "+ jpBook.price(worker)+" for "+ jpBook.getTitle());
//        System.out.println(reader.getType()+" "+ reader.getFirstName()+" Pays "+ jpBook.price(reader)+" for "+ jpBook.getTitle());
//        System.out.println(worker.getType()+" "+ worker.getFirstName()+" Pays "+ jpMag.price(worker)+" for "+ jpMag.getTitle());
//        System.out.println(reader.getType()+" "+ reader.getFirstName()+" Pays "+ jpMag.price(reader)+" for "+ jpMag.getTitle());
//    }
}