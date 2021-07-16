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

@RestController
@RequestMapping("/orders")
public class OrderController {
	
	@Autowired
	private OrderService orderService;

	@PostMapping("/")
	public ResponseDto saveOrder(@RequestBody RequestDto dto) {		
		return orderService.saveOrder(dto);
	}
	
	@GetMapping("/{id}")
	public Order findById(@PathVariable("id") int id) {
		return orderService.findById(id);
	}
}
