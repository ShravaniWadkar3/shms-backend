package com.shms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shms.model.Prescription;

public interface PrescriptionRepository
extends JpaRepository<Prescription, Integer>{

}