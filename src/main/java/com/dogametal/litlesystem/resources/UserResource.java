package com.dogametal.litlesystem.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.dogametal.litlesystem.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@GetMapping
	public ResponseEntity<User> findAll(){
		//add L front long type 
		User u = new User(1L, "Douglas Silva", "dogametal@hotmail.com", "11-99633 9446", "1234");
		return ResponseEntity.ok().body(u);
	}
	
}
