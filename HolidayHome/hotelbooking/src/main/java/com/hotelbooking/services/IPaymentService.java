package com.hotelbooking.services;
import java.util.*;

import com.hotelbooking.entity.Payment;
public interface IPaymentService {
List<Payment> getAllPayments();
Payment getPaymentById(Long id);
Payment savePayment(Payment payment);
void deletePayment(Long id);
}
