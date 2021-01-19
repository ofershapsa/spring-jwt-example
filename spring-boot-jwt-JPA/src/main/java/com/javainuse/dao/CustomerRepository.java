package com.javainuse.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javainuse.model.Customer;


public interface CustomerRepository extends JpaRepository<Customer, Long>{
	
   Customer findByUsername(String username);
}
