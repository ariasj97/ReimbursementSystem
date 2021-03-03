package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {
	
	@Id
	@Column
	@GeneratedValue(generator ="user_id_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(allocationSize = 1, name = "user_id_seq", initialValue = 1, sequenceName="user_id_seq")
	private int userId;
	
	@Column
	private String fName;
	
	@Column
	private String lName;
	
	@Column
	private String streetAddress;
	
	@Column
	private int phoneNumber;
	 
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn (name="managerId")
	private Manager managerId;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int userId, String fName, String lName, String streetAddress, int phoneNumber, Manager managerId) {
		super();
		this.userId = userId;
		this.fName = fName;
		this.lName = lName;
		this.streetAddress = streetAddress;
		this.phoneNumber = phoneNumber;
		this.managerId = managerId;
	}
	public Employee(int userId, String fName, String lName, String streetAddress, int phoneNumber) {
		super();
		this.userId = userId;
		this.fName = fName;
		this.lName = lName;
		this.streetAddress = streetAddress;
		this.phoneNumber = phoneNumber;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Manager getManagerId() {
		return managerId;
	}

	public void setManagerId(Manager managerId) {
		this.managerId = managerId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fName == null) ? 0 : fName.hashCode());
		result = prime * result + ((lName == null) ? 0 : lName.hashCode());
		result = prime * result + ((managerId == null) ? 0 : managerId.hashCode());
		result = prime * result + phoneNumber;
		result = prime * result + ((streetAddress == null) ? 0 : streetAddress.hashCode());
		result = prime * result + userId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (fName == null) {
			if (other.fName != null)
				return false;
		} else if (!fName.equals(other.fName))
			return false;
		if (lName == null) {
			if (other.lName != null)
				return false;
		} else if (!lName.equals(other.lName))
			return false;
		if (managerId == null) {
			if (other.managerId != null)
				return false;
		} else if (!managerId.equals(other.managerId))
			return false;
		if (phoneNumber != other.phoneNumber)
			return false;
		if (streetAddress == null) {
			if (other.streetAddress != null)
				return false;
		} else if (!streetAddress.equals(other.streetAddress))
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Employee [userId=" + userId + ", fName=" + fName + ", lName=" + lName + ", streetAddress="
				+ streetAddress + ", phoneNumber=" + phoneNumber + ", managerId=" + managerId + "]";
	}
	
	
	
	
	
}
