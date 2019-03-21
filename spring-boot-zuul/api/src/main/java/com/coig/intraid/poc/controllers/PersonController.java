package com.coig.intraid.poc.controllers;

import com.coig.intraid.poc.entities.Person;
import com.coig.intraid.poc.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping(path = "/persons/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Person> get(@PathVariable(name = "id") long id) {
        return new ResponseEntity<>(personService.get(id), HttpStatus.OK);
    }

    @GetMapping(path = "/persons/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Person>> list() {
        return new ResponseEntity<>(personService.list(), HttpStatus.OK);
    }

    @DeleteMapping(path = "/persons/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> delete(@PathVariable(name = "id") long id) {
        return new ResponseEntity<>(personService.delete(id), HttpStatus.OK);
    }

    @PostMapping(path = "/persons/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> save(@RequestBody Person person) {
        return new ResponseEntity<>(personService.save(person), HttpStatus.OK);
    }

}
