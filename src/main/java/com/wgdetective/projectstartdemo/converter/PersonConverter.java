package com.wgdetective.projectstartdemo.converter;

import com.wgdetective.projectstartdemo.dbo.PersonDbo;
import com.wgdetective.projectstartdemo.dto.PersonDto;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * @author Wladimir Litvinov
 */
@Service
public class PersonConverter implements DtoDboConverter<PersonDto, PersonDbo> {
    @Override
    public PersonDto convertToDto(final PersonDbo dbo) {
        final PersonDto personDto = new PersonDto();
        BeanUtils.copyProperties(dbo, personDto);
        return personDto;
    }

    @Override
    public PersonDbo convertToDbo(final PersonDto dto) {
        final PersonDbo personDbo = new PersonDbo();
        BeanUtils.copyProperties(dto, personDbo);
        return personDbo;
    }
}
