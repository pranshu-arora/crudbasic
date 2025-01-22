package com.pranshu.crudbasic.service.impl;

import com.pranshu.crudbasic.model.Person;
import com.pranshu.crudbasic.repository.PersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
        import static org.mockito.Mockito.*;

public class PersonServiceImplTest {

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonServiceImpl personService;

    private Person person;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this); // Initializes mock objects
        person = new Person();
        person.setPersonID(1L);
        person.setPersonName("B");
        person.setPersonDepartment("Engineering");
    }

    @Test
    public void testCreatePerson() {
        when(personRepository.save(any(Person.class))).thenReturn(person);
        String response = personService.createPerson(person);
        assertEquals("Success", response);
        verify(personRepository, times(1)).save(person);
    }

    @Test
    public void testGetPerson() {
        when(personRepository.findById(1L)).thenReturn(Optional.of(person));
        Person fetchedPerson = personService.getPerson(1L);
        assertNotNull(fetchedPerson);
        assertEquals(person.getPersonName(), fetchedPerson.getPersonName());
        verify(personRepository, times(1)).findById(1L);
    }

    @Test
    public void testUpdatePersonDetails() {
        when(personRepository.findById(1L)).thenReturn(Optional.of(person));
        Person updatedPerson = new Person();
        updatedPerson.setPersonName("B");
        updatedPerson.setPersonDepartment("HR");
        personService.updatePersonDetails(1L, updatedPerson);
        verify(personRepository, times(1)).save(person);
        assertEquals("B", person.getPersonName());
    }

    @Test
    public void testDeletePerson() {
        when(personRepository.findById(1L)).thenReturn(Optional.of(person));
        String response = personService.deletePerson(1L);
        assertEquals("Success", response);
        verify(personRepository, times(1)).deleteById(1L);
    }
}
