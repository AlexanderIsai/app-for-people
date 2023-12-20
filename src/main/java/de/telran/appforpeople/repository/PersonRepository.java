package de.telran.appforpeople.repository;

import de.telran.appforpeople.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {

}
