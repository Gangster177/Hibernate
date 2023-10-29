package ru.homework.hibernate.controller;

import lombok.AllArgsConstructor;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ru.homework.hibernate.entity.Persons;
import ru.homework.hibernate.service.DBService;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@AllArgsConstructor
@RestController
public class DBController {
    private DBService service;

    @Secured({"ROLE_READ"})
    @GetMapping("/persons/by-city")
    @ResponseBody
    public List<Persons> getPersonByCity(@RequestParam("city") String city) {
        return service.getPersonsByCity(city);
    }

    @RolesAllowed({"ROLE_WRITE"})
    @GetMapping("/persons/by-age")
    @ResponseBody
    public List<Persons> getPersonByAge(@RequestParam("age") int age) {
        return service.getPersonsByAge(age);
    }

    @PreAuthorize("hasAnyRole('ROLE_WRITE', 'ROLE_READ')")
    @GetMapping("/persons/by-name")
    @ResponseBody
    public List<Persons> getPersonByAge(
            @RequestParam("name") String name,
            @RequestParam("surname") String surname
    ) {
        return service.getPersonByNameAndSurname(name, surname);
    }

    @PostAuthorize("#username == authentication.principal.username")
    @GetMapping("/persons/phone-by-name")
    @ResponseBody
    public String getPhoneNumberByName(String username) {
        return service.getPhoneByName(username);
    }

    @GetMapping("/persons")
    @PreAuthorize("hasAnyRole('ROLE_WRITE', 'ROLE_READ') and #username == authentication.principal.username")
    @ResponseBody
    public String greetingUser(String username) {
        return "Hi, " + username;
    }
}
