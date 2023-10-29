package ru.homework.hibernate.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.homework.hibernate.entity.Persons;
import ru.homework.hibernate.repository.DBPersonsRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class DBService {
    private DBPersonsRepository repository;

    public List<Persons> getPersonsByCity(String city) {
        return repository.findPersonByCityOfLiving(city);
    }

    public List<Persons> getPersonsByAge(int age) {
        return repository.findPersonsByPersonIdAgeLessThanOrderByPersonIdAge(age);
    }

    public List<Persons> getPersonByNameAndSurname(String name, String surname) {
        return repository.findByPersonIdNameAndPersonIdSurname(name, surname);
    }

    public String getPhoneByName(String name) {
        return repository.findPhoneNumberByName(name);
    }
}
