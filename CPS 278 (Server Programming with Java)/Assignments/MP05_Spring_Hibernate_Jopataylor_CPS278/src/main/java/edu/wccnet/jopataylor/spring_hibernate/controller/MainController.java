package edu.wccnet.jopataylor.spring_hibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.wccnet.jopataylor.spring_hibernate.Service.CustomerService;
import edu.wccnet.jopataylor.spring_hibernate.Service.OrderService;
import edu.wccnet.jopataylor.spring_hibernate.entity.Customer;
import edu.wccnet.jopataylor.spring_hibernate.entity.Pizza;
import edu.wccnet.jopataylor.spring_hibernate.entity.PizzaOrder;
import edu.wccnet.jopataylor.spring_hibernate.entity.PizzaService;

@Controller
@RequestMapping("/pizza")
public class MainController {

	private PizzaOrder pizzaOrder;

	@Autowired
	private CustomerService customerService;
	@Autowired
	private OrderService orderService;

	@Autowired
	private PizzaService pizzaService;

	@GetMapping("/customerList")
	public String listCustomers(Model model) {

		model.addAttribute("customers", customerService.getCustomers());

		return "list-customers";
	}

	@PostMapping("/addCustomer")
	public String addCustomer(Model model) {

		Customer newCustomer = new Customer();

		model.addAttribute("customer", newCustomer);

		return "add-customer";
	}

	@PostMapping("/processCustomer")
	public String processCustomer(@ModelAttribute("newCustomer") Customer theCustomer) {

		customerService.saveCustomer(theCustomer);

		return "redirect:/pizza/customerList";
	}

	@PostMapping("/updateCustomer")
	public String updateCustomer(Model model, @RequestParam("customerId") int id) {

		Customer customer = customerService.getCustomer(id);
		model.addAttribute("customer", customer);
		return "add-customer";
	}

	@PostMapping("/deletePizza")
	public String deletePizza(@RequestParam("pizzaId") int id, Model model) {
		pizzaOrder.getPizzas().remove(id - 1);
		model.addAttribute("order", pizzaOrder);
		return "confirmation";
	}

	@PostMapping("/deleteOrder")
	public String deleteOrder(@RequestParam("orderId") int id, RedirectAttributes redirectAttributes) {
		int customerId = orderService.getPizzaOrder(id).getCustomer().getId();
		orderService.deleteOrder(id);
		redirectAttributes.addAttribute("customerId", customerId);
		return "redirect:/pizza/pizzaOrder";
	}

	@RequestMapping("/pizzaOrder")
	public String listPizzaOrders(Model model, @RequestParam("customerId") int id) {
		model.addAttribute("pizzaOrders", orderService.getPizzaOrders(id));

		Customer customer = customerService.getCustomer(id);

		model.addAttribute("customerName", customer.getFname() + " " + customer.getLname());
		model.addAttribute("customerId", customer.getId());

		return "list-pizzaOrders";
	}

	@RequestMapping("/orderPizza")
	public ModelAndView orderPizza(Model model, @RequestParam("customerId") int id) {

		Customer customer = customerService.getCustomer(id);

		model.addAttribute("customerName", customer.getFname() + " " + customer.getLname());

		if (pizzaOrder == null) {
			pizzaOrder = new PizzaOrder(customer);
		}

		return new ModelAndView("order-pizza", "newPizza", new Pizza());
	}

	@RequestMapping("/addPizza")
	public String addPizza(Model model, @ModelAttribute("newPizza") Pizza pizza) {
		pizzaOrder.addPizza(pizza);

		model.addAttribute("order", pizzaOrder);
		return "confirmation";
	}

	@RequestMapping("/placeOrder")
	public String placeOrder(@RequestParam("customerId") int id, RedirectAttributes redirectAttributes) {
		orderService.savePizzaOrder(pizzaOrder);
		pizzaOrder = null;
		redirectAttributes.addAttribute("customerId", id);

		return "redirect:/pizza/pizzaOrder";
	}

	@ModelAttribute
	public void populateForm(Model model) {
		model.addAttribute("sizeList", pizzaService.populateSize());
		model.addAttribute("toppingList", pizzaService.populateTopping());
		model.addAttribute("stateList", pizzaService.populateState());
	}

}
