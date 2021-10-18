package edu.jopataylor.cps278.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.jopataylor.cps278.pizzaOrder.Order;
import edu.jopataylor.cps278.pizzaOrder.PopulatePizzaForm;

@Controller
public class MainController {

	@Autowired
	private PopulatePizzaForm thePizzaForm;

	@ModelAttribute
	public void populateForm(Model ourModel) {
		ourModel.addAttribute("sizeOptions", thePizzaForm.sizeOptions());
		ourModel.addAttribute("toppingOptions", thePizzaForm.toppingOptions());
		ourModel.addAttribute("stateOptions", thePizzaForm.stateOptions());
	}

	@RequestMapping("/")
	public String home() {
		return "home";
	}

	@RequestMapping("/pizzaForm")
	public String theForm(Model ourModel) {

		ourModel.addAttribute("theirOrder", new Order());

		return "pizzaForm";

	}

	@RequestMapping("/processTheForm")
	public String processForm(@Valid @ModelAttribute("theirOrder") Order theirOrder, BindingResult result) {

		if (result.hasErrors()) {
			return "pizzaForm";
		} else {
			return "confirmedOrder";
		}

	}

}
