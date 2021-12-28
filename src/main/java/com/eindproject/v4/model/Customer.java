package com.eindproject.v4.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity(name = "customers")
public class Customer {

    //attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String firstName;
    public String lastName;
    public String email;


    //relations
//    @OneToMany(
////            mappedBy = "customer",
//            fetch = FetchType.LAZY,
//            cascade = CascadeType.MERGE)
//    @JsonBackReference
//    private List<Appointment> appointments;



    //getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
