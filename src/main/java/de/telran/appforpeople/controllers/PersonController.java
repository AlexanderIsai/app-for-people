package de.telran.appforpeople.controllers;

import de.telran.appforpeople.entity.Person;
import de.telran.appforpeople.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @GetMapping(value = "/person/{id}")
    public Person getPersonById(@PathVariable(value = "id") Integer id) {
        Person person = personService.getByID(id);
        return person;
    }

    @PostMapping(value = "/person")
    public void savePerson(@RequestBody Person person) {
        personService.save(person);
    }
}

