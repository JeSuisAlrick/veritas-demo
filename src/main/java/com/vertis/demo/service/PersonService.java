/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vertis.demo.service;

import com.vertis.demo.domain.Person;
import com.vertis.demo.repository.PersonRepository;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author telfealr
 */
@Service
public class PersonService implements UserDetailsService {
    @Autowired
    private PersonRepository personRepository;
    
    public Person findOne(Long id) {
        return personRepository.findById(id).get();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Person person = personRepository.findByUsername(username);

        if (person != null) {
            return new org.springframework.security.core.userdetails.User(
                person.getUsername(), person.getEncryptedPassword(), getAuthorities());
        } else {
            throw new UsernameNotFoundException("could not find the user '" + username + "'");
        }

    }

    private Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("USER_ROLE"));
        return authorities;
    }
}
