package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class ReadStudentDemo {

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
			Student tempStudent = new Student("Daffy", "Duck", "daffy@luv2code.com");

			// start the transaction
			session.beginTransaction();

			// save the student object
			System.out.println("Saving Student...");
			System.out.println(tempStudent);
			session.save(tempStudent);

			// commit the transaction
			session.getTransaction().commit();

			// NEW CODE

			// find student's id: primary key
			System.out.println("Saved Student. Generated Id: " + tempStudent.getId());

			// now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();

			// retrieve student based on the id: primary key
			System.out.println("\nGetting Student with Id: " + tempStudent.getId());
			Student myStudent = session.get(Student.class, tempStudent.getId());

			System.out.println("Get Complete... " + myStudent);

			// commit the transaction
			session.getTransaction().commit();

			System.out.println("We Done.");

		} finally {
			factory.close();
		}

	}

}
