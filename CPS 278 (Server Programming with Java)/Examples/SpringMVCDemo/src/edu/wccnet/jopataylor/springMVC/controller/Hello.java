package edu.wccnet.jopataylor.springMVC.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Hello {

	@RequestMapping("/")
	public String helloPage(Model model) {

		ArrayList<String> courseList = new ArrayList<String>();

		courseList.add("Cps161");
		courseList.add("Cps261");
		courseList.add("Cps251");
		courseList.add("Cps278");

		model.addAttribute("courseList", courseList);

		return "hello";
	}

}
