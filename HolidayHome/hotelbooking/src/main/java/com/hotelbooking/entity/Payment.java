package com.hotelbooking.entity;



import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "payments")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    private double amount;
    
    private String method; // e.g., credit card, PayPal
    
    private LocalDateTime paymentDate;
    
    @OneToOne(mappedBy = "payment")
    private Booking booking;
}
