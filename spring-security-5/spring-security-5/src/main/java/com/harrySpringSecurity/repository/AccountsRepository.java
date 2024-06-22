package com.harrySpringSecurity.repository;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.harrySpringSecurity.entity.Accounts;


@Repository
public interface AccountsRepository extends CrudRepository<Accounts, Long> {
	
	Accounts findByCustomerId(int customerId);

}
