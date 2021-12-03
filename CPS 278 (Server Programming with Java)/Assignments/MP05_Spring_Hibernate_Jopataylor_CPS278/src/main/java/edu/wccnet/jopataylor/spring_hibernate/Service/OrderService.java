package edu.wccnet.jopataylor.spring_hibernate.Service;

import java.util.List;

import edu.wccnet.jopataylor.spring_hibernate.entity.PizzaOrder;

public interface OrderService {

	List<PizzaOrder> getPizzaOrders(int custId);

	void savePizzaOrder(PizzaOrder pizzaOrder);

	void deleteOrder(int id);
	
	PizzaOrder getPizzaOrder(int id);

}
