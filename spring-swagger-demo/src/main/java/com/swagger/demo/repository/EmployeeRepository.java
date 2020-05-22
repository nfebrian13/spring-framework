package com.swagger.demo.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.swagger.demo.model.Employee;

public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {
}
