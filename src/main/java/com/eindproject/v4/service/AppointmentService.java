package com.eindproject.v4.service;

import com.eindproject.v4.model.Appointment;
import com.eindproject.v4.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppointmentService {

    @Autowired
    AppointmentRepository appointmentRepository;

    public Iterable<Appointment> findAll() {
        Iterable<Appointment> appointments = appointmentRepository.findAll();
        return appointments;
    }

    public Optional<Appointment> findById(long id) {
        Optional<Appointment> appointment= appointmentRepository.findById(id);
        return appointment;
    }

    public long addAppointment(Appointment appointment) {
        Appointment newAppointment = appointmentRepository.save(appointment);
        return newAppointment.getId();
    }

    public void deleteAppointment(long id) {
       appointmentRepository.deleteById(id);
    }

    public void updateAppointment(long id, Appointment newAppointment) {
        Appointment appointment = appointmentRepository.findById(id).get();
        appointment.setDate(newAppointment.getDate());
        appointment.setTime(newAppointment.getTime());
        appointmentRepository.save(appointment);
    }
}
