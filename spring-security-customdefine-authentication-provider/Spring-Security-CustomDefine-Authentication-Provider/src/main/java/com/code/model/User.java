package com.code.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "customers")
@Data
public class User {

	@Id
	@GeneratedValue
	private int id;
	@Column(length = 30, nullable = false)
	private String email;
	@Column(length = 60, nullable = false)
	private String passwd;
	@Column(length = 20, nullable = false)
	private String role;

}
