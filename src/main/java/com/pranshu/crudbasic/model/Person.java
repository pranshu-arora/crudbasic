package com.pranshu.crudbasic.model;

import jakarta.persistence.*;

@Entity
@Table(name="person_details")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // This will generate an auto-incrementing ID
    private Long PersonID;
    private String PersonName;
    private String PersonDepartment;

    public Person() {
    }

    public Person(Long personID, String personName, String personDepartment) {
        PersonID = personID;
        PersonName = personName;
        PersonDepartment = personDepartment;
    }

    public Long getPersonID() {
        return PersonID;
    }

    public void setPersonID(Long personID) {
        PersonID = personID;
    }

    public String getPersonName() {
        return PersonName;
    }

    public void setPersonName(String personName) {
        PersonName = personName;
    }

    public String getPersonDepartment() {
        return PersonDepartment;
    }

    public void setPersonDepartment(String personDepartment) {
        PersonDepartment = personDepartment;
    }
}
