package edu.wccnet.jopataylor.colleges;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "college")
public class College {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "college_name")
	private String name;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id")
	private CollegeAddress collegeAddress;

	public College() {

	}

	public College(String name) {
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

	public CollegeAddress getCollegeAddress() {
		return collegeAddress;
	}

	public void setCollegeAddress(CollegeAddress collegeAddress) {
		this.collegeAddress = collegeAddress;
	}

	@Override
	public String toString() {
		return "College [id=" + id + ", name=" + name + "]";
	}

}
