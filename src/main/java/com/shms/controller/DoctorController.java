package com.shms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.shms.model.Doctor;
import com.shms.service.DoctorService;

@RestController
@CrossOrigin("*")
public class DoctorController {

    @Autowired
    private DoctorService service;

    // ADD DOCTOR
    @PostMapping("/doctors")
    public Doctor addDoctor(
            @RequestBody Doctor d){

        return service.saveDoctor(d);
    }

    // GET ALL DOCTORS
    @GetMapping("/doctors")
    public List<Doctor> getDoctors(){

        return service.getAllDoctors();
    }

    // DELETE DOCTOR
    @DeleteMapping("/doctors/{id}")
    public String deleteDoctor(
            @PathVariable int id){

        service.deleteDoctor(id);

        return "Doctor Deleted";
    }

    // UPDATE DOCTOR
    @PutMapping("/doctors/{id}")
    public Doctor updateDoctor(
            @PathVariable int id,
            @RequestBody Doctor d){

        return service.updateDoctor(id, d);
    }

    // SEARCH DOCTOR
    @GetMapping("/doctors/search/{specialization}")
    public List<Doctor> searchDoctor(
            @PathVariable String specialization){

        return service.searchDoctor(
                specialization);
    }

}