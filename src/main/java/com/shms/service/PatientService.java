package com.shms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shms.model.Patient;
import com.shms.repository.PatientRepository;

@Service
public class PatientService {

    @Autowired
    private PatientRepository repo;

    public Patient savePatient(Patient p){

        return repo.save(p);
    }

    public List<Patient> getAllPatients(){

        return repo.findAll();
    }

    public void deletePatient(int id){

        repo.deleteById(id);
    }

}