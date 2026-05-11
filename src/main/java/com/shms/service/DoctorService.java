package com.shms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shms.model.Doctor;
import com.shms.repository.DoctorRepository;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository repo;

    // SAVE
    public Doctor saveDoctor(Doctor d){

        return repo.save(d);
    }

    // GET ALL
    public List<Doctor> getAllDoctors(){

        return repo.findAll();
    }

    // DELETE
    public void deleteDoctor(int id){

        repo.deleteById(id);
    }

    // UPDATE
    public Doctor updateDoctor(
            int id,
            Doctor d){

        Doctor oldDoctor =
                repo.findById(id).orElse(null);

        if(oldDoctor != null){

            oldDoctor.setName(d.getName());

            oldDoctor.setSpecialization(
                    d.getSpecialization());

            return repo.save(oldDoctor);
        }

        return null;
    }

    // SEARCH
    public List<Doctor> searchDoctor(
            String specialization){

        return repo.findBySpecializationContaining(
                specialization);
    }

}