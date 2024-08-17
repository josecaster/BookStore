package org.example.item;

import java.util.ArrayList;
import java.util.List;

public class LibraryItemTypes {

    private static LibraryItemTypes singleton;
    private List<String> types;

    private LibraryItemTypes() {
        types = new ArrayList<>();
        types.add("Book");
        types.add("Magazine");
    }

    public static LibraryItemTypes getInstance(){
        if(singleton == null){
            singleton = new LibraryItemTypes();
        }
        return singleton;
    }

    public List<String> getTypes() {
        return types;
    }
}
