package edu.wccnet.jopataylor.studentApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.wccnet.jopataylor.studentApp.dao.StudentDAO;
import edu.wccnet.jopataylor.studentApp.entity.Student;

@Service
public class StudentServiceImplementation implements StudentService {

	@Autowired
	private StudentDAO studentDao;

	@Override
	@Transactional
	public List<Student> getStudents() {
		return studentDao.getStudents();
	}

	@Override
	@Transactional
	public void saveStudent(Student newStudent) {
		studentDao.saveStudent(newStudent);
	}

	@Override
	@Transactional
	public Student getStudent(int id) {
		return studentDao.getStudent(id);
	}

	@Override
	@Transactional
	public void deleteStudent(int id) {
		studentDao.deleteStudent(id);
	}

}
