package com.hotelbooking.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotelbooking.entity.Payment;

public interface IPaymentRepo extends JpaRepository<Payment, Long>{

}
