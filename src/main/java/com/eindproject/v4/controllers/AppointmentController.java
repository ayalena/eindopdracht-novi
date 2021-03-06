package com.eindproject.v4.controllers;

import com.eindproject.v4.exceptions.RecordNotFoundException;
import com.eindproject.v4.model.Appointment;
import com.eindproject.v4.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @GetMapping("/appointments")
    public ResponseEntity<Object> getAppointments() {
        Iterable<Appointment> appointments = appointmentService.findAll();
        return ResponseEntity.ok(appointments);
    }

    @GetMapping("/appointments/{id}")
    public ResponseEntity<Object> getAppointment(@PathVariable long id) {
        Optional<Appointment> appointment = appointmentService.findById(id);
        return ResponseEntity.ok(appointment);
    }

    @PostMapping("/appointments")
    public ResponseEntity<Object> createAppointment(@RequestBody Appointment appointment) {
        appointmentService.addAppointment(appointment);
        return ResponseEntity.ok("Appointment created");
    }

    @DeleteMapping("/appointments/{id}")
    public ResponseEntity<Object> deleteAppointment(@PathVariable long id) {
        appointmentService.deleteAppointment(id);
        return ResponseEntity.ok("Appointment deleted");
    }

    @PutMapping("/appointments/{id}")
    public ResponseEntity<Object> updateAppointment(@PathVariable long id, @RequestBody Appointment appointment) {
        appointmentService.updateAppointment(id, appointment);
        return ResponseEntity.ok("Appointment X updated");
    }

    @GetMapping("/appointments/{date}")
    public ResponseEntity<Object> getAllAppointmentsByDate(@PathVariable String date) {
        Iterable<Appointment> appointments = appointmentService.findAllByDate(date);
        return ResponseEntity.ok(appointments);
//        return ResponseEntity.ok("All Appointments for date X");
    }

    //for customer
    @PutMapping("/appointments/{id}/reserve")
    public ResponseEntity<Object> makeAppointment(@PathVariable long id) {
        appointmentService.makeAppointment(id);
        return ResponseEntity.ok("Appointment X reserved");
    }

    @PutMapping("/appointments/{id}/cancel")
    public ResponseEntity<Object> cancelAppointment(@PathVariable long id) {
        appointmentService.cancelAppointment(id);
        return ResponseEntity.ok("Appointment X cancelled");
    }

}
