package com.example.order.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.order.entity.Order;

public interface OrderRpeo extends JpaRepository<Order, Integer> {

}
