package com.eindproject.v4.controllers;

import com.eindproject.v4.exceptions.RecordNotFoundException;
import com.eindproject.v4.model.Appointment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AppointmentsController {

    private static List<Appointment> appointments = new ArrayList<>();

    @GetMapping("/appointments")
    public ResponseEntity<Object> getAppointments() {
        return ResponseEntity.ok(appointments);
    }

    @GetMapping("/appointments/{id}")
    public ResponseEntity<Object> getAppointment(@PathVariable int id) {
        try {
            return ResponseEntity.ok(appointments.get(id));
        } catch (Exception ex) {
            throw new RecordNotFoundException();
        }
    }

    @PostMapping("/appointments")
    public ResponseEntity<Object> addAppointment(@RequestBody Appointment appointment) {
        appointments.add(appointment);
        return ResponseEntity.ok("Appointment created");
    }

    @DeleteMapping("/appointments/{id}")
    public ResponseEntity<Object> deleteAppointment(@PathVariable int id) {
        try {
            appointments.remove(id);
            return ResponseEntity.ok("Appointment deleted");
        } catch (Exception ex) {
            throw new RecordNotFoundException();
        }
    }

    @PutMapping("/appointments/{id}")
    public ResponseEntity<Object> updateAppointment(@PathVariable int id, @RequestBody Appointment appointment) {
        try {
            appointments.set(id, appointment);
            return ResponseEntity.ok("Appointment X updated");
        } catch (Exception ex) {
            throw new RecordNotFoundException();
        }
    }

    @PatchMapping("/appointments/{id}")
    public ResponseEntity<Object> modifyAppointmentByDate(@PathVariable int id, @RequestBody Appointment date) {
        appointments.set(id, date);
        return ResponseEntity.ok("Appointment X updated to new date");
    }

    @PatchMapping("/appointments/{id}")
    public ResponseEntity<Object> modifyAppointmentByTime(@PathVariable int id, @RequestBody Appointment time) {
        appointments.set(id, time);
        return ResponseEntity.ok("Appointment X updated to new time");
    }

    @GetMapping("/appointments?date={date}")
    public ResponseEntity<Object> getAllAppointmentsByDate(@RequestParam String appointment, @RequestBody Appointment date) {
        return ResponseEntity.ok(appointments);
//        return ResponseEntity.ok("All Appointments for date X");
    }

}
