package com.validation.project.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Band {
	@NotBlank(message="EmployeeId shouldn't be blank/whitespace")
	@Size(min=1,max=10)
	@Pattern(regexp = "[A-Z 0-9]+",message="EmployeeId must be Alphanumeric")
	//@Pattern(regexp = "[null]",message="EmployeeId Shouldn't be null")
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
