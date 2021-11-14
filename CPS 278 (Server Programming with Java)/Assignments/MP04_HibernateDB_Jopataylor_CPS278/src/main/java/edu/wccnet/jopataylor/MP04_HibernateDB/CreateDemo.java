package edu.wccnet.jopataylor.MP04_HibernateDB;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Customer.class)
				.addAnnotatedClass(PizzaOrder.class).addAnnotatedClass(Pizza.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();
			
			Customer cust1 = new Customer("Jonathan", "Taylor", "1234 Main Street", "Ann Arbor", "MI", "48105");
			Customer cust2 = new Customer("Sarah", "Taylor", "5678 Second Street", "Ann Arbor", "MI", "48105");
			
			PizzaOrder order1 = new PizzaOrder();
			PizzaOrder order2 = new PizzaOrder();
			
			Pizza pizza1 = new Pizza("Large", "Onion");
			Pizza pizza2 = new Pizza("Small", "Green Pepper");
			Pizza pizza3 = new Pizza("Medium", "Banana Peppers");
			
			order1.addPizza(pizza1);
			order1.addPizza(pizza2);
			
			order2.addPizza(pizza3);
			
			cust1.addOrder(order1);
			cust2.addOrder(order2);
			
			session.persist(cust1);
			session.persist(cust2);

			session.getTransaction().commit();

		} finally {

			session.close();
			factory.close();

		}

	}

}
