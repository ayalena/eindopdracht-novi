package com.eindproject.v4.repository;

import com.eindproject.v4.model.Appointment;
import org.springframework.data.repository.CrudRepository;

public interface AppointmentRepository extends CrudRepository <Appointment, Long> {

}
