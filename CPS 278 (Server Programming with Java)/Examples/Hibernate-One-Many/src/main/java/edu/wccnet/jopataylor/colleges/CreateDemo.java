package edu.wccnet.jopataylor.colleges;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(College.class)
				.addAnnotatedClass(Campus.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();

			College college = new College("WCC");
			Campus mainCampus = new Campus("4800 East Huron River Drive", "Ann Arbor", "MI", "48105");
			Campus ypsiCampus = new Campus("332 Harriet Street", "Ypsilanti", "MI", "48197");

			college.add(ypsiCampus);
			college.add(mainCampus);

			// session.save(college);
			session.persist(college);

			session.getTransaction().commit();

		} finally {

			session.close();
			factory.close();

		}

	}

}
