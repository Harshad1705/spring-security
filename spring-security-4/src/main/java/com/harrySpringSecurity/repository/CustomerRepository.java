package com.harrySpringSecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.harrySpringSecurity.entity.Customers;
import java.util.List;


@Repository
public interface CustomerRepository extends CrudRepository<Customers, Integer> {

    List<Customers> findByEmail(String email);
}
 