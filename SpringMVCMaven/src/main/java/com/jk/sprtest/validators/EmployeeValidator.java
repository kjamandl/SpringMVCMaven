package com.jk.sprtest.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.jk.sprtest.model.Employee;

public class EmployeeValidator implements Validator{

	
	public boolean supports(Class<?> paramClass) {
		return Employee.class.equals(paramClass);
	}
	
	public void validate(Object obj, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "id", "id.required");
		ValidationUtils.rejectIfEmpty(errors, "name", "id.required");
		ValidationUtils.rejectIfEmpty(errors, "role", "id.required");
		
		Employee emp = (Employee) obj;
		if(emp.getId() < 0){
			errors.rejectValue("id", "negativevalue", new Object[]{"'id'"}, "id can not be negative");
		}
	}

}
