package edu.wccnet.jopataylor.colleges;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class EagerVsLazy2 {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(College.class)
				.addAnnotatedClass(Campus.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();

			Query<College> query = session.createQuery("from College c join fetch c.campuses where c.id = :collegeId",
					College.class);

			query.setParameter("collegeId", 1);

			College college = query.getSingleResult();

			System.out.println(college);
			session.getTransaction().commit();

			System.out.println(college.getCampuses());

		} finally {

			session.close();
			factory.close();

		}

	}

}
