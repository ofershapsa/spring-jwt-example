package com.javainuse.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="customers")
public class Customer {

	private Long id;
	private  String username;
    private String password;
    private Collection<Coupon> couponsList = new ArrayList<>() ;
    
    
    
    @Id
    @GeneratedValue
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	@Column(nullable=false)
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
	@Column(nullable=false)
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@OneToMany (mappedBy ="customer" ,fetch = FetchType.EAGER)
	public Collection<Coupon> getCouponsList() {
		return couponsList;
	}
	public void setCouponsList(Collection<Coupon> couponsList) {
		this.couponsList = couponsList;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", username=" + username + ", password=" + password + ", couponsList="
				+ couponsList + "]";
	}
	
	
	
}
