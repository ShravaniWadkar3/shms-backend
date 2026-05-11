package com.shms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.shms.model.Appointment;
import com.shms.service.AppointmentService;

@RestController
@CrossOrigin("*")
public class AppointmentController {

    @Autowired
    private AppointmentService service;

    // ADD APPOINTMENT
    @PostMapping("/appointments")
    public Appointment addAppointment(
            @RequestBody Appointment a){

        return service.saveAppointment(a);
    }

    // GET ALL APPOINTMENTS
    @GetMapping("/appointments")
    public List<Appointment> getAppointments(){

        return service.getAllAppointments();
    }

    // DELETE APPOINTMENT
    @DeleteMapping("/appointments/{id}")
    public String deleteAppointment(
            @PathVariable int id){

        service.deleteAppointment(id);

        return "Appointment Deleted Successfully";
    }

    // UPDATE APPOINTMENT
    @PutMapping("/appointments/{id}")
    public Appointment updateAppointment(
            @PathVariable int id,
            @RequestBody Appointment a){

        return service.updateAppointment(id, a);
    }

}