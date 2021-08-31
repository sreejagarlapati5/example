package com.example.demo.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Customer.Customer;
import com.example.demo.Dao.CustomerDao;
import com.example.demo.Service.CustomerService;



@RestController
@RequestMapping("/Customers")
public class CustomerController {
	
	@Autowired
	private CustomerDao customerdao;
	
	@Autowired
	private CustomerService customerservice;
	
	@GetMapping
	public ResponseEntity<List<Customer>> getCustomer(){
		List<Customer> customers=customerservice.getCustomer();
		 return   ResponseEntity.ok(customers);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Customer>> getCustomerbyId(@PathVariable  int id){
	    Optional<Customer> customer=   customerservice.getCustomerbyId(id);	
	
		 return   ResponseEntity.ok(customer);
		
	}
	
	@GetMapping("/")
	public ResponseEntity<Customer> getCustomerbyName(@RequestParam  @Valid  String name){
	    Customer customer=   customerservice.getCustomerbyName(name);	
	
		 return   ResponseEntity.ok(customer);
		
	}
	
	
	@PostMapping
	public ResponseEntity<String> addCustomer(@RequestBody  @Valid  Customer c) {
		customerservice.addCustomer(c);
		List<Customer> customers=customerservice.getCustomer();
		return ResponseEntity.ok("Successfully Added\n"+customers);
	}
	
	@PutMapping
	public ResponseEntity<String> updateCustomer( @Valid  Customer c) {
		if(!customerdao.existsById(c.getId()))throw new DataIntegrityViolationException("Customer not found to update");
		customerservice.updateCustomer(c);
		List<Customer> customers=customerservice.getCustomer();
		return ResponseEntity.ok("Successfully Updated\n"+customers);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> removeCustomer(@PathVariable @Valid int id) {
		 if(!customerdao.existsById(id))throw new EmptyResultDataAccessException("Customer not found", id);
		customerdao.deleteById(id);
		List<Customer> customers=customerservice.getCustomer();
		return ResponseEntity.ok("Successfully Deleted\n"+customers);
	}

}
