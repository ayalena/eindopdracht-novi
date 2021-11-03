package com.eindproject.v4.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity(name = "appointments")
public class Appointment {

    //attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;

    @Column(length = 80)
    public String date;

    @Column(length = 6)
    public String time;

    @Column
    public Boolean available;

    //relations
    @ManyToOne(
            fetch = FetchType.EAGER,
            optional = true)
    @JoinColumn(
            name = "customer_id",
            nullable = true)
//    @JsonManagedReference
//    private Customer customer;


    //getters and setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

}
