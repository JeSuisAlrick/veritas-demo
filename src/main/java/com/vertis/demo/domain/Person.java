/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vertis.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author telfealr
 */
@Entity
@Table(name = "_PERSON")
public class Person extends DomainObject {
    @Column(name = "FIRST_NAME", columnDefinition = "VARCHAR(40)")
    private String firstName;
    
    @Column(name = "MIDDLE_NAME", columnDefinition = "VARCHAR(40)")
    private String middleName;
    
    @Column(name = "LAST_NAME", columnDefinition = "VARCHAR(40)")
    private String lastName;
    
    @Column(name = "USERNAME", columnDefinition = "VARCHAR(20)")
    private String username;
    
    @JsonIgnore
    @Column(name = "ENCRYPTED_PASSWORD", columnDefinition = "VARCHAR(2500)")
    private String encryptedPassword;
    
    @Embedded
    private Address address;
    
    @ManyToOne
    private Position position;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
