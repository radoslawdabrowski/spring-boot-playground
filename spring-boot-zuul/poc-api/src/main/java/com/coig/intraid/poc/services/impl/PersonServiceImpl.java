package com.coig.intraid.poc.services.impl;

import com.coig.intraid.poc.entities.Person;
import com.coig.intraid.poc.repositories.PersonRepository;
import com.coig.intraid.poc.services.PersonService;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository indexRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository indexRepository) {
        this.indexRepository = indexRepository;
    }

    @Override
    public Person get(long id) {
        return indexRepository.findById(id).orElse(null);
    }

    @Override
    public List<Person> list() {
        return Lists.newArrayList(indexRepository.findAll());
    }

    @Override
    public boolean save(Person person) {
        return indexRepository.save(person) != null;
    }

    @Override
    public boolean delete(long id) {
        try {
            indexRepository.deleteById(id);
        } catch (IllegalArgumentException ex) {
            return false;
        }
        return true;
    }
}
