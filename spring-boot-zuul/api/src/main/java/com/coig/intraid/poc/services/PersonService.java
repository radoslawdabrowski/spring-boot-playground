package com.coig.intraid.poc.services;

import com.coig.intraid.poc.entities.Person;

import java.util.List;

public interface PersonService {

    //todo add DTO layer.
    Person get(long id);

    //todo add pageable.
    List<Person> list();

    //todo add saving multiple objects.
    boolean save(Person person);

    boolean delete(long id);

}
