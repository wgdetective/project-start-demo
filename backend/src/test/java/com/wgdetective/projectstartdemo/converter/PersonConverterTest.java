package com.wgdetective.projectstartdemo.converter;

import com.wgdetective.projectstartdemo.MockData;
import com.wgdetective.projectstartdemo.dbo.PersonDbo;
import com.wgdetective.projectstartdemo.dto.PersonDto;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Wladimir Litvinov
 */
public class PersonConverterTest {

    private final PersonConverter personConverter = new PersonConverter();

    @Test
    public void convertToDto() {
        final PersonDbo personDbo = MockData.personDbo();
        final PersonDto personDto = personConverter.convertToDto(personDbo);
        assertEquals(personDbo.getFirstName(), personDto.getFirstName());
        assertEquals(personDbo.getLastName(), personDto.getLastName());
    }

    @Test
    public void convertToDbo() {
        final PersonDto personDto = MockData.personDto();
        final PersonDbo personDbo = personConverter.convertToDbo(personDto);
        assertEquals(personDto.getFirstName(), personDbo.getFirstName());
        assertEquals(personDto.getLastName(), personDbo.getLastName());
    }

}