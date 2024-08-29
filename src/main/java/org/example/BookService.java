package org.example;

import org.example.exceptions.DatabaseException;
import org.example.item.Books;
import org.example.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private IBookRepository repository;

    public Books save(Books books){
        return repository.save(books);
    }

    public List<Books> getAll() {
        repository.getBookByTitle("");
        return repository.findAll();
    }

    public void delete(Integer id) throws DatabaseException {


        try {
            repository.deleteById(id);
        }catch (Exception rodney){
            throw new DatabaseException(rodney.getMessage());
        }

    }
}
