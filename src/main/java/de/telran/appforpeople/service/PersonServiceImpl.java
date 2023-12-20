package de.telran.appforpeople.service;

import de.telran.appforpeople.entity.Person;
import de.telran.appforpeople.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Stack;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final int key = 5;

    @Override
    public Person getByID(Integer id) {
        Optional<Person> optional = personRepository.findById(id);
        optional.get().setPassword(encryptPassword(optional.get().getPassword()));
        return optional.orElse(null);
    }

    @Override
    public void save(Person person) {
        person.setPassword(encryptPassword(person.getPassword()));
        personRepository.save(person);

    }

    @Override
    public String encryptPassword(String str){
        Stack<Character> characterStack = new Stack<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            characterStack.push(str.charAt(i));
            if (characterStack.size() == key){
                for (int j = 0; j < key; j++) {
                    stringBuilder.append(characterStack.pop());
                }
            }
        }
        while (!characterStack.empty()){
            stringBuilder.append(characterStack.pop());
        }
        return stringBuilder.toString();
    }
}
