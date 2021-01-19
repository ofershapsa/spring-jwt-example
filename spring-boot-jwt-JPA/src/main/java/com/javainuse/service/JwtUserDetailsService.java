package com.javainuse.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.javainuse.dao.CompanyRepository;
import com.javainuse.dao.CustomerRepository;
import com.javainuse.dao.UserDao;
import com.javainuse.model.Company;
import com.javainuse.model.Customer;
import com.javainuse.model.CustomerDTO;
import com.javainuse.model.DAOUser;
import com.javainuse.model.UserDTO;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	@Autowired
	//private UserDao userDao;
	private CompanyRepository cr;
	
	@Autowired
	private PasswordEncoder bcryptEncoder;

	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//DAOUser user = userDao.findByUsername(username);
		Company  company = cr.findByUsername(username);
		
		if (company == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		
		return new org.springframework.security.core.userdetails.User(company.getUsername(), company.getPassword(),
				new ArrayList<>());
		
	}
	
	
	public Company save(UserDTO user) {
		Company newCompany = new Company();
		newCompany.setUsername(user.getUsername());
		newCompany.setPassword(bcryptEncoder.encode(user.getPassword()));
		newCompany.setEmail(user.getEmail());
		return cr.save(newCompany);
	}
	
	
}