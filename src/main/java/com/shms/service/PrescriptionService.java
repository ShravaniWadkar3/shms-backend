package com.shms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shms.model.Prescription;
import com.shms.repository.PrescriptionRepository;

@Service
public class PrescriptionService {

    @Autowired
    private PrescriptionRepository repo;

    // Add Prescription
    public Prescription savePrescription(
            Prescription p) {

        return repo.save(p);
    }

    // Get All Prescriptions
    public List<Prescription> getAllPrescriptions() {

        return repo.findAll();
    }

    // Delete Prescription
    public void deletePrescription(int id) {

        repo.deleteById(id);
    }

    // Update Prescription
    public Prescription updatePrescription(
            int id,
            Prescription newPrescription) {

        Prescription oldPrescription =
                repo.findById(id).orElse(null);

        if(oldPrescription != null) {

            oldPrescription.setPatientId(
                    newPrescription.getPatientId());

            oldPrescription.setDoctorId(
                    newPrescription.getDoctorId());

            oldPrescription.setMedicines(
                    newPrescription.getMedicines());

            oldPrescription.setNotes(
                    newPrescription.getNotes());

            return repo.save(oldPrescription);
        }

        return null;
    }

}