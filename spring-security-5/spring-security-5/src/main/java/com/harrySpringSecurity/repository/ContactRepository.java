package com.harrySpringSecurity.repository;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.harrySpringSecurity.entity.Contact;


@Repository
public interface ContactRepository extends CrudRepository<Contact, String> {
	
	
}
