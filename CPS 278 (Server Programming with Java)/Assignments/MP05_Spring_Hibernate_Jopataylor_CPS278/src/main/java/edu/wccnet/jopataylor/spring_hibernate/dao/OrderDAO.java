package edu.wccnet.jopataylor.spring_hibernate.dao;

import java.util.List;

import edu.wccnet.jopataylor.spring_hibernate.entity.PizzaOrder;

public interface OrderDAO {

	List<PizzaOrder> getOrders(int custId);

	void savePizzaOrder(PizzaOrder theOrder);

	PizzaOrder getPizzaOrder(int id);

	void deletePizzaOrder(int id);



}
