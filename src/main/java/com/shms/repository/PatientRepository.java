package com.shms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shms.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer>{

    List<Patient> findByNameContaining(String name);

}