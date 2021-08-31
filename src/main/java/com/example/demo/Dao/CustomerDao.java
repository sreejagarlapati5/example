package com.example.demo.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Customer.Customer;

@Repository
public interface CustomerDao extends CrudRepository<Customer, Integer>{

	//List<Customer> findByName(String string);

}
