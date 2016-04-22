package com.jk.sprtest.model;

import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

public class CustomerVO {

	@Size(min=6,max=20)
	private String name;

	@NotEmpty
	@Email
	private String email;

	@NotNull
	@Min(value=18)
	@Max(value=100)
	private Integer age;
	@NotNull
	private Gender gender;
	
	
	@DateTimeFormat(pattern="mm/dd/yyyy")
	@NotNull(message="Date is required in mm/dd/yyyy pattern")
	@Past
	private Date birthDay;

	private String phone;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public enum Gender {
		MALE, FEMALE
	}
}
