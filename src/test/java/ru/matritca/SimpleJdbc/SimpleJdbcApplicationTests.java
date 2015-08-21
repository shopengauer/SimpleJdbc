package ru.matritca.SimpleJdbc;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ru.matritca.SimpleJdbc.dao.employee.JdbcEmployeeDao;
import ru.matritca.SimpleJdbc.domain.Employee;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SimpleJdbcApplication.class)
@WebAppConfiguration
public class SimpleJdbcApplicationTests {


	@Autowired
	private JdbcEmployeeDao employeeDao;

	@Test
	public void contextLoads() {
		Employee insertEmployee = new Employee();
		insertEmployee.setEmployeeName("Wasiliy");
	    int i = employeeDao.createEmployee(insertEmployee);

		Employee findEmployee = new Employee();
		findEmployee = employeeDao.findEmployeeByName("Wasiliy");
		//Assert.assertEquals(insertEmployee.getEmployeeId(), findEmployee.getEmployeeId());
		Assert.assertEquals(insertEmployee.getEmployeeName(), findEmployee.getEmployeeName());


	}

}
