package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// use the session object to save Jave Object
			// create a student object
			System.out.println("Create Student Object");
			Student tempStudent = new Student("Jonathan", "Taylor", "jopataylor@wccnet.edu");

			// start the transaction
			session.beginTransaction();

			// save the student object
			System.out.println("Saving Student...");
			session.save(tempStudent);

			// commit the transaction
			session.getTransaction().commit();
			System.out.println("We Done.");

		} finally {
			factory.close();
		}

	}

}
