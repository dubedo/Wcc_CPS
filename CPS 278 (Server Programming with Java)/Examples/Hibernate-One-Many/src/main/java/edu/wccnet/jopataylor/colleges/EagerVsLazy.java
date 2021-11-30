package edu.wccnet.jopataylor.colleges;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EagerVsLazy {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(College.class)
				.addAnnotatedClass(Campus.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();

			College college = session.get(College.class, 1);
			System.out.println(college);

			session.getTransaction().commit();

			System.out.println(college.getCampuses());

		} finally {

			session.close();
			factory.close();

		}

	}

}
