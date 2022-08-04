package az.spring.jdbc;

import az.spring.jdbc.config.SpringJdbcConfig;
import az.spring.jdbc.dao.EmployeeDao;
import az.spring.jdbc.model.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JdbcApplication {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringJdbcConfig.class);
        EmployeeDao employeeDao = context.getBean(EmployeeDao.class);

        Employee emp = new Employee();
        emp.setId(3);
        emp.setName("Elvin");
        emp.setSurname("Mammadov");
        emp.setAge(32);
        emp.setSalary(3500);

        employeeDao.update(emp);

        long count = employeeDao.count();
        System.out.println("count: " + count);

        Employee employeeById = employeeDao.getEmployeeById(1);
        System.out.println(employeeById);

        System.out.println(employeeDao.getAllEmployees());
    }
}
