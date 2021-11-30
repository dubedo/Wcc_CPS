package edu.wccnet.jopataylor.studentApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.wccnet.jopataylor.studentApp.entity.Student;
import edu.wccnet.jopataylor.studentApp.service.StudentService;

@Controller
@RequestMapping("/student")
public class MainController {

	@Autowired
	private StudentService studentService;
	// private StudentDAO studentDao;

	@GetMapping("/list")
	public String listStudents(Model model) {

		model.addAttribute("students", studentService.getStudents());

		return "list-students";
	}

	@PostMapping("/addStudent")
	public String addStudent(Model model) {

		Student blankStudent = new Student();
		model.addAttribute("student", blankStudent);

		return "add-student";
	}

	@PostMapping("/processStudent")
	public String processStudent(@ModelAttribute("student") Student newStudent) {

		System.out.println(newStudent);

		studentService.saveStudent(newStudent);

		return "redirect:/student/list";
	}

	@RequestMapping("/updateStudent")
	public String updateStudent(Model model, @RequestParam("studentId") int id) {

		Student updatedStudent = studentService.getStudent(id);
		model.addAttribute("student", updatedStudent);

		return "add-student";
	}
	
	@RequestMapping("/deleteStudent")
	public String deleteStudent(@RequestParam("studentId") int id) {
		
		studentService.deleteStudent(id);
		
		return "redirect:/student/list";
	}
}
