package com.example.gateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackController {
	
	@GetMapping("/ordersFallBack")
	public String orderServiceFallBack(){
		return "Order service is Down. Please try again";
	}
	
	@GetMapping("/paymentFallBack")
	public String PaymentServiceFallBack(){
		return "Payment service is Down. Please try again";
	}

}
