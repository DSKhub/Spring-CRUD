package com.scp.java.spring.curd.operation.SpringCURD.entityclass;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Employee_Hib_spring")
public class Employee {
	@Id
	@Column(name = "Emp_Id", unique = true, nullable = false)
	private int empId;
	
	@Column(nullable=false)
	private String empName;
	
	@Column(nullable=false)
	private String empAddress;
	
	@Column(nullable=false)
	private double empSalary;
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpAddress() {
		return empAddress;
	}
	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}
	public double getEmpSalary() {
		return empSalary;
	}
	public void setEmpSalary(double empSalary) {
		this.empSalary = empSalary;
	}
	@Override
	public String toString() {
		return "\n Employee [empId=" + empId + ", empName=" + empName + ", empAddress=" + empAddress + ", empSalary="
				+ empSalary + "]";
	}
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
