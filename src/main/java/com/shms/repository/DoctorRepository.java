package com.shms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shms.model.Doctor;

public interface DoctorRepository
extends JpaRepository<Doctor, Integer>{

    List<Doctor> findBySpecializationContaining(
            String specialization);

}