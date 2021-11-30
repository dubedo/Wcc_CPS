package edu.wccnet.jopataylor.studentApp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
// import org.springframework.transaction.annotation.Transactional;

import edu.wccnet.jopataylor.studentApp.entity.Student;

@Repository
public class StudentDAOImplementation implements StudentDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Student> getStudents() {

		Session session = sessionFactory.getCurrentSession();

		Query<Student> query = session.createQuery("from Student order by lastName", Student.class);

		return query.getResultList();
	}

	@Override
	public void saveStudent(Student newStudent) {

		Session session = sessionFactory.getCurrentSession();
		// session.save(newStudent);
		session.saveOrUpdate(newStudent);

	}

	@Override
	public Student getStudent(int id) {

		Session session = sessionFactory.getCurrentSession();

		return session.get(Student.class, id);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void deleteStudent(int id) {

		Session session = sessionFactory.getCurrentSession();

		Query query = session.createQuery("delete from Student where id = :id");
		query.setParameter("id", id);

		query.executeUpdate();

	}

}
