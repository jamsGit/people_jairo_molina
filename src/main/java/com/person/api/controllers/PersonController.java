package com.person.api.controllers;


import com.person.api.models.Person;

import com.person.api.services.PersonService;
import io.reactivex.Observable;
import io.reactivex.Single;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/core/")
public class PersonController {
  @Autowired
  private PersonService personService;

  @GetMapping("listar")
  public Observable<List<Person>> findAll() throws Exception {
    return personService.findAll();
  }

  /**
   * get.
   * 
   **/
  @GetMapping("persons")
  public Single<Person> singleTest(@RequestParam("documentNumber") String documentNumber) {
   
      return personService.getDocument(documentNumber)
          .doOnError(onError -> ResponseEntity.status(HttpStatus.FORBIDDEN).build())
          .doOnSuccess(onSuccess -> ResponseEntity.ok());

  }
  
  @PutMapping("update/{documentNumber}")
  public void updatePerson(@RequestBody Person person, @PathVariable String documentNumber) {
    System.out.println("pasa por update");
    personService.updatePerson(person);
  }

 
}
