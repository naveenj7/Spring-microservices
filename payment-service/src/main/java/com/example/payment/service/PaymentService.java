package com.example.payment.service;

import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.payment.entity.Payment;
import com.example.payment.repo.PaymentRepo;

@Service
public class PaymentService {
	
	@Autowired
	private PaymentRepo paymentRepo;
	
	public Payment savePayment(Payment payment) {
		payment.setPaymentStatus(paymentProcesing());
		payment.setTransactionId(UUID.randomUUID().toString());
		return paymentRepo.save(payment);
		
	}
	
	public String paymentProcesing() {
		return new Random().nextBoolean()?"success":"failed";
	}

	public Payment findByOrderId(int orderId) {
		return paymentRepo.findByOrderId(orderId);
	}

}
