package edu.wccnet.jopataylor.MP04_HibernateDB;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Customer.class)
				.addAnnotatedClass(PizzaOrder.class).addAnnotatedClass(Pizza.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();

			String customerSyntax = "from Customer";

			Query<Customer> customerQuery = session.createQuery(customerSyntax, Customer.class);
			List<Customer> customerList = customerQuery.list();

			for (Customer customer : customerList) {
				System.out.println(customer);
			}

			System.out.println("Please Select a Customer ID");

			Query<Customer> query = session.createQuery("from Customer where id = 7", Customer.class);

			Customer customer = query.getSingleResult();
			System.out.println(customer.getPizzaOrders());

			session.getTransaction().commit();

		} finally {

			session.close();
			factory.close();

		}

	}

}
