package com.mohit.springboot.CRUD.dao;
import java.util.List;

import com.mohit.springboot.CRUD.entity.Employee;
public interface EmployeeDAO {
	public List<Employee> findAll();
	public Employee findById(int theId);
	public void save(Employee theEmployee);
	public void deleteById(int theId);
}
