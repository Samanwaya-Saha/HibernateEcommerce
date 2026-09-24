package com.code.HibernateEcommerce.crud;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.code.HibernateEcommerce.entity.Orderdetails;
import com.code.HibernateEcommerce.entity.Orders;
import com.code.HibernateEcommerce.util.HibernateUtil;

public class ReadOrders {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory sessionfactory = HibernateUtil.getSessionfactory();
		Session session = sessionfactory.openSession();
		List<Orders>orders= session.createQuery("from Orders", Orders.class).getResultList();
		  // Display the Orders
        for (Orders order : orders) {

            System.out.println("Order ID: " + order.getOrderid());
            System.out.println("Order Date: " + order.getOrderdate());
            System.out.println("Total Amount: " + order.getTotalamount());

            // Get the User
            System.out.println(
                    "User: " + order.getUser().getUsername()
            );

            // Get the OrderDetails
            List<Orderdetails> orderdetails =
                    order.getOrderdetails();

            for (Orderdetails detail : orderdetails) {

                System.out.println(
                        "Product: "
                        + detail.getProduct().getProduct_name()
                );

                System.out.println(
                        "Quantity: "
                        + detail.getQuantity()
                );

                System.out.println(
                        "Unit Price: "
                        + detail.getUnitprice()
                );
            }

          
        }

        // Close the Session
        session.close();

        // Close the SessionFactory
        HibernateUtil.Shutdown();

	}

}
