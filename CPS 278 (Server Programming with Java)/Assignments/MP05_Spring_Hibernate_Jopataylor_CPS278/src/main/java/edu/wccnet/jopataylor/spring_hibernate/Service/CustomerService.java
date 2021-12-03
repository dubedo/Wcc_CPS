package edu.wccnet.jopataylor.spring_hibernate.Service;

import java.util.List;

import edu.wccnet.jopataylor.spring_hibernate.entity.Customer;

public interface CustomerService {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	Customer getCustomer(int id);

}
