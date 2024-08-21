package org.example.repository;

import org.example.item.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IBookRepository extends JpaRepository<Books, Integer>, JpaSpecificationExecutor<Books> {

    @Query("from Books where naam = :abc")
    Books getBookByTitle(@Param("abc") String name);

}
