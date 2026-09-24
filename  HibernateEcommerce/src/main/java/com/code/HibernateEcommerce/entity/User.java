package com.code.HibernateEcommerce.entity;



import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="user")
public class User {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int userid;
@Column(unique = true,nullable = false)
private String username;
@Column(nullable=false)
private String password;
@Column(nullable=false)
private String email;
private String role;
@OneToMany(mappedBy = "user",
			cascade = CascadeType.ALL,
			fetch = FetchType.LAZY
			)
private List<Orders> orders;


public User() {
	
}
public User(int userid,String username,String email,String password,String role) {
	this.userid = userid;
	this.username = username;
	this.email = email;
	this.password = password;
	this.role = role;
}
// Create the getter and the setter method
public int getUserid() {
	return userid;
}
public void setUserid(int userid) {
	this.userid = userid;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
public List<Orders> getOrders(){
	return orders;
}
public void setOrders(List<Orders> orders) {
	this.orders = orders;
}
}
