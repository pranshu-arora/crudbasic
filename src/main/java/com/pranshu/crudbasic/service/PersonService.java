package com.pranshu.crudbasic.service;

import com.pranshu.crudbasic.model.Person;

import java.util.List;

public interface PersonService {
    String createPerson(Person person);
    void updatePersonDetails(Long PersonID, Person updatedPersonDetails);
    String deletePerson(Long PersonID);
    Person getPerson(Long PersonID);
    List<Person> getAllPerson();
}
