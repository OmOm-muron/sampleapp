package sampleapp.service;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import sampleapp.entity.Employee;
import sampleapp.mapper.EmployeeMapper;

@Service
public class EmployeeService {

    private final EmployeeMapper employeeMapper;

    public EmployeeService(EmployeeMapper employeeMapper) {
        this.employeeMapper = employeeMapper;
    }

    public List<Employee> getAllEmployees() {
        return employeeMapper.getAllEmployees();
    }

    public Employee getEmployeeById(int id) {
        return employeeMapper.getEmployeeById(id);
    }
    
    public Employee getEmployeeByName(String username) {
        return employeeMapper.getEmployeeByName(username);
    }

    public void addEmployee(Employee employee) {
        // Encrypt password
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String password = employee.getPassword();
        employee.setPassword(encoder.encode(password));
        employeeMapper.addEmployee(employee);
    }

    public void updateEmployee(Employee employee) {
        // Encrypt password
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String password = employee.getPassword();
        employee.setPassword(encoder.encode(password));
        employeeMapper.updateEmployee(employee);
    }

    public void deleteEmployee(int id) {
        employeeMapper.deleteEmployee(id);
    }
}
