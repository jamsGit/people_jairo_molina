package com.person.api.services;

import java.util.List;

import com.person.api.models.Person;
import com.person.api.repository.PersonRepository;


import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.Single;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PersonService implements BaseService<Person> {

  @Autowired
  private PersonRepository personRepository;


  @Transactional
  public Single<Person> getDocument(String document) {
    return Single.just(personRepository.findByDocument(document))
        .subscribeOn(Schedulers.io());
  }

  @Override
  @Transactional
  public Observable<List<Person>> findAll() throws Exception {
    return Observable.just(personRepository.findAll());
  }
  
  @Transactional
  public Person updatePerson(Person person) {
    return personRepository.save(person);
  }
}
