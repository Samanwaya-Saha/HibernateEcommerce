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
@Table(name="category")
public class Category {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private int categoryid;
 @Column (unique = true,nullable = false)
 
 private String name;
 private String description;
 @OneToMany (
		 mappedBy = "category",
		 cascade = CascadeType.ALL,
		 fetch = FetchType.LAZY
		 )
 private List< Product> products;
 // Create a no Argument Constructor to read data from database
 public Category() { 
 }
 public Category( String name,String description) {
	this.name = name;
	this.description = description;
 }
 
 public int getCategoryId() {
	 return categoryid;
 }
 public void setCategoryId(int categoryid) {
	 this.categoryid = categoryid;
 }
 // Create getter or setter method to get and set name
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public List<Product> getProducts() {
	return products;
}
public void setProducts(List<Product> products) {
	this.products = products;
}
}
