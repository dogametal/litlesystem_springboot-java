package com.dogametal.litlesystem.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dogametal.litlesystem.entities.Orders;
import com.dogametal.litlesystem.services.OrderService;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {
	
	@Autowired
	private OrderService service;	
	
	@GetMapping
	public ResponseEntity<List<Orders>> findAll(){
		//add L front long type 
		/*
		Orders u = new Orders(1L, "Douglas Silva Friend", "dogametal@hotmail.com", "11-99633 9446", "1234");
		*/
		List<Orders> list = service.findAll();
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	//framework understand url add @pathvariable
	public ResponseEntity<Orders> findById(@PathVariable Long id ){
		Orders obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
		
	}
	
}
