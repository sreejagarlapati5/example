package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Customer.Customer;
import com.example.demo.Dao.CustomerDao;
import com.example.demo.Dao.Findname;
import com.example.demo.exceptionclass.CustomerNotFoundException;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerDao customerdao;
	
	@Autowired
	private Findname findname;
	
	
	public List<Customer> getCustomer(){
		return (List<Customer>) customerdao.findAll();
		
	}
	
	public void addCustomer(Customer customer) {
		customerdao.save(customer);
		
	}
	
	public void updateCustomer(Customer customer) {
		customerdao.save(customer);
	}
	
	public void deleteCustomer(int id) {
		customerdao.deleteById(id);
	}

	public Optional<Customer> getCustomerbyId(int id) {
		return customerdao.findById(id);
		
		
	}

	public Customer getCustomerbyName(String name) {
	// List<Customer> customer=Findname.findAllById(name);
		
		List<Customer> c=(List<Customer>) customerdao.findAll();
		for(Customer cus:c) {
			if(cus.getName().equals(name)) {
				return cus;
			}
			
		}
		throw new CustomerNotFoundException("Customer Not found by the name texted");
    
	}
	
	
	
	
	
	

}
