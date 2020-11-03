package com.dogametal.litlesystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dogametal.litlesystem.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	
}
