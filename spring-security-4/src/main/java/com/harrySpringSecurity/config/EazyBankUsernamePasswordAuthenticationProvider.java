package com.harrySpringSecurity.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

import com.harrySpringSecurity.entity.Customers;
import com.harrySpringSecurity.repository.CustomerRepository;


@Component
public class EazyBankUsernamePasswordAuthenticationProvider implements AuthenticationProvider {
    
    @Autowired
    CustomerRepository customerRepository;
    
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String username = authentication.getName();
        String pwd = authentication.getCredentials().toString();

        List<Customers> customers = customerRepository.findByEmail(username);

        if (customers.size() > 0) {
            if (passwordEncoder.matches(pwd, customers.get(0).getPwd())) {
                List<GrantedAuthority> authorities = new ArrayList<>();
                authorities.add(new SimpleGrantedAuthority(customers.get(0).getRole()));

                return new UsernamePasswordAuthenticationToken(username, pwd, authorities);
                
            } else {
                throw new BadCredentialsException("Invalid passsword");
            }
        } else {
            throw new BadCredentialsException("No user registered with this details");
        }

        
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom((authentication)));
    }
    
}
