package com.pranshu.crudbasic.controller;

import com.pranshu.crudbasic.model.Person;
import com.pranshu.crudbasic.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/PersonDetails")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("{PersonID}")
    public ResponseEntity<Person> getPersonDetails(@PathVariable("PersonID") Long PersonID) {
        return ResponseEntity.ok(personService.getPerson(PersonID));
    }

    @GetMapping()
    public ResponseEntity<List<Person>> getAllPersonDetails() {
        return ResponseEntity.ok(personService.getAllPerson());
    }

    @PostMapping
    public ResponseEntity<String> createPersonDetails(@RequestBody Person person) {
        personService.createPerson(person);
        return ResponseEntity.status(HttpStatus.CREATED).body("Successfully CREATED PersonDetails");
    }

    @PutMapping("/{PersonID}")
    public ResponseEntity<String> updatePerson(@PathVariable Long PersonID, @RequestBody Person updatedPersonDetails) {
            personService.updatePersonDetails(PersonID, updatedPersonDetails);
            return ResponseEntity.ok("Successfully UPDATED Person Details");
    }


    @DeleteMapping("{PersonID}")
    public ResponseEntity<String> deletePersonDetails(@PathVariable("PersonID") Long PersonID) {
        personService.deletePerson(PersonID);
        return ResponseEntity.ok("Successfully DELETED PersonDetails");
    }
}
