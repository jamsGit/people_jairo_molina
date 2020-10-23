package com.person.api.repository;

import com.person.api.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



public interface PersonRepository extends JpaRepository<Person, String> {
  @Query("SELECT p FROM  people  p WHERE p.document=(:document)")
  Person findByDocument(@Param("document") String document);
}
