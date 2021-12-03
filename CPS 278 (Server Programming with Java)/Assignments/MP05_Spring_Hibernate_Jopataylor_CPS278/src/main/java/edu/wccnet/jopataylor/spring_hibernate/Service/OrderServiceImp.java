package edu.wccnet.jopataylor.spring_hibernate.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.wccnet.jopataylor.spring_hibernate.dao.OrderDAO;
import edu.wccnet.jopataylor.spring_hibernate.entity.PizzaOrder;

@Service
public class OrderServiceImp implements OrderService {

	@Autowired
	private OrderDAO orderDAO;

	@Override
	@Transactional
	public List<PizzaOrder> getPizzaOrders(int custId) {

		return orderDAO.getOrders(custId);
	}

	@Transactional
	public void savePizzaOrder(PizzaOrder theOrder) {
		orderDAO.savePizzaOrder(theOrder);
	}

	@Transactional
	public PizzaOrder getPizzaOrder(int id) {
		return orderDAO.getPizzaOrder(id);
	}

	@Transactional
	public void deletePizzaOrder(int id) {
		orderDAO.deletePizzaOrder(id);
	}

	@Override
	@Transactional
	public void deleteOrder(int id) {
		orderDAO.deletePizzaOrder(id);
	}

}
