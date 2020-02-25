package com.employee.service;

import static org.mockito.Mockito.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.employee.dao.EmployeeDao;
import com.employee.entity.Employee;

@ContextConfiguration("classpath:service-context.xml")
@RunWith(SpringRunner.class)
public class EmployeeServiceImplTest {
	
	@Mock
	private EmployeeDao employeeDaoImpl;

	@Before
	public void setUp() throws Exception {
		employeeDaoImpl = mock(EmployeeDao.class);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void saveEmployeeTest() {
		Employee tempEmployee = new Employee();
		doNothing().when(employeeDaoImpl).saveEmployee(isA(Employee.class));
		employeeDaoImpl.saveEmployee(tempEmployee);
		verify(employeeDaoImpl, times(1)).saveEmployee(tempEmployee);
	}
	
	@Test
	public void getEmployeeByIdTest() {
		Employee tempEmployee = new Employee();
		when(employeeDaoImpl.getById(1)).thenReturn(tempEmployee);
		employeeDaoImpl.getById(1);
		verify(employeeDaoImpl, times(1)).getById(1);
	}
	
	@Test
	public void getEmployeeByEmailTest() {
		Employee tempEmployee = new Employee();
		when(employeeDaoImpl.getByEmail("test@mail")).thenReturn(tempEmployee);
		employeeDaoImpl.getByEmail("test@mail");
		verify(employeeDaoImpl, times(1)).getByEmail("test@mail");
	}

}
