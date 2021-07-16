package com.example.gateway;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
public class FallBackController {
	
	@RequestMapping("/ordersFallBack")
	public Mono<String> orderServiceFallBack(){
		return Mono.just("Order service is Down. Please try again");
	}
	
	@RequestMapping("/paymentFallBack")
	public Mono<String> PaymentServiceFallBack(){
		return Mono.just("Payment service is Down. Please try again");
	}

}
