package com.code.HibernateEcommerce;

import org.hibernate.SessionFactory;

import com.code.HibernateEcommerce.util.HibernateUtil;

public class App {

    public static void main(String[] args) {

        SessionFactory sessionFactory =
                HibernateUtil.getSessionfactory();

        System.out.println("Hibernate started successfully!");

        HibernateUtil.Shutdown();
    }
}