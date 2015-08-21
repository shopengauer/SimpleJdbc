package ru.matritca.SimpleJdbc.dao.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import ru.matritca.SimpleJdbc.domain.Employee;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by vasiliy on 21.08.15.
 */
@Repository
public class JdbcEmployeeDao implements EmployeeDao {


    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private static final class EmployeeMapper implements RowMapper<Employee>{
        @Override
        public Employee mapRow(ResultSet resultSet, int i) throws SQLException {
            Employee employee = new Employee();
            employee.setEmployeeId(resultSet.getLong("employee_id"));
            employee.setEmployeeName(resultSet.getString("employee_name"));
            return employee;
        }
    }


    @Autowired
    public JdbcEmployeeDao(DataSource dataSource) {
       this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public int createEmployee(Employee employee) {

      String sql = "insert into users.employee (employee_id,employee_name) values (nextval('seq'),:employeeName)";
        SqlParameterSource parameterSource =
                new MapSqlParameterSource("employeeName",employee.getEmployeeName());

       return namedParameterJdbcTemplate.update(sql,parameterSource);
    }

    @Override
    public Employee findEmployeeByName(String employeeName) {

        String sql = "select * from users.employee where employee_name = :employeeName";
        SqlParameterSource parameterSource = new MapSqlParameterSource("employeeName",employeeName);

        return namedParameterJdbcTemplate.queryForObject(sql,parameterSource,new EmployeeMapper());
    }
}
