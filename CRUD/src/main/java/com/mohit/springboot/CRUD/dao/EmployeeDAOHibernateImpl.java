package com.mohit.springboot.CRUD.dao;

import java.util.List;

import javax.persistence.EntityManager;


//import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;

import com.mohit.springboot.CRUD.entity.Employee;
@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {
	private EntityManager entityManager;
	@Autowired
	public EmployeeDAOHibernateImpl(EntityManager theEntityManager) {
		this.entityManager = theEntityManager;
	}
	
	@Override
	
	public List<Employee> findAll() {
		Session cs = entityManager.unwrap(Session.class);
		Query<Employee> q = cs.createQuery("from Employee",Employee.class);
		List<Employee> l = q.getResultList();
		return l;
		
		
	}

	@Override
	public Employee findById(int theId) {
		// TODO Auto-generated method stub
		Session cs = entityManager.unwrap(Session.class);
		Employee emp = cs.get(Employee.class, theId);
		return emp;
		
		
	}

	@Override
	public void save(Employee theEmployee) {
		// TODO Auto-generated method stub
		Session cs = entityManager.unwrap(Session.class);
		cs.saveOrUpdate(theEmployee);
		
	}

	@Override
	public void deleteById(int theId) {
		// TODO Auto-generated method stub
		Session cs = entityManager.unwrap(Session.class);
		Query q = cs.createQuery("delete from Employee where id=:employeeId");
		q.setParameter("employeeId", theId);
		q.executeUpdate();
		
	}

}
