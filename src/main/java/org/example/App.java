package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {


        String pathname = "C:\\Users\\Jose Caster\\Documents\\NexySchool\\test\\test";
        makeFile(pathname, 0);
    }

    private static void makeFile(String pathname, int i) {
        File myTextFile = i == 0 ? new File(pathname+".txt") : new File(pathname+"("+i+").txt");

        try {
            if(myTextFile.createNewFile()){
                System.out.println("File created: " + myTextFile.getName());


                try {
                    FileWriter myWriter = new FileWriter(myTextFile);
                    myWriter.write("Files in Java might be tricky, but it is fun enough!");
                    myWriter.close();
                    System.out.println("Successfully wrote to the file.");
                } catch (IOException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }



                try {
                    Scanner myReader = new Scanner(myTextFile);
                    while (myReader.hasNextLine()) {
                        String data = myReader.nextLine();
                        System.out.println(data);
                    }
                    myReader.close();
                } catch (FileNotFoundException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }

            }else {
                System.out.println("File already exists.");
                boolean delete = myTextFile.delete();
                if(delete) {
                    makeFile(pathname, 0);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
