package edu.wccnet.jopataylor.spring_hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.wccnet.jopataylor.spring_hibernate.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomers() {

		Session session = sessionFactory.getCurrentSession();

		Query<Customer> query = session.createQuery("from Customer order by id", Customer.class);

		return query.getResultList();
	}

	@Override
	public void saveCustomer(Customer theCustomer) {

		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(theCustomer);

	}

	@Override
	public Customer getCustomer(int id) {

		Session session = sessionFactory.getCurrentSession();

		return session.get(Customer.class, id);
	}

}
