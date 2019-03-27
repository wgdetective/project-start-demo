package com.wgdetective.projectstartdemo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Wladimir Litvinov
 */
@Data
@NoArgsConstructor
public class PersonDto {
    private Long id;
    private String firstName;
    private String lastName;
}
