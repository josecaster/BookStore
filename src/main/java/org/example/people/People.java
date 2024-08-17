package org.example.people;

public class People {
    private String firstName,lastName;
    private int id;
    private String type;

    public People(String firstName, String lastName, int id, String type) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.type = type;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
