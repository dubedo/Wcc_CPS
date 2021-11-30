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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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

	@ManyToMany()
	@JoinTable(name = "college_company", joinColumns = @JoinColumn(name = "college_id"), inverseJoinColumns = @JoinColumn(name = "company_id"))
	private List<Company> companies = new ArrayList<Company>();

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

	public List<Company> getCompanies() {
		return companies;
	}

	public void setCompanies(List<Company> companies) {
		this.companies = companies;
	}

	@Override
	public String toString() {
		return "College [id=" + id + ", name=" + name + "]";
	}

	public void addCampus(Campus newCampus) {
		campuses.add(newCampus);
		newCampus.setCollege(this);
	}

	public void removeCampus(Campus campus) {
		campuses.remove(campus);
	}

	public void addCompany(Company company) {
		companies.add(company);
	}

	public void removeCompany(Company company) {
		companies.remove(company);
	}

}
