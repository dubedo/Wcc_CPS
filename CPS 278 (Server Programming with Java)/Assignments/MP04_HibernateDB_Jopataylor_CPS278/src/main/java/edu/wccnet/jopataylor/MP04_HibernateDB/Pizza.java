package edu.wccnet.jopataylor.MP04_HibernateDB;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pizza")
public class Pizza {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "size")
	private String size;
	@Column(name = "topping")
	private String topping;

	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name = "order_id")
	private PizzaOrder pizzaOrder;

	public Pizza() {

	}

	public Pizza(String size, String topping) {
		this.size = size;
		this.topping = topping;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getTopping() {
		return topping;
	}

	public void setTopping(String topping) {
		this.topping = topping;
	}

	public PizzaOrder getPizzaOrder() {
		return pizzaOrder;
	}

	public void setPizzaOrder(PizzaOrder pizzaOrder) {
		this.pizzaOrder = pizzaOrder;
	}

	@Override
	public String toString() {
		return "Pizza [id=" + id + ", size=" + size + ", topping=" + topping + "]";
	}
	
	

}
