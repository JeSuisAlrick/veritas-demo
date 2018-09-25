/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vertis.demo.domain;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author telfealr
 */
@Entity
@Table(name = "_TIME_SHEET")
public class TimeSheet extends DomainObject {
    @Column(name = "TITLE")
    private String title;
    
    @ManyToOne
    private Client client;
    
    @ManyToOne
    private Person owner;
    
    @OneToMany(mappedBy = "timeSheet")
    private List<TimeSheetEntry> entries;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public List<TimeSheetEntry> getEntries() {
        return entries;
    }

    public void setEntries(List<TimeSheetEntry> entries) {
        this.entries = entries;
    }
    
    
}
