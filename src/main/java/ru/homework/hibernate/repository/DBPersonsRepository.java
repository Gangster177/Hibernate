package ru.homework.hibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.homework.hibernate.entity.PersonId;
import ru.homework.hibernate.entity.Persons;

import java.util.List;

@Repository
public interface DBPersonsRepository extends JpaRepository<Persons, PersonId> {
    @Query("select p from Persons p where p.cityOfLiving = :cityOfLiving")
    List<Persons> findPersonByCityOfLiving(@Param("cityOfLiving")String cityOfLiving);

    @Query("select p from Persons p where p.personId.age < :age order by p.personId.age")
    List<Persons> findPersonsByPersonIdAgeLessThanOrderByPersonIdAge(@Param("age")int age);

    @Query("select p from Persons p where p.personId.name = :name and p.personId.surname = :surname")
    List<Persons> findByPersonIdNameAndPersonIdSurname(String name, String surname);

    @Query("select p.phoneNumber from Persons p where p.personId.name = :name")
    String findPhoneNumberByName(String name);
}
