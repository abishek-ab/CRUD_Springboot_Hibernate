package com.hibernate.department.department_hibernate.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hibernate.department.department_hibernate.Model.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDAO {

	@Autowired
	private EntityManager entityManager;
	

	@Override
	@Transactional
	public Employee getEmployeeById(int id) {
		Session session=entityManager.unwrap(Session.class);
		return session.get(Employee.class, id);
	}

	@Override
	@Transactional
	public void updateEmployeeById(Employee employee) {
		Session session=entityManager.unwrap(Session.class);
		session.saveOrUpdate(employee);
	}

	@Override
	@Transactional
	public void deleteEmployeeById(int id) {
		Session session=entityManager.unwrap(Session.class);
		Query query=session.createQuery("delete from Employee where id=:empId");
		query.setParameter("empId", id);
		query.executeUpdate();
		
	}
	
	@Override
	@Transactional
	public List<Employee> getAllEmployees() {
		Session session=entityManager.unwrap(Session.class);
		return session.createQuery("SELECT e from Employee e",Employee.class).getResultList();
	}

}
