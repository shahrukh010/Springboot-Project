package com.code.main.model;

import java.util.HashSet;
import java.util.Set;

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
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;

@Entity
@Table(name = "make")
public class Make {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "make_name", nullable = false)
	private String name;

	@OneToMany(mappedBy = "make", fetch = FetchType.LAZY)
	private Set<Model> models;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "make_year", joinColumns = @JoinColumn(name = "make_id"), inverseJoinColumns = @JoinColumn(name = "year_id"))
	private Set<Year> makes = new HashSet<>();

	public Set<Year> getMakes() {
		return makes;
	}

	public void setMakes(Set<Year> makes) {
		this.makes = makes;
	}

	public Make() {
	}

	public Make(String name) {
		this.name = name;
	}

	public Make(int id) {
		this.id = id;
	}

	@OneToOne
	public Set<Model> getModels() {
		return models;
	}

	public void setModels(Set<Model> models) {
		this.models = models;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name + "";
	}

}
