package com.wgdetective.projectstartdemo.service;

import com.wgdetective.projectstartdemo.converter.PersonConverter;
import com.wgdetective.projectstartdemo.dto.PersonDto;
import com.wgdetective.projectstartdemo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Wladimir Litvinov
 */
@Service
public class PersonService {

    private final PersonRepository personRepository;
    private final PersonConverter personConverter;

    @Autowired
    public PersonService(final PersonRepository personRepository, final PersonConverter personConverter) {
        this.personRepository = personRepository;
        this.personConverter = personConverter;
    }

    public void createPerson(final PersonDto personDto) {
        personRepository.save(personConverter.convertToDbo(personDto));
    }

    public List<PersonDto> getPersonsList() {
        return personRepository.findAll().stream().map(personConverter::convertToDto).collect(Collectors.toList());
    }
}
