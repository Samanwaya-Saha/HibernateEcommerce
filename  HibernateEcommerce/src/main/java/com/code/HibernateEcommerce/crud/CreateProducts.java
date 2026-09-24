package com.code.HibernateEcommerce.crud;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.code.HibernateEcommerce.entity.Category;
import com.code.HibernateEcommerce.entity.Product;
import com.code.HibernateEcommerce.util.HibernateUtil;

public class CreateProducts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory sessionfactory = HibernateUtil.getSessionfactory();
		// Create the sessions 
		Session session = sessionfactory.openSession();
		// After creating the session database can do work
		Transaction transaction = session.beginTransaction();
		 Category category = session.get(Category.class, 1);
		//add the objects
		Product product = new Product(0, "Laptop", 55000, 10);
		product.setCategory(category);
		session.persist(product);
		transaction.commit();
		session.close();
		HibernateUtil.Shutdown();
		System.out.println("Product is created sucessfully ");

	}

}
