package com.mohit.springboot.CRUD.service;
import java.util.List;

import com.mohit.springboot.CRUD.entity.Employee;

public interface EmployeeService {
	public List<Employee> findAll();
	public Employee findById(int theId);
	public void save(Employee theEmployee);
	public void deleteById(int theId);

}
