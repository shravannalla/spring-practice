package com.shravan.springboot.cruddemo.dao;

import com.shravan.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    public List<Employee> findAll();

    public Employee findByid(int theId);

    public void save(Employee theEmployee);

    public void deleteByid(int theId);

}
