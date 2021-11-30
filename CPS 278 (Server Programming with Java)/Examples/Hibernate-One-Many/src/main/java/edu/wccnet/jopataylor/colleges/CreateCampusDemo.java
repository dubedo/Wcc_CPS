package edu.wccnet.jopataylor.colleges;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCampusDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(College.class)
				.addAnnotatedClass(Campus.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();

			College college = session.get(College.class, 1);

			Campus brightonCampus = new Campus("7878 Brighton Road", "Brighton", "MI", "48116");
			Campus mainCampus = new Campus("4800 East Huron River Drive", "Ann Arbor", "MI", "48105");
			Campus ypsiCampus = new Campus("332 Harriet Street", "Ypsilanti", "MI", "48197");

			college.add(mainCampus);
			college.add(ypsiCampus);
			college.add(brightonCampus);

			// session.save(college);
			session.persist(mainCampus);
			session.persist(ypsiCampus);
			session.persist(brightonCampus);

			session.getTransaction().commit();

		} finally {

			session.close();
			factory.close();

		}

	}

}
