package com.wgdetective.projectstartdemo.repository;

import com.wgdetective.projectstartdemo.dbo.PersonDbo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Wladimir Litvinov
 */
public interface PersonRepository extends JpaRepository<PersonDbo, Long> {
}
