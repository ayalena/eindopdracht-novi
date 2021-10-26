package com.eindproject.v4.service;

import com.eindproject.v4.model.Appointment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {

    private AppointmentService ListOfAppointments;

    public List<Appointment> getAppointments() {

        return ListOfAppointments.getAppointments();
    }

    public Appointment getAppointment(long id) {
        Appointment appointmentFound = ListOfAppointments.getAppointment(id);
        return appointmentFound;
    }

}
