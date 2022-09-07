package com.code.main.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "model")
public class Model {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "model_name", nullable = false)
	private String model;

	@ManyToOne
	@JoinColumn(name = "make_id")
	private Make make;

	public Model() {
	}

	public Model(String model, Make make) {
		this.model = model;
		this.make = make;
	}

	public Integer getId() {
		return id;
	}

	public Make getMake() {
		return make;
	}

	public void setMake(Make make) {
		this.make = make;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Override
	public String toString() {
		return "Model [id=" + id + ", model=" + model + ", make=" + make + "]";
	}

}
