package com.eindproject.v4.service;

import com.eindproject.v4.model.Appointment;

import java.util.Optional;

public interface AppointmentServiceInterface {

    Iterable<Appointment> findAll();
    Optional<Appointment> findById(long id);
    long addAppointment(Appointment appointment);
    void deleteAppointment(long id);
    void updateAppointment(long id, Appointment newAppointment);

}
