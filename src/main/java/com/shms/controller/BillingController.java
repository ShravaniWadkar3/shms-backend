package com.shms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.shms.model.Billing;
import com.shms.service.BillingService;

@RestController
@CrossOrigin("*")
public class BillingController {

    @Autowired
    private BillingService service;

    // Add Bill
    @PostMapping("/billing")
    public Billing addBill(@RequestBody Billing b) {

        return service.saveBill(b);
    }

    // Get All Bills
    @GetMapping("/billing")
    public List<Billing> getBills() {

        return service.getAllBills();
    }

    // Delete Bill
    @DeleteMapping("/billing/{id}")
    public String deleteBill(@PathVariable int id) {

        service.deleteBill(id);

        return "Bill Deleted Successfully";
    }

    // Update Bill
    @PutMapping("/billing/{id}")
    public Billing updateBill(
            @PathVariable int id,
            @RequestBody Billing b) {

        return service.updateBill(id, b);
    }

}