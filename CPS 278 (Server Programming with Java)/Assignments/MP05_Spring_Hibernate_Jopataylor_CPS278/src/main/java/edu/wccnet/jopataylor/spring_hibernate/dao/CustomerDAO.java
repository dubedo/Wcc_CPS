package edu.wccnet.jopataylor.spring_hibernate.dao;

import java.util.List;

import edu.wccnet.jopataylor.spring_hibernate.entity.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	Customer getCustomer(int id);

}
