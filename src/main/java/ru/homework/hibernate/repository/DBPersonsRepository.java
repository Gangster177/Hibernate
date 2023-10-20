package ru.homework.hibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.homework.hibernate.entity.PersonId;
import ru.homework.hibernate.entity.Persons;

import java.util.List;

@Repository
public interface DBPersonsRepository extends JpaRepository<Persons, PersonId> {
    List<Persons> findPersonByCityOfLiving(String city);

    List<Persons> findPersonsByPersonIdAgeLessThanOrderByPersonIdAge(int age);

    List<Persons> findByPersonIdNameAndPersonIdSurname(String name, String surname);
}