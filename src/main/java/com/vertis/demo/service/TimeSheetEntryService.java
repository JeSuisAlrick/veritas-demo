/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vertis.demo.service;

import com.vertis.demo.domain.Person;
import com.vertis.demo.domain.TimeSheet;
import com.vertis.demo.domain.TimeSheetEntry;
import com.vertis.demo.repository.TimeSheetEntryRepository;
import com.vertis.demo.repository.TimeSheetRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author telfealr
 */
public class TimeSheetService {
    @Autowired
    private TimeSheetRepository timeSheetRepository;
    @Autowired
    private TimeSheetEntryRepository timeSheetEntryRepository;
    
    // TimeSheet methods
    public List<TimeSheet> findTimeSheets(Long personId) {
        return timeSheetRepository.findAll(personId);
    }
    
    public List<TimeSheet> findTimeSheetsByOwner(Long personId) {
        return timeSheetRepository.findByOwner_Id(personId);
    }
    
    public Optional<TimeSheet> findTimeSheetById(Long id) {
        return timeSheetRepository.findById(id);
    }
    
    public TimeSheet updateTimeSheet(Long id, TimeSheet timeSheet) {
        TimeSheet existingTimeSheet = timeSheetRepository.findById(id).get();
        if (existingTimeSheet != null) {
            existingTimeSheet.setClient(timeSheet.getClient());
            existingTimeSheet.setOwner(timeSheet.getOwner());
            existingTimeSheet.setTitle(timeSheet.getTitle());
            return timeSheetRepository.saveAndFlush(existingTimeSheet);
        } else {
            return null;
        }
    }
    
    public boolean deleteTimeSheet(Long id) {
        TimeSheet existingTimeSheet = timeSheetRepository.findById(id).get();
        if (existingTimeSheet != null) {
            timeSheetRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
    
    // TimeSheetEntry methods
    public List<TimeSheetEntry> findTimeSheetEntries(Long timeSheetId) {
        return timeSheetEntryRepository.findByTimeSheet_Id(timeSheetId);
    }
    
    public TimeSheetEntry findTimeSheetEntry(Long timeSheetId, Long entryId) {
        return timeSheetEntryRepository.findByIdAndTimeSheet_Id(timeSheetId, entryId);
    }
    
    public TimeSheetEntry updateTimeSheetEntry(Long timeSheetId, Long entryId, TimeSheetEntry timeSheetEntry) {
        return timeSheetEntryRepository.findByIdAndTimeSheet_Id(timeSheetId, entryId);
    }
    
    public boolean deleteTimeSheetEntry(Long timeSheetId, Long entryId, TimeSheetEntry timeSheetEntry) {
        TimeSheetEntry existingTimeSheetEntry = timeSheetEntryRepository.findByIdAndTimeSheet_Id(timeSheetId, entryId);
        if (existingTimeSheetEntry != null) {
            timeSheetEntryRepository.deleteByIdAndTimeSheet_Id(timeSheetId, entryId);
            return true;
        } else {
            return false;
        }
    }
}
