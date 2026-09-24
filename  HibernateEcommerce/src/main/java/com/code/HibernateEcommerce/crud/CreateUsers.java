package com.code.HibernateEcommerce.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.code.HibernateEcommerce.entity.Category;
import com.code.HibernateEcommerce.entity.User;
import com.code.HibernateEcommerce.util.HibernateUtil;

public class CreateUsers {
	public static void main(String args[]) {
		// get the sessionfactory from the hibernetutil
		SessionFactory sessionfactory = HibernateUtil.getSessionfactory();
		// After getting the session we open the session that's why the database can do the operations
		Session session = sessionfactory.openSession();
		// After creating the session the database can do the work
		Transaction transaction = session.beginTransaction();
		User user = new User( 0,
		        "samanwaya",
		        "samanwaya@gmail.com",
		        "12345",
		        "CUSTOMER");
		// Save the category object inside the database
		session.persist(user);
		// Database operation is sucessful
		transaction.commit();
		session.close();
		HibernateUtil.Shutdown();
		System.out.println("Category is created sucessfully ");
	}

}
