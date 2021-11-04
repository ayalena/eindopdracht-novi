package com.eindproject.v4.model;

import javax.persistence.*;

@Entity(name = "appointments")
public class Appointment {

    //attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;

    @Column(length = 80)
    public String dateOfAppointment;

    @Column(length = 6)
    public String timeOfAppointment;

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

    public String getDateOfAppointment() {
        return dateOfAppointment;
    }

    public void setDateOfAppointment(String dateOfAppointment) {
        this.dateOfAppointment = dateOfAppointment;
    }

    public String getTimeOfAppointment() {
        return timeOfAppointment;
    }

    public void setTimeOfAppointment(String timeOfAppointment) {
        this.timeOfAppointment = timeOfAppointment;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

}
