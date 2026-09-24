package com.code.HibernateEcommerce.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "orderdetails")

public class Orderdetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int order_detail_id;
	@Column(nullable=false)
	private int quantity;
	@Column(nullable=false)
	private float unit_price;
	@ManyToOne (fetch=FetchType.LAZY)
	@JoinColumn(name="order_id")
	private Orders orders;
	@ManyToOne (fetch=FetchType.LAZY)
	@JoinColumn(name="product_id")
	private Product product;
	// Create an empty constructor to read the value from the database
	public Orderdetails() {
		
	}
	// Create the Constructor to initialize the object
	public Orderdetails(int quantity,float unit_price) {
		this.quantity=quantity;
		this.unit_price = unit_price;
	}
	// Create the getter and Setter method
	public int getOrderdetailid() {
		return order_detail_id;
	}
	public void setOrderdetailid(int order_detail_id) {
		this.order_detail_id=order_detail_id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity=quantity;
	}
	public float getUnitprice() {
		return unit_price;
	}
	public void setUnitprice(float unit_price) {
		this.unit_price=unit_price;
	}
	// Getter and Setter Method for the orders
	public Orders getOrders() {
		return orders;
	}
	public void setOrders(Orders orders) {
		this.orders = orders;
	}
	// Getter and setter method for the product
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}

}
