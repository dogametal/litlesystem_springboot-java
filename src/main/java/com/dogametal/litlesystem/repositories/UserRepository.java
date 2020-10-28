package com.dogametal.litlesystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dogametal.litlesystem.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	
}
