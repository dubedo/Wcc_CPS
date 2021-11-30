package edu.wccnet.jopataylor.studentApp.dao;

import java.util.List;

import edu.wccnet.jopataylor.studentApp.entity.Student;

public interface StudentDAO {

	public List<Student> getStudents();

	public void saveStudent(Student newStudent);

	public Student getStudent(int id);

	public void deleteStudent(int id);

}
