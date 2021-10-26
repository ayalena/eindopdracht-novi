package com.eindproject.v4.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AppointmentsController {

    @GetMapping("/appointments")
    public ResponseEntity<Object> getAppointments() {
        return ResponseEntity.ok("List of all Appointments");
    }

    @GetMapping("/appointments/{id}")
    public ResponseEntity<Object> getAppointment(@PathVariable long id) {
        return ResponseEntity.ok("Appointment X");
    }

    @PostMapping("/appointments")
    public ResponseEntity<Object> addAppointment(@RequestBody String date, @RequestBody String time) {

//        return ResponseEntity.created();
        return ResponseEntity.ok("Appointment created");
    }

    @DeleteMapping("/appointments/{id}")
    public ResponseEntity<Object> deleteAppointment(@PathVariable long id) {

//        return ResponseEntity.noContent();
        return ResponseEntity.ok("Appointment deleted");

    }

    @PutMapping("/appointments/{id}")
    public ResponseEntity<Object> updateAppointment(@PathVariable long id, @RequestBody String date, @RequestBody String time) {

//        return ResponseEntity.noContent();
        return ResponseEntity.ok("Appointment X updated");
    }

    @PatchMapping("/appointments/{id}")
    public ResponseEntity<Object> modifyAppointmentByDate(@PathVariable long id, @RequestBody String date) {

//        return ResponseEntity.noContent();
        return ResponseEntity.ok("Appointment X updated to new date");
    }

    @PatchMapping("/books/{id}")
    public ResponseEntity<Object> modifyAppointmentByTime(@PathVariable long id, @RequestBody String time) {

//        return ResponseEntity.noContent();
        return ResponseEntity.ok("Appointment X updated to new time");
    }

    @GetMapping("/appointments?date={date}")
    public ResponseEntity<Object> getAllAppointmentsByDate(@RequestParam String date) {
        return ResponseEntity.ok("All Appointments for date X");
    }

}
