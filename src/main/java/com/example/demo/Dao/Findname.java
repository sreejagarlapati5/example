package com.example.demo.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Customer.Customer;

@Repository
public interface Findname extends JpaRepository<Customer, String>{

}
