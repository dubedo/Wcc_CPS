package edu.wccnet.jopataylor.colleges;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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

	@OneToMany(mappedBy = "college", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Campus> campuses = new ArrayList<Campus>();

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

	public List<Campus> getCampuses() {
		return campuses;
	}

	public void setCampuses(List<Campus> campuses) {
		this.campuses = campuses;
	}

	@Override
	public String toString() {
		return "College [id=" + id + ", name=" + name + "]";
	}

	public void add(Campus newCampus) {
		campuses.add(newCampus);
		newCampus.setCollege(this);
	}

	public void remove(Campus campus) {
		campuses.remove(campus);
	}

}
