package com.codewithseema.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithseema.entity.Employee;

public interface EmpRepo extends JpaRepository<Employee, Integer>{

	public Employee findByEmail(String email);
}
