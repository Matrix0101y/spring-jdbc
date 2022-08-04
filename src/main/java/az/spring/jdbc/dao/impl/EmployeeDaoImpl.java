package az.spring.jdbc.dao.impl;

import az.spring.jdbc.dao.EmployeeDao;
import az.spring.jdbc.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public EmployeeDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void insert(Employee employee) {
        String query = "insert into employee(name,surname,age,salary) values(?,?,?,?)";
        jdbcTemplate.update(query, employee.getName(), employee.getSurname(), employee.getAge(), employee.getSalary());
    }

    @Override
    public void update(Employee employee) {
        String query = "update employee set name=?, surname=?, age=?,salary=? where id=?";
        jdbcTemplate.update(query, employee.getName(), employee.getSurname(), employee.getAge(), employee.getSalary(), employee.getId());
    }

    @Override
    public void delete(int id) {
        String query = "delete from employee where id=?";
        jdbcTemplate.update(query, id);
    }

    @Override
    public Employee getEmployeeById(int id) {
        String query = "select * from employee where id=?";
        Employee employee = jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<Employee>(Employee.class), id);
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        String sql = "select * from employee";
        List<Employee> employees = jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Employee.class));
        return employees;
    }

    @Override
    public long count() {
        String query = "select count(*) from employee";
        long count = jdbcTemplate.queryForObject(query, Long.class);
        return count;
    }
}
