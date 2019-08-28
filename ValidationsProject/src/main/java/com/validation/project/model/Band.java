package com.validation.project.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Band {
	
	@NotNull
	@NotBlank
	@NotEmpty
	@Size(min=5,max=10)
	@Pattern(regexp = "[a-zA-z0-9]+",message="EmployeeId must be Alphanumeric")
	String employeeId;
	
	String band;

	public Band() {
		
	}

	public Band(String employeeId, String band) {
		super();
		this.employeeId = employeeId;
		this.band = band;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getBand() {
		return band;
	}

	public void setBand(String band) {
		this.band = band;
	}

	@Override
	public String toString() {
		return "Band [employeeId=" + employeeId + ", band=" + band + "]";
	}
	
	

}
