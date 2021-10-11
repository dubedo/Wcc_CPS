package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import mortgageInfo.BorrowersInfo;

@Controller
public class MainController {

	@RequestMapping("/")
	public String home() {
		return "home";
	}

	@RequestMapping("/collectInfo")
	public String theForm(Model ourModel) {

		BorrowersInfo formInfo = new BorrowersInfo();

		ourModel.addAttribute("theirInfo", formInfo);

		return "collectInfo";
	}

	@RequestMapping("/crunchingNumbers")
	public String theBreakdown(@ModelAttribute("theirInfo") BorrowersInfo newInfo) {

		newInfo.calculateMonthlyPayment();
		newInfo.generateTable();

		return "theBreakdown";
	}

}
