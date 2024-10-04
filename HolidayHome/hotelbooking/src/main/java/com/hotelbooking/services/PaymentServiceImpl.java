package com.hotelbooking.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelbooking.entity.Payment;
import com.hotelbooking.repo.IPaymentRepo;

@Service
public class PaymentServiceImpl implements IPaymentService {

	 @Autowired
	    private IPaymentRepo paymentRepository;

	    public List<Payment> getAllPayments() {
	        return paymentRepository.findAll();
	    }

	    public Payment getPaymentById(Long id) {
	        return paymentRepository.findById(id).orElse(null);
	    }

	    public Payment savePayment(Payment payment) {
	        return paymentRepository.save(payment);
	    }

	    public void deletePayment(Long id) {
	        paymentRepository.deleteById(id);
	    }

}
