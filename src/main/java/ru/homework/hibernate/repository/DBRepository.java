package ru.homework.hibernate.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import ru.homework.hibernate.entity.Persons;

import java.util.List;

@Repository
public class DBRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Persons> getPersonsByCity(String city){
        // Сделать это можно, например, получив всех пользователей и отфильтровав их по городу.
        return entityManager.createQuery(
                "select p from Persons p where p.cityOfLiving =:city")
                .setParameter("city", city)
                .getResultList();

    }
}
