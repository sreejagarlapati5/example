package com.example.demo.Customer;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;

import lombok.Data;
import lombok.NonNull;


@Data
@Entity
public class Customer {
	
	@Id
    @NotNull(message="Enter Id Field")
	@Min(value=0)
	@Max(value=1000)
	private int id;
	
	@NotEmpty(message="please Enter your name")
	@Pattern(regexp="[A-Z]{8,10}",message="Please enter 8-10 character name without special Characters")
	private String name;

	
	@NotEmpty(message="Enter Mail Id")
	@Email(message="Enter valid email id")
	private String email;
	
	
	
	

}
