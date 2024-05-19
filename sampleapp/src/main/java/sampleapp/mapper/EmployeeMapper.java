package sampleapp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import sampleapp.entity.Employee;

@Mapper
public interface EmployeeMapper {

    List<Employee> getAllEmployees();

    Employee getEmployeeById(int id);

    Employee getEmployeeByName(String username);

    void addEmployee(Employee employee);

    void updateEmployee(Employee employee);

    void deleteEmployee(int id);
}
