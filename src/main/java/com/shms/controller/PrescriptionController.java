package com.shms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.shms.model.Prescription;
import com.shms.service.PrescriptionService;

@RestController
@CrossOrigin("*")
public class PrescriptionController {

    @Autowired
    private PrescriptionService service;

    // Add Prescription
    @PostMapping("/prescriptions")
    public Prescription addPrescription(
            @RequestBody Prescription p) {

        return service.savePrescription(p);
    }

    // Get All Prescriptions
    @GetMapping("/prescriptions")
    public List<Prescription> getPrescriptions() {

        return service.getAllPrescriptions();
    }

    // Delete Prescription
    @DeleteMapping("/prescriptions/{id}")
    public String deletePrescription(
            @PathVariable int id) {

        service.deletePrescription(id);

        return "Prescription Deleted Successfully";
    }

    // Update Prescription
    @PutMapping("/prescriptions/{id}")
    public Prescription updatePrescription(
            @PathVariable int id,
            @RequestBody Prescription p) {

        return service.updatePrescription(id, p);
    }

}