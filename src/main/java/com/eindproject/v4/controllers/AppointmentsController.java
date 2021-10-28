package com.eindproject.v4.controllers;

import com.eindproject.v4.model.Appointment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AppointmentsController {

    private static List<String> appointments = new ArrayList<>();

    @GetMapping("/appointments")
    public ResponseEntity<Object> getAppointments() {
        return ResponseEntity.ok(appointments);
    }

    @GetMapping("/appointments/{id}")
    public ResponseEntity<Object> getAppointment(@PathVariable int id) {
        return ResponseEntity.ok(appointments.get(id));
    }

    @PostMapping("/appointments")
    public ResponseEntity<Object> addAppointment(@RequestBody String appointment) {
        appointments.add(appointment);
        return ResponseEntity.ok("Appointment created");
    }

    @DeleteMapping("/appointments/{id}")
    public ResponseEntity<Object> deleteAppointment(@PathVariable int id) {
        appointments.remove(id);
        return ResponseEntity.ok("Appointment deleted");
    }

    @PutMapping("/appointments/{id}")
    public ResponseEntity<Object> updateAppointment(@PathVariable int id, @RequestBody String appointment) {
        appointments.set(id, appointment);
        return ResponseEntity.ok("Appointment X updated");
    }

    @PatchMapping("/appointments/{id}")
    public ResponseEntity<Object> modifyAppointmentByDate(@PathVariable long id, @RequestBody String date) {
        return ResponseEntity.ok("Appointment X updated to new date");
    }

    @PatchMapping("/books/{id}")
    public ResponseEntity<Object> modifyAppointmentByTime(@PathVariable long id, @RequestBody String time) {
        return ResponseEntity.ok("Appointment X updated to new time");
    }

    @GetMapping("/appointments?date={date}")
    public ResponseEntity<Object> getAllAppointmentsByDate(@RequestParam String date) {
        return ResponseEntity.ok("All Appointments for date X");
    }

}
