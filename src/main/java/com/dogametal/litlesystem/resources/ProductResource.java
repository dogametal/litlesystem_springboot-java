package com.dogametal.litlesystem.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dogametal.litlesystem.entities.Product;
import com.dogametal.litlesystem.services.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {
	
	@Autowired
	private ProductService service;	
	
	@GetMapping
	public ResponseEntity<List<Product>> findAll(){
		//add L front long type 
		/*
		Product u = new Product(1L, "Douglas Silva Friend", "dogametal@hotmail.com", "11-99633 9446", "1234");
		*/
		List<Product> list = service.findAll();
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	//framework understand url add @pathvariable
	public ResponseEntity<Product> findById(@PathVariable Long id ){
		Product obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
		
	}
	
}
