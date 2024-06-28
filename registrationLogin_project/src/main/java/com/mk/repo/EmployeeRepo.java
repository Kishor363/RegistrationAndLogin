package com.mk.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mk.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
	
	public Employee findByEmail(String email);
	
	public Optional<Employee> findOneByEmailAndPassword(String email,String password);

	

}
