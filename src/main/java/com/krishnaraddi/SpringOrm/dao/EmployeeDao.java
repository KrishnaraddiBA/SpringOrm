package com.krishnaraddi.SpringOrm.dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.krishnaraddi.SpringOrm.entity.Employee;

import jakarta.transaction.Transactional;

public class EmployeeDao {
	
	
	
	private HibernateTemplate hibernateTemplate;
	@Transactional
	public int insertData(Employee emp) {
		
		Integer i=(Integer)hibernateTemplate.save(emp);
		
		return i;
	}
	@Transactional
	public void deleteData(Employee emp) {
		hibernateTemplate.delete(emp);
	}
	
	@Transactional
	public void updateData(Employee emp) {
		hibernateTemplate.update(emp);
	}
	
	public Employee fetchData(int id) {
		
		Employee employee = hibernateTemplate.get(Employee.class, id);
		return employee;
	}
	
	public List<Employee> fetchAll(){
		
		List<Employee> loadAll = hibernateTemplate.loadAll(Employee.class);
		return loadAll;
	}
	
	
	
	
}
