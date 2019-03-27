package com.wgdetective.projectstartdemo.controller;

import com.wgdetective.projectstartdemo.dto.PersonDto;
import com.wgdetective.projectstartdemo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Wladimir Litvinov
 */
@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(final PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/create")
    public String createPerson(@RequestBody final PersonDto personDto) {
        personService.createPerson(personDto);
        return "Person created";
    }

    @GetMapping("/list")
    public List<PersonDto> getAllPersons() {
        return personService.getPersonsList();
    }
}
