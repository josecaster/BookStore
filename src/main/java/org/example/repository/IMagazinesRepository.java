package org.example.repository;

import org.example.item.Magazines;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IMagazinesRepository extends JpaRepository<Magazines, Integer>, JpaSpecificationExecutor<Magazines> {

    @Query("from Magazines where naam = :abc")
    Magazines getMagazinesByTitle(@Param("abc") String name);

}
