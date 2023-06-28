package com.owl.hrpayroll.services;

import org.springframework.stereotype.Service;

import com.owl.hrpayroll.entities.Payment;

@Service
public class PaymentService {

	public Payment getPayment(long workerId, int days) {
		return new Payment("Felipe", 200.0, days);
	}
	
}
