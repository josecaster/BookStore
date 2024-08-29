package org.example;

import org.example.item.Books;
import org.example.item.Magazines;
import org.example.repository.IBookRepository;
import org.example.repository.IMagazinesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MagazinesService {

    @Autowired
    private IMagazinesRepository repository;

    public Magazines save(Magazines magazines){
        return repository.save(magazines);
    }

    public List<Magazines> getAll() {
        repository.getMagazinesByTitle("");
        return repository.findAll();
    }
}
