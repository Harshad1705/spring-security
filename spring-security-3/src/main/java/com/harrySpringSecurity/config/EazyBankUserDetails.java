package com.harrySpringSecurity.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.harrySpringSecurity.entity.Customers;
import com.harrySpringSecurity.repository.CustomerRepository;

@Service
public class EazyBankUserDetails implements UserDetailsService {
    
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        String userName, password = null;
        List<GrantedAuthority> authorities = null;

        List<Customers> customers = customerRepository.findByEmail(username);
        

        if (customers.size() == 0) {
            throw new UsernameNotFoundException("User detail not found for the user : " + username);
        } else {
            userName = customers.get(0).getEmail();
            password = customers.get(0).getPwd();
            authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority(customers.get(0).getRole()));
        }

        return new User(userName, password, authorities);
        
    }
    
}
