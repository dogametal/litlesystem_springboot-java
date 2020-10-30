package com.dogametal.litlesystem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dogametal.litlesystem.entities.Orders;
import com.dogametal.litlesystem.repositories.OrderRepository;

//Could be @Component but this is more explanation
@Service
public class OrderService {
	
	@Autowired
	private OrderRepository repository;
	
	public List<Orders> findAll() {
		return repository.findAll();
	}
	
	public Orders findById(Long id) {
		Optional<Orders> obj = repository.findById(id);
		return obj.get();
	}
}
