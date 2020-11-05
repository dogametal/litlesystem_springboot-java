package com.dogametal.litlesystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dogametal.litlesystem.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

	
}
