package edu.wccnet.jopataylor.colleges;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(College.class)
				.addAnnotatedClass(Campus.class).addAnnotatedClass(Company.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();

			Company canvas = session.get(Company.class, 1);

			session.remove(canvas);

			session.getTransaction().commit();

		} finally {

			session.close();
			factory.close();

		}

	}

}
