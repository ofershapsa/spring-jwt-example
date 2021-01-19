package com.javainuse.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.javainuse.dao.CompanyRepository;
import com.javainuse.dao.CustomerRepository;
import com.javainuse.model.Company;
import com.javainuse.model.Customer;
import com.javainuse.model.CustomerDTO;
import com.javainuse.model.UserDTO;

@Service
public class JwtCustomerDetailsService  implements UserDetailsService{
	@Autowired
	//private UserDao userDao;
	private CustomerRepository cr;
	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//DAOUser user = userDao.findByUsername(username);
		Customer customer = cr.findByUsername(username);
		if (customer== null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(customer.getUsername(), customer.getPassword(),
				new ArrayList<>());
	}
	
	public Customer save(CustomerDTO user) {
		Customer newCustomer = new Customer();
		newCustomer.setUsername(user.getUsername());
		newCustomer.setPassword(bcryptEncoder.encode(user.getPassword()));
		
		return cr.save(newCustomer);
	}
	
}
