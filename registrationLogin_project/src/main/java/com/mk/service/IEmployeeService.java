package com.mk.service;

import com.mk.requestDto.EmployeeRequestDto;
import com.mk.requestDto.LoginDTO;
import com.mk.responseDto.LoginResponse;

public interface IEmployeeService {
	
	public String addEmployee(EmployeeRequestDto employeeDto);
	
	public String loginEmployee(LoginDTO loginDto);

}
