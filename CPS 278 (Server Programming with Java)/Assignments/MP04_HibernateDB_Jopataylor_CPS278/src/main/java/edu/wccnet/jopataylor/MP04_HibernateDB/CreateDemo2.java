package edu.wccnet.jopataylor.MP04_HibernateDB;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo2 {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Customer.class)
				.addAnnotatedClass(PizzaOrder.class).addAnnotatedClass(Pizza.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();
			
			Customer customer = session.get(Customer.class, 7);
			
			PizzaOrder newPizzaOrder = new PizzaOrder();
			Pizza newPizza = new Pizza("Small", "Sausage");
			
			newPizzaOrder.addPizza(newPizza);
			
			customer.addOrder(newPizzaOrder);
			

			session.getTransaction().commit();

		} finally {

			session.close();
			factory.close();

		}

	}

}
