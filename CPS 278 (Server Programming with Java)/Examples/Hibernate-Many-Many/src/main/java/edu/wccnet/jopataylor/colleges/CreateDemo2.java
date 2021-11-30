package edu.wccnet.jopataylor.colleges;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo2 {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(College.class)
				.addAnnotatedClass(Campus.class).addAnnotatedClass(Company.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();

			College wcc = session.get(College.class, 1);
			Company ellucian = session.get(Company.class, 2);

			wcc.addCompany(ellucian);
			// ellucian.addCollege(wcc);

			Company bb = new Company("BlackBoard");
			session.persist(bb);
			wcc.addCompany(bb);

			session.getTransaction().commit();

		} finally {

			session.close();
			factory.close();

		}

	}

}
