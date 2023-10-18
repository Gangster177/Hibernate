package ru.homework.hibernate.controller;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ru.homework.hibernate.entity.Persons;
import ru.homework.hibernate.service.DBService;

import java.util.List;

@AllArgsConstructor
@RestController
public class DBController {
    private DBService service;

    @GetMapping("/persons/by-city")
    @ResponseBody
    public List<Persons> getPersonByCity(@RequestParam("city") String city){
        return service.getPersonsByCity(city);
    }
}
