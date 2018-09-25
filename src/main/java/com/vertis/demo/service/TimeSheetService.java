/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vertis.demo.service;

import com.vertis.demo.domain.TimeSheet;
import com.vertis.demo.repository.TimeSheetEntryRepository;
import com.vertis.demo.repository.TimeSheetRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author telfealr
 */
@Service
public class TimeSheetService {
    @Autowired
    private TimeSheetRepository timeSheetRepository;
    @Autowired
    private TimeSheetEntryRepository timeSheetEntryRepository;
    @Autowired
    private PersonService personService;
    
    // TimeSheet methods
    public List<TimeSheet> findAll() {
        return timeSheetRepository.findAll();
    }
    
    public List<TimeSheet> findAllByOwner(Long personId) {
        return timeSheetRepository.findByOwner_Id(personId);
    }
    
    public TimeSheet findOne(Long id) {
        return timeSheetRepository.findById(id).get();
    }
    
    public TimeSheet create(TimeSheet timeSheet) {
        // TODO: Get currently logged in user
        return timeSheetRepository.saveAndFlush(timeSheet);
    }
    
    public TimeSheet update(Long id, TimeSheet timeSheet) {
        // TODO: Prevent modification by user who isn't owner
        TimeSheet existingTimeSheet = timeSheetRepository.findById(id).get();
        if (existingTimeSheet != null) {
            existingTimeSheet.setClient(timeSheet.getClient());
            // TODO: Get currently logged in user
            existingTimeSheet.setOwner(timeSheet.getOwner());
            existingTimeSheet.setTitle(timeSheet.getTitle());
            return timeSheetRepository.saveAndFlush(existingTimeSheet);
        } else {
            return null;
        }
    }
    
    public boolean deleteOne(Long id) {
        // TODO: Get currently logged in user
        TimeSheet existingTimeSheet = timeSheetRepository.findById(id).get();
        if (existingTimeSheet != null) {
            timeSheetRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
