package com.shms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shms.model.Billing;
import com.shms.repository.BillingRepository;

@Service
public class BillingService {

    @Autowired
    private BillingRepository repo;

    // Save Bill
    public Billing saveBill(Billing b) {

        b.setTotalAmount(
                b.getConsultationFee()
                + b.getMedicineFee());

        return repo.save(b);
    }

    // Get All Bills
    public List<Billing> getAllBills() {

        return repo.findAll();
    }

    // Delete Bill
    public void deleteBill(int id) {

        repo.deleteById(id);
    }

    // Update Bill
    public Billing updateBill(int id,
                              Billing newBill) {

        Billing oldBill =
                repo.findById(id).orElse(null);

        if(oldBill != null) {

            oldBill.setPatientId(
                    newBill.getPatientId());

            oldBill.setConsultationFee(
                    newBill.getConsultationFee());

            oldBill.setMedicineFee(
                    newBill.getMedicineFee());

            oldBill.setTotalAmount(
                    newBill.getConsultationFee()
                    + newBill.getMedicineFee());

            oldBill.setPaymentStatus(
                    newBill.getPaymentStatus());

            return repo.save(oldBill);
        }

        return null;
    }

}