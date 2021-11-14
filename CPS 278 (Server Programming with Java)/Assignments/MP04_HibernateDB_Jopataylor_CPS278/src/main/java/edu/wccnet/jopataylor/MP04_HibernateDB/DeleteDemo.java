package edu.wccnet.jopataylor.MP04_HibernateDB;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class DeleteDemo {

	public static void main(String[] args) {

		Scanner kbIn = new Scanner(System.in);

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Customer.class)
				.addAnnotatedClass(PizzaOrder.class).addAnnotatedClass(Pizza.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();

			String orderSyntax = "from PizzaOrder";

			Query<PizzaOrder> orderQuery = session.createQuery(orderSyntax, PizzaOrder.class);

			List<PizzaOrder> orderResults = orderQuery.list();

			for (PizzaOrder order : orderResults) {
				System.out.println(order);
			}

			System.out.println("Please Pick an Order's ID");

			PizzaOrder order = session.get(PizzaOrder.class, kbIn.nextInt());

			session.remove(order);

			session.getTransaction().commit();

		} finally {

			session.close();
			factory.close();
			kbIn.close();

		}

	}

}
