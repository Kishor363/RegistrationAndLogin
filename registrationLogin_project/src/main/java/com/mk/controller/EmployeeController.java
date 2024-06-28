package com.mk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mk.requestDto.EmployeeRequestDto;
import com.mk.requestDto.LoginDTO;
import com.mk.responseDto.LoginResponse;
import com.mk.service.IEmployeeService;

@RestController
//@CrossOrigin
@RequestMapping("api/v1/employee")
public class EmployeeController {
	
	@Autowired
	private IEmployeeService employeeService;
	
	  @PostMapping(path = "/save")
	    public ResponseEntity<?> saveEmployee(@RequestBody EmployeeRequestDto employeeDTO){
	        String msg = employeeService.addEmployee(employeeDTO);
	        return ResponseEntity.ok(msg);
	    }
	  
	    @PostMapping(path = "/login" ,produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<?> loginEmployee(@RequestBody LoginDTO loginDTO)
	    {
	    	String msg = employeeService.loginEmployee(loginDTO);
	    	
	    	LoginResponse logres=new LoginResponse();
	    	logres.setMessage(msg);
	    	Boolean status=(msg.equals("Login Success")?true:false);
	    	logres.setStatus(status);
	        return ResponseEntity.ok(logres);
	    }

}
