package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Branch {

	@Id
	@Column
	private int branchNum;
	@Column(unique = true)
	private String branchName;
	
	public Branch() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Branch(int branchNum, String branchName) {
		super();
		this.branchNum = branchNum;
		this.branchName = branchName;
	}
	public int getBranchNum() {
		return branchNum;
	}
	public void setBranchNum(int branchNum) {
		this.branchNum = branchNum;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((branchName == null) ? 0 : branchName.hashCode());
		result = prime * result + branchNum;
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
		Branch other = (Branch) obj;
		if (branchName == null) {
			if (other.branchName != null)
				return false;
		} else if (!branchName.equals(other.branchName))
			return false;
		if (branchNum != other.branchNum)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Branch [branchNum=" + branchNum + ", branchName=" + branchName + "]";
	}
	
	
	
}
