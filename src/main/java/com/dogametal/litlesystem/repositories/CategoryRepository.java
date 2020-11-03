package com.dogametal.litlesystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dogametal.litlesystem.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

	
}
