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
@Table(name="companies")
public class Company {
	private Long id;
    private String username;
    private String password;
    private String email;
   
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
	@Column(nullable=false)
	
	
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Column(nullable=false)
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@OneToMany (mappedBy ="company",fetch = FetchType.EAGER)
	public Collection<Coupon> getCouponsList() {
		return couponsList;
	}
	public void setCouponsList(Collection<Coupon> couponsList) {
		this.couponsList = couponsList;
	}
	@Override
	public String toString() {
		return "Company [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", couponsList=" + couponsList + "]";
	}
	
	

}
