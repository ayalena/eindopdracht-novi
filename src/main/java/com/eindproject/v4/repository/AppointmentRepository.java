package com.eindproject.v4.repository;

import com.eindproject.v4.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface AppointmentRepository extends JpaRepository <Appointment, Long> {

    Iterable<Appointment> findAllByDateOfAppointment(String dateOfAppointment);
//    Iterable<Appointment> findAllAvailableAppointments();
}
