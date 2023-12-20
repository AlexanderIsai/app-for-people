package de.telran.appforpeople.service;

import de.telran.appforpeople.entity.Person;

public interface PersonService {
    Person getByID (Integer id);
    void save (Person person);
    String encryptPassword(String password);
}
