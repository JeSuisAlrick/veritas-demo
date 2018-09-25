/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vertis.demo.service;

import com.vertis.demo.domain.Client;
import com.vertis.demo.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author telfealr
 */
@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;
    
    public Client findOne(Long id) {
        return clientRepository.findById(id).get();
    }
}
