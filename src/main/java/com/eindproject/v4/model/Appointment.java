package com.eindproject.v4.model;

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

    //getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

}
