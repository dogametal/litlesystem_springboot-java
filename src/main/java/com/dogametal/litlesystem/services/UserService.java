package com.dogametal.litlesystem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.dogametal.litlesystem.entities.User;
import com.dogametal.litlesystem.repositories.UserRepository;
import com.dogametal.litlesystem.services.exceptions.DatabaseException;
import com.dogametal.litlesystem.services.exceptions.ResourceNotFoundException;

//Could be @Component but this is more explanation
@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll() {
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		//return obj.get();
		
		//Method applied to compare attempt run with id chosen
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public User insert (User obj) {
		return repository.save(obj);
	}
	
	public void delete (Long id) {
		//Capture exception on Postman changed to 404 status not found
		try {
			repository.deleteById(id);
		}
		//Used to capture exception exactly name RuntimeException
		catch(EmptyResultDataAccessException e ) {
			throw new ResourceNotFoundException(id) ;
		}
		catch(DataIntegrityViolationException f) {
			throw new DatabaseException(f.getMessage());
		}
	}
	
	public User update(Long id, User obj) {
		//GetOne work temporary instance id no necessarily using database
		User entity = repository.getOne(id);
		updateData(entity, obj);
		return repository.save(entity);
				
	}

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());		
	}
}
