package com.example.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.order.dto.RequestDto;
import com.example.order.dto.ResponseDto;
import com.example.order.entity.Order;
import com.example.order.service.OrderService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/orders")
public class OrderController {
	
	private static final String ORDER_SERVICE = "orderService";
	
	@Autowired
	private OrderService orderService;

	@PostMapping("/")
	@CircuitBreaker(name= ORDER_SERVICE,fallbackMethod="fallbackSaveOrder")
	public ResponseDto saveOrder(@RequestBody RequestDto dto) {		
		return orderService.saveOrder(dto);
	}
	
	public ResponseDto fallbackSaveOrder(@RequestBody RequestDto dto, Exception e) {
		return new ResponseDto();
	}
	
	@GetMapping("/{id}")
	public Order findById(@PathVariable("id") int id) {
		return orderService.findById(id);
	}
}
