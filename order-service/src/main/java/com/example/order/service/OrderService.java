package com.example.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.order.dto.Payment;
import com.example.order.dto.RequestDto;
import com.example.order.dto.ResponseDto;
import com.example.order.entity.Order;
import com.example.order.repo.OrderRpeo;

import javassist.NotFoundException;

@Service
public class OrderService {

	@Autowired
	private OrderRpeo orderRpeo;
		
	@Autowired
	private RestTemplate restTemplate;

	public ResponseDto saveOrder(RequestDto dto) {
		
		String responseMsg = "";
		
		Order order = dto.getOrder();
		Payment payment = dto.getPayment();
		payment.setOrderId(order.getId());
		payment.setAmount(order.getPrice()* order.getQty());
		
		
		Payment paymentResponse = restTemplate.postForObject("http://PAYMENT-SERVICE/payment/", payment, Payment.class);
		
		responseMsg = paymentResponse.getPaymentStatus().equals("success")?"payment success":"payment failed";
		
		Order orderResponse = orderRpeo.save(order);		

		return new ResponseDto(orderResponse,paymentResponse.getTransactionId(),paymentResponse.getAmount(),responseMsg);
	}

	public Order findById(int id) {
		return orderRpeo.findById(id).orElseThrow();	}
}
