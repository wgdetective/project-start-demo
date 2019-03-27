package com.wgdetective.projectstartdemo.service;

import com.wgdetective.projectstartdemo.MockData;
import com.wgdetective.projectstartdemo.converter.PersonConverter;
import com.wgdetective.projectstartdemo.dbo.PersonDbo;
import com.wgdetective.projectstartdemo.dto.PersonDto;
import com.wgdetective.projectstartdemo.repository.PersonRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * @author Wladimir Litvinov
 */
@RunWith(MockitoJUnitRunner.class)
public class PersonServiceTest {
    @InjectMocks
    private PersonService personService;

    @Mock
    private PersonRepository personRepository;
    @Spy
    private PersonConverter personConverter;

    @Test
    public void createPerson() {
        final PersonDbo personDbo = new PersonDbo();
        personDbo.setFirstName("first");
        personDbo.setLastName("last");

        doReturn(personDbo).when(personRepository).save(any(PersonDbo.class));

        personService.createPerson(new PersonDto());

        verify(personRepository, times(1)).save(any(PersonDbo.class));

    }

    @Test
    public void getPersonsList() {
        final List<PersonDbo> findAllResult = new ArrayList<>();
        final PersonDbo personDbo = MockData.personDbo();
        findAllResult.add(personDbo);
        findAllResult.add(personDbo);
        doReturn(findAllResult).when(personRepository).findAll();

        final List<PersonDto> personsList = personService.getPersonsList();

        verify(personRepository, times(1)).findAll();
        assertEquals(findAllResult.size(), personsList.size());
        for (final PersonDto personDto : personsList) {
            assertEquals(personDbo.getFirstName(), personDto.getFirstName());
            assertEquals(personDbo.getLastName(), personDto.getLastName());
        }

    }
}