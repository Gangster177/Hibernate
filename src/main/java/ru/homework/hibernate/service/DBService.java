package ru.homework.hibernate.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.homework.hibernate.entity.Persons;
import ru.homework.hibernate.repository.DBRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class DBService {
    private DBRepository repository;

    public List<Persons> getPersonsByCity(String city){
        return repository.getPersonsByCity(city);
    }
}
