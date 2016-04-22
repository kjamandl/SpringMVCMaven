package com.jk.sprtest.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.jk.sprtest.model.CustomerVO;


@Component
public class CustomerValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		
		return CustomerVO.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		CustomerVO customerVO = (CustomerVO) target; 
		String myemail = customerVO.getEmail();
		if(myemail.endsWith("@gmail.com")){
			errors.rejectValue("email", "error.email", "Gmail is not allowed.");
		}
		System.out.println("CustomerValidator.validate()");		
	}


}
