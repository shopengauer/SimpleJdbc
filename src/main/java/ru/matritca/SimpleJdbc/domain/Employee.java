package ru.matritca.SimpleJdbc.domain;

/**
 * Created by vasiliy on 21.08.15.
 */
public class Employee {

    private Long employeeId;
    private String employeeName;


    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }
}
