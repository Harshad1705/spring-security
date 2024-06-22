package com.harrySpringSecurity.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.harrySpringSecurity.entity.Customer;

import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {

    List<Customer> findByEmail(String email);
    
}
