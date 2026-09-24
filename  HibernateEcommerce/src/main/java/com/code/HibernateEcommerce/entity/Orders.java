package com.code.HibernateEcommerce.entity;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")

public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int order_id;
	@Column(nullable=false)
	private LocalDateTime order_date;
	@Column(nullable=false)
	private int total_amount;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="userid")
	private User user;
	@OneToMany(mappedBy = "orders",
			cascade = CascadeType.ALL,
			fetch = FetchType.LAZY
			)
	private List<Orderdetails> orderdetails;
	// Create an empty constructor to read the value from the database
	public Orders() {
		
	}
	// Create the Constructor to initialize the object
	public Orders(LocalDateTime order_date,int total_amount) {
		this.order_date=order_date;
		this.total_amount = total_amount;
	}
	// Create the getter and Setter method to read the value
	public int getOrderid() {
		return order_id;
	}
	public void setOrderid(int order_id) {
		this.order_id=order_id;
	}
	public LocalDateTime getOrderdate() {
		return order_date;
	}
	public void setOrderdate(LocalDateTime order_date) {
		this.order_date=order_date;
	}
	public int getTotalamount() {
		return total_amount;
	}
	public void setTotalamount(int total_amount) {
		this.total_amount=total_amount;
	}
	// getter and setter method for User
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user= user;
	}
	// Getter and Setter Method for Order Details
	public List<Orderdetails> getOrderdetails(){
		return orderdetails;
	}
	public void setOrderdetails(List<Orderdetails> orderdetails) {
		this.orderdetails = orderdetails;
	}

}
