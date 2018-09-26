/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vertis.demo.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author telfealr
 */
@Embeddable
public class Address implements Serializable {
    @Column(name = "STREET_NUMBER", columnDefinition = "VARCHAR(15)")
    String streetNumber;
    @Column(name = "STREET_NAME", columnDefinition = "VARCHAR(120)")
    String streetName;
    @Column(name = "CITY", columnDefinition = "VARCHAR(40)")
    String city;
    @Column(name = "POSTAL_CODE", columnDefinition = "VARCHAR(15)")
    String postalCode;
    @Column(name = "COUNTRY_CODE", columnDefinition = "VARCHAR(3)")
    String countryCode;

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
    
}
