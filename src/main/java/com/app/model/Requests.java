package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Requests {
	
	@Id
	@Column
	@GeneratedValue(generator ="request_id_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(allocationSize = 1, name = "request_id_seq", initialValue = 1, sequenceName="request_id_seq")
	private int requestId;
	
	
}
