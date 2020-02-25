package com.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.dao.EmployeeDao;
import com.employee.entity.Employee;


@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDao employeeDaoImpl;

	@Override
	public void saveEmployee(Employee newEmployee) {
		employeeDaoImpl.saveEmployee(newEmployee);
	}

	@Override
	public Employee getById(int employeeId) {
		Employee savedEmployee = employeeDaoImpl.getById(employeeId);
		return savedEmployee;
	}

	@Override
	public Employee getByEmail(String email) {
		Employee savedEmployee = employeeDaoImpl.getByEmail(email);
		return savedEmployee;
	}

}
