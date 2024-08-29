package org.example.item;

import jakarta.persistence.*;
import org.example.people.People;

@MappedSuperclass
public abstract class LibraryItem {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idgenerator")
    // The initial value is to account for data.sql demo data ids
    @SequenceGenerator(name = "idgenerator", initialValue = 1000)
    private Integer id;

    @Column(name = "title")
    private String naam;
    private String author;

    @Lob
    @Column(length = 1000000)
    private byte[] bookPdf;

    public LibraryItem(Integer id, String title, String author){
        this.id = id;
        this.naam = title;
        this.author = author;
    }

    public LibraryItem(){
    }

    public abstract double price(People people, int durationInDays);

    public void doSomething(){
        System.out.println("This is parent");
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String title) {
        this.naam = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public byte[] getBookPdf() {
        return bookPdf;
    }

    public void setBookPdf(byte[] bookPdf) {
        this.bookPdf = bookPdf;
    }
}
