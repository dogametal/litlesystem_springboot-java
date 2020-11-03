package com.dogametal.litlesystem.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dogametal.litlesystem.entities.Category;
import com.dogametal.litlesystem.services.CategoryService;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {
	
	@Autowired
	private CategoryService service;	
	
	@GetMapping
	public ResponseEntity<List<Category>> findAll(){
		//add L front long type 
		/*
		Category u = new Category(1L, "Douglas Silva Friend", "dogametal@hotmail.com", "11-99633 9446", "1234");
		*/
		List<Category> list = service.findAll();
		
		return ResponseEntity.ok().body(list);
	}
	//Info to finding category by Id
	@GetMapping(value = "/{id}")
	//framework understand url add @pathvariable
	public ResponseEntity<Category> findById(@PathVariable Long id ){
		Category obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
		
	}
	
}
