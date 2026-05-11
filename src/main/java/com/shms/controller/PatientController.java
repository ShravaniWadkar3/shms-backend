package com.shms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.shms.model.Patient;
import com.shms.service.PatientService;

@RestController
@CrossOrigin("*")
public class PatientController {

    @Autowired
    private PatientService service;

    @PostMapping("/patients")
    public Patient addPatient(
            @RequestBody Patient p){

        return service.savePatient(p);
    }

    @GetMapping("/patients")
    public List<Patient> getPatients(){

        return service.getAllPatients();
    }

    @DeleteMapping("/patients/{id}")
    public String deletePatient(
            @PathVariable int id){

        service.deletePatient(id);

        return "Patient Deleted";
    }

}