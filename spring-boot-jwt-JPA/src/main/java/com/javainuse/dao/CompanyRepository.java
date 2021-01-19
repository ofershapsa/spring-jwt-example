package com.javainuse.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javainuse.model.Company;



public interface CompanyRepository extends JpaRepository<Company,Long> {
	
	Company findByUsername(String username);

}
