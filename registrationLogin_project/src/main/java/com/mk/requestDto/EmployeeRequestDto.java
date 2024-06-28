package com.mk.requestDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRequestDto {
	 
	private Integer employeeid;
	 private String employeename;
	 private String email;
	 private String password;
	 
	 public Integer getEmployeeid() {
			return employeeid;
		}
		public void setEmployeeid(Integer employeeid) {
			this.employeeid = employeeid;
		}
		public String getEmployeename() {
			return employeename;
		}
		public void setEmployeename(String employeename) {
			this.employeename = employeename;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}

}
