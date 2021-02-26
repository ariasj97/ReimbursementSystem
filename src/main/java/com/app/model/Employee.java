package com.app.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Employee {
	
	@Id
	@Column
	@GeneratedValue(generator ="user_id_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(allocationSize = 1, name = "user_id_seq", initialValue = 1, sequenceName="user_id_seq")
	private int userId;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userId", referencedColumnName = "userId")
	private EmployeeInfo employeeInfo;
	
	@Column
	private boolean manager;
}
