package ru.matritca.SimpleJdbc.dao.employee;

import ru.matritca.SimpleJdbc.domain.Employee;

/**
 * Created by vasiliy on 21.08.15.
 */
public interface EmployeeDao {

     int createEmployee(Employee employee);
     Employee findEmployeeByName(String employeeName);
}
