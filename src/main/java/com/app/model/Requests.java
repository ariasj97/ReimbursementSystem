package com.app.model;

import java.sql.Date;

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
@Table(name = "requests")
public class Requests {
	
	@Id
	@Column
	@GeneratedValue(generator ="request_id_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(allocationSize = 1, name = "request_id_seq", initialValue = 3, sequenceName="request_id_seq")
	private int requestId;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn (name="userId")
	private Employee userId;
	
	@Column 
	private boolean status = false;
	
	@Column 
	private double amount;
	
	@Column 
	private Date date;

	public Requests() {
		super();
		// TODO Auto-generated constructor stub
	}	
	
	public int getRequestId() {
		return requestId;
	}
	
	public Requests(int requestId, Employee userId, boolean status, double amount, Date date) {
		super();
		this.requestId = requestId;
		this.userId = userId;
		this.status = status;
		this.amount = amount;
		this.date = date;
	}
	
	public Requests(Employee userId, boolean status, double amount, Date date) {
		super();
		this.userId = userId;
		this.status = status;
		this.amount = amount;
		this.date = date;
	}



	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public Employee getUserId() {
		return userId;
	}

	public void setUserId(Employee userId) {
		this.userId = userId;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + requestId;
		result = prime * result + (status ? 1231 : 1237);
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
		Requests other = (Requests) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (requestId != other.requestId)
			return false;
		if (status != other.status)
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Requests [requestId=" + requestId + ", userId=" + userId + ", status=" + status + ", amount=" + amount
				+ ", date=" + date + "]";
	}
	
	
	
	
}
