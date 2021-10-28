package com.eindproject.v4.controllers;

import com.eindproject.v4.exceptions.RecordNotFoundException;
import com.eindproject.v4.model.Appointment;
import com.eindproject.v4.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class AppointmentsController {

//    private static List<Appointment> appointments = new ArrayList<>();



    @Autowired
    private AppointmentRepository appointmentRepository;

    @GetMapping("/appointments")
    public ResponseEntity<Object> getAppointments() {
        Iterable<Appointment> appointments;
        appointments = appointmentRepository.findAll();
        return ResponseEntity.ok(appointments);
    }

    @GetMapping("/appointments/{id}")
    public ResponseEntity<Object> getAppointment(@PathVariable long id) {
        try {
            Optional<Appointment> appointment;
            appointment= appointmentRepository.findById(id);
            return ResponseEntity.ok(appointment);
        } catch (Exception ex) {
            throw new RecordNotFoundException();
        }
    }

    @PostMapping("/appointments")
    public ResponseEntity<Object> addAppointment(@RequestBody Appointment appointment) {
        appointmentRepository.save(appointment);
        return ResponseEntity.ok("Appointment created");
    }

    @DeleteMapping("/appointments/{id}")
    public ResponseEntity<Object> deleteAppointment(@PathVariable long id) {
        try {
            appointmentRepository.deleteById(id);
            return ResponseEntity.ok("Appointment deleted");
        } catch (Exception ex) {
            throw new RecordNotFoundException();
        }
    }

//    @PutMapping("/appointments/{id}")
//    public ResponseEntity<Object> updateAppointment(@PathVariable long id, @RequestBody Appointment appointment) {
//        try {
//            appointments.set(id, appointment);
//            return ResponseEntity.ok("Appointment X updated");
//        } catch (Exception ex) {
//            throw new RecordNotFoundException();
//        }
//    }

//    @PatchMapping("/appointments/{id}")
//    public ResponseEntity<Object> modifyAppointmentByDate(@PathVariable int id, @RequestBody Appointment date) {
//        appointments.set(id, date);
//        return ResponseEntity.ok("Appointment X updated to new date");
//    }

//    @PatchMapping("/appointments/{id}")
//    public ResponseEntity<Object> modifyAppointmentByTime(@PathVariable int id, @RequestBody Appointment time) {
//        appointments.set(id, time);
//        return ResponseEntity.ok("Appointment X updated to new time");
//    }

//    @GetMapping("/appointments?date={date}")
//    public ResponseEntity<Object> getAllAppointmentsByDate(@RequestParam String appointment, @RequestBody Appointment date) {
//        return ResponseEntity.ok(appointments);
////        return ResponseEntity.ok("All Appointments for date X");
//    }

}
