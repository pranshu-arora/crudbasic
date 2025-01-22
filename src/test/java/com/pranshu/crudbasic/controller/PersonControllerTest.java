package com.pranshu.crudbasic.controller;

import com.pranshu.crudbasic.model.Person;
import com.pranshu.crudbasic.service.PersonService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PersonController.class)
public class PersonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PersonService personService;

    private Person person;

    @BeforeEach
    public void setup() {
        person = new Person();
        person.setPersonID(1L);
        person.setPersonName("B");
        person.setPersonDepartment("HR");
    }

    @Test
    public void testGetPersonDetails() throws Exception {
        when(personService.getPerson(1L)).thenReturn(person);

        mockMvc.perform(get("/PersonDetails/{PersonID}", 1L))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.personName").value("B"))
                .andExpect(jsonPath("$.personDepartment").value("HR"));
    }

    @Test
    public void testCreatePersonDetails() throws Exception {
        Person newPerson = new Person();
        newPerson.setPersonName("B");
        newPerson.setPersonDepartment("HR");

        mockMvc.perform(post("/PersonDetails")
                        .contentType("application/json")
                        .content("{\"personName\":\"A\", \"personDepartment\":\"HR\"}"))
                .andExpect(status().isCreated())
                .andExpect(content().string("Successfully CREATED PersonDetails"));

        verify(personService, times(1)).createPerson(any(Person.class));
    }

    @Test
    public void testDeletePersonDetails() throws Exception {
        when(personService.deletePerson(1L)).thenReturn("Success");

        mockMvc.perform(delete("/PersonDetails/{PersonID}", 1L))
                .andExpect(status().isOk())
                .andExpect(content().string("Successfully DELETED PersonDetails"));

        verify(personService, times(1)).deletePerson(1L);
    }

}
