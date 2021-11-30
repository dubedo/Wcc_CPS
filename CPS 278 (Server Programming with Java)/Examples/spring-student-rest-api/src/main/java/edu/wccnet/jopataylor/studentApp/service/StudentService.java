package edu.wccnet.jopataylor.studentApp.service;

import java.util.List;

import edu.wccnet.jopataylor.studentApp.entity.Student;

public interface StudentService {

	public List<Student> getStudents();

	public void saveStudent(Student newStudent);

	public Student getStudent(int id);

	public void deleteStudent(int id);

}
