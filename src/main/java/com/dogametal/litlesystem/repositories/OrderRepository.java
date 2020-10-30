package com.dogametal.litlesystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dogametal.litlesystem.entities.Orders;

public interface OrderRepository extends JpaRepository<Orders, Long> {

	
}
