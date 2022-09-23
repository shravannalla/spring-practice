package com.shravan.springboot.thymeleafdemo.dao;

import com.shravan.springboot.thymeleafdemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    //that's it ... no need to write any code!

}
