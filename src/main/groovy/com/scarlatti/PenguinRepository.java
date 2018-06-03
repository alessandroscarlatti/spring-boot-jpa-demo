package com.scarlatti;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PenguinRepository extends CrudRepository<Penguin, Long>, SillyRepo {

    @Query("SELECT p FROM Penguin p WHERE firstName = :lastName")
    List<Penguin> findByLastName(@Param("lastName") String lastName);

    Penguin findByFirstName(String lastName);

    Optional<Penguin> findById(long id);
}