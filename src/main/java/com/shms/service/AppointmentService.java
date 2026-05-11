package com.shms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shms.model.Appointment;
import com.shms.repository.AppointmentRepository;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository repo;

    // SAVE
    public Appointment saveAppointment(
            Appointment a){

        return repo.save(a);
    }

    // GET ALL
    public List<Appointment> getAllAppointments(){

        return repo.findAll();
    }

    // DELETE
    public void deleteAppointment(int id){

        repo.deleteById(id);
    }

    // UPDATE
    public Appointment updateAppointment(
            int id,
            Appointment a){

        Appointment oldAppointment =
                repo.findById(id).orElse(null);

        if(oldAppointment != null){

            oldAppointment.setAppointmentDate(
                    a.getAppointmentDate());

            oldAppointment.setPatient(
                    a.getPatient());

            oldAppointment.setDoctor(
                    a.getDoctor());

            return repo.save(oldAppointment);
        }

        return null;
    }

}