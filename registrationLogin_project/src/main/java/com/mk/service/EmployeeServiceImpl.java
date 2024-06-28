package com.mk.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mk.entity.Employee;
import com.mk.repo.EmployeeRepo;
import com.mk.requestDto.EmployeeRequestDto;
import com.mk.requestDto.LoginDTO;
import com.mk.responseDto.LoginResponse;


@Service
public class EmployeeServiceImpl implements IEmployeeService {
	
	@Autowired
	private EmployeeRepo empRepo;
	

	@Override
	public String addEmployee(EmployeeRequestDto employeeDto) {
		Employee emp=new Employee();
		emp.setEmail(employeeDto.getEmail());
		emp.setEmployeename(employeeDto.getEmployeename());
		emp.setPassword(employeeDto.getPassword());
		empRepo.save(emp);
		return "Employee saved with name " +employeeDto.getEmployeename();
	}


	@Override
	public String loginEmployee(LoginDTO loginDto) {
		Employee emp=empRepo.findByEmail(loginDto.getEmail());
		if(emp !=null) {
		String password1=loginDto.getPassword();
		String password2=emp.getPassword();
		if(password1.equals(password2)) {
			Optional<Employee> employee =empRepo.findOneByEmailAndPassword(loginDto.getEmail(), loginDto.getPassword());
			 if (employee.isPresent()) {
                 return "Login Success";
            } else {
                 return "Login Failed";
             }
         } else {
             return "password Not Match";
         }
     }else {
         return "Email not exits";
     }
		}
}
	

	
