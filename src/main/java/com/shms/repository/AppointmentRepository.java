package com.shms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shms.model.Appointment;

public interface AppointmentRepository
extends JpaRepository<Appointment, Integer>{

}