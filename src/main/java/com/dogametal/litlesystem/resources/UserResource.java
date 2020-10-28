package com.dogametal.litlesystem.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dogametal.litlesystem.entities.User;
import com.dogametal.litlesystem.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired
	private UserService service;	
	
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		//add L front long type 
		/*
		User u = new User(1L, "Douglas Silva Friend", "dogametal@hotmail.com", "11-99633 9446", "1234");
		*/
		List<User> list = service.findAll();
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	//framework understand url add @pathvariable
	public ResponseEntity<User> findById(@PathVariable Long id ){
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
		
	}
	
}
