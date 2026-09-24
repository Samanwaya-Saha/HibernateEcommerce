package com.code.HibernateEcommerce.crud;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.code.HibernateEcommerce.entity.Orderdetails;
import com.code.HibernateEcommerce.entity.Orders;
import com.code.HibernateEcommerce.entity.Product;
import com.code.HibernateEcommerce.entity.User;
import com.code.HibernateEcommerce.util.HibernateUtil;

public class CreateOrders {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory sessionfactory = HibernateUtil.getSessionfactory();
		Session session = sessionfactory.openSession();
		Transaction transaction = session.beginTransaction();
		User user = session.get(User.class, 1);
		//Take the order
		Orders order = new Orders(LocalDateTime.now(), 0); 
		// Connect with the user
		order.setUser(user);
		// Get the product 
		Product product = session.get(Product.class, 1);
		// Order Detail
		Orderdetails orderdetails = new Orderdetails(1, 55000);
		orderdetails.setOrders(order);
		orderdetails.setProduct(product);

		Orderdetails orderdetail1 = new Orderdetails(2, 55000);
		orderdetail1.setOrders(order);
		orderdetail1.setProduct(product);
		// Create a list of OrderDetails
		List<Orderdetails> orderdetailsList = new ArrayList<>();

		// Add both OrderDetails to the list
		orderdetailsList.add(orderdetails);
		orderdetailsList.add(orderdetail1);
		order.setOrderdetails(orderdetailsList);
		 session.persist(order);

	        // Commit the transaction
	        transaction.commit();

	        // Close the Session
	        session.close();

	        // Close the SessionFactory
	        HibernateUtil.Shutdown();

	        System.out.println("Order with multiple OrderDetails created successfully");

	}

}
