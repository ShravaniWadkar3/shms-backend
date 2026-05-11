package com.shms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shms.model.Billing;

public interface BillingRepository
extends JpaRepository<Billing, Integer>{

}