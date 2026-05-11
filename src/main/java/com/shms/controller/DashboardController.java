package com.shms.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.shms.repository.AppointmentRepository;
import com.shms.repository.BillingRepository;
import com.shms.repository.DoctorRepository;
import com.shms.repository.PatientRepository;

@RestController
@CrossOrigin("*")
public class DashboardController {

    @Autowired
    private PatientRepository patientRepo;

    @Autowired
    private DoctorRepository doctorRepo;

    @Autowired
    private AppointmentRepository appointmentRepo;

    @Autowired
    private BillingRepository billingRepo;

    @GetMapping("/dashboard")
    public Map<String, Object> getDashboardData(){

        Map<String, Object> data =
                new HashMap<>();

        data.put("totalPatients",
                patientRepo.count());

        data.put("totalDoctors",
                doctorRepo.count());

        data.put("totalAppointments",
                appointmentRepo.count());

        double revenue = billingRepo.findAll()
                .stream()
                .mapToDouble(b -> b.getTotalAmount())
                .sum();

        data.put("totalRevenue", revenue);

        return data;
    }

}