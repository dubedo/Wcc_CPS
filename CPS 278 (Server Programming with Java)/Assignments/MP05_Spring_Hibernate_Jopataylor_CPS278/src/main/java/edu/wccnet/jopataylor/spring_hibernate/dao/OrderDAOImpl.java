package edu.wccnet.jopataylor.spring_hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.wccnet.jopataylor.spring_hibernate.entity.Customer;
import edu.wccnet.jopataylor.spring_hibernate.entity.PizzaOrder;

@Repository
public class OrderDAOImpl implements OrderDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<PizzaOrder> getOrders(int customerId) {

		Session session = sessionFactory.getCurrentSession();
		Customer customer = session.get(Customer.class, customerId);

		Query<PizzaOrder> query = session
				.createQuery("from PizzaOrder o join fetch o.pizzas where o.customer = :customer", PizzaOrder.class);
		query.setParameter("customer", customer);
		List<PizzaOrder> orders = query.getResultList();

		return orders;
	}

	public void savePizzaOrder(PizzaOrder theOrder) {

		Session session = sessionFactory.getCurrentSession();

		session.saveOrUpdate(theOrder);
	}

	public PizzaOrder getPizzaOrder(int id) {

		Session session = sessionFactory.getCurrentSession();

		return session.get(PizzaOrder.class, id);
	}

	public void deletePizzaOrder(int id) {

		Session session = sessionFactory.getCurrentSession();

		PizzaOrder theOrder = session.get(PizzaOrder.class, id);

		session.remove(theOrder);
	}

}
