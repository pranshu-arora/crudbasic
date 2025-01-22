package com.pranshu.crudbasic.repository;

import com.pranshu.crudbasic.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}

