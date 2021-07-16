package com.example.order.dto;

import com.example.order.entity.Order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestDto {
	
	private Order order;
	private Payment payment;

}
