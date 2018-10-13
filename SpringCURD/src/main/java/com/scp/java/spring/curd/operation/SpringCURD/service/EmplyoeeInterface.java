package com.scp.java.spring.curd.operation.SpringCURD.service;

import java.util.List;

import com.scp.java.spring.curd.operation.SpringCURD.entityclass.Employee;
import com.scp.java.spring.curd.operation.SpringCURD.exception.RecordNotFound;

public interface EmplyoeeInterface {
	public void addEmployee(Employee e);
	public void updateEmployee(Employee e) throws RecordNotFound;
	public void deleteEmployee(int id) throws RecordNotFound;
	public Employee getSingleEmp(int id) throws RecordNotFound;
	public List<Employee> allEmployee();

}
