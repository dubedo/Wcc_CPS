package edu.wccnet.jopataylor.colleges;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "company")
public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "name")
	private String name;

	@ManyToMany()
	@JoinTable(name = "college_company", joinColumns = @JoinColumn(name = "company_id"), inverseJoinColumns = @JoinColumn(name = "college_id"))
	private List<College> colleges = new ArrayList<College>();

	public Company() {

	}

	public Company(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<College> getColleges() {
		return colleges;
	}

	public void setColleges(List<College> colleges) {
		this.colleges = colleges;
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", colleges=" + colleges + "]";
	}

	public void addCollege(College college) {
		colleges.add(college);
	}

	public void removeCollege(College college) {
		colleges.remove(college);
	}

}
