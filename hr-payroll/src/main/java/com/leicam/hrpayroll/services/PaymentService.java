package com.leicam.hrpayroll.services;

import org.springframework.stereotype.Service;

import com.leicam.hrpayroll.entities.Payment;

@Service
public class PaymentService {

	public Payment getPayment(long workerId, int days) {
		return new Payment("Bom", 200.0, days);
	}
}
