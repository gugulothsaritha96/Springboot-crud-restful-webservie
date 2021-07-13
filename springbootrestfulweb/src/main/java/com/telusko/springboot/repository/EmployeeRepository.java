package com.telusko.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.telusko.springboot.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long>{

}
