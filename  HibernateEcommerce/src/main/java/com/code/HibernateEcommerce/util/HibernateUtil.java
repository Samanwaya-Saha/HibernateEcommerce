package com.code.HibernateEcommerce.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.code.HibernateEcommerce.entity.Category;
import com.code.HibernateEcommerce.entity.Orderdetails;
import com.code.HibernateEcommerce.entity.Orders;
import com.code.HibernateEcommerce.entity.Product;
import com.code.HibernateEcommerce.entity.User;

public class HibernateUtil {
	public static SessionFactory sessionfactory;
	static {
		try {
			sessionfactory = new Configuration()
							.configure("hibernate.cfg.xml")
							.addAnnotatedClass(Category.class)
							.addAnnotatedClass(Product.class)
							.addAnnotatedClass(User.class)
							.addAnnotatedClass(Orders.class)
							.addAnnotatedClass(Orderdetails.class)
							.buildSessionFactory();
		}
		catch(Throwable ex) {
			System.out.println("Session Factory creation is failed");
			  throw new ExceptionInInitializerError(ex);
			
		}
	}
	public static SessionFactory getSessionfactory() {
		return sessionfactory;
	}
	public static void Shutdown() {
		getSessionfactory().close();
	}

}
