package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// use the session object to save Jave Object
			// create 3 student objects
			System.out.println("Create 3 Student Object");
			Student tempStudent1 = new Student("Paul", "Wall", "paul@wccnet.edu");
			Student tempStudent2 = new Student("John", "Doe", "john@wccnet.edu");
			Student tempStudent3 = new Student("Mary", "Public", "mary@wccnet.edu");

			// start the transaction
			session.beginTransaction();

			// save the student object
			System.out.println("Saving Students...");
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);

			// commit the transaction
			session.getTransaction().commit();
			System.out.println("We Done.");

		} finally {
			factory.close();
		}

	}

}
