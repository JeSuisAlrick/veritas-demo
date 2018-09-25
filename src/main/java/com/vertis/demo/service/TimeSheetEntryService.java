/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vertis.demo.service;

import com.vertis.demo.domain.TimeSheet;
import com.vertis.demo.domain.TimeSheetEntry;
import com.vertis.demo.repository.TimeSheetEntryRepository;
import com.vertis.demo.repository.TimeSheetRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author telfealr
 */
@Service
public class TimeSheetEntryService {
    @Autowired
    private TimeSheetRepository timeSheetRepository;
    @Autowired
    private TimeSheetEntryRepository timeSheetEntryRepository;
    @Autowired
    private PersonService personService;
    
    public List<TimeSheetEntry> findByTimeSheetId(Long timeSheetId) {
        return timeSheetEntryRepository.findByTimeSheet_Id(timeSheetId);
    }
    
    public TimeSheetEntry findOne(Long timeSheetId, Long entryId) {
        return timeSheetEntryRepository.findByIdAndTimeSheet_Id(timeSheetId, entryId);
    }
    
    public TimeSheetEntry create(Long timeSheetId, TimeSheetEntry timeSheetEntry) {
        Optional<TimeSheet> timeSheet = timeSheetRepository.findById(timeSheetId);
        if (timeSheet.isPresent()) {
            timeSheetEntry.setTimeSheet(timeSheet.get());
            return timeSheetEntryRepository.saveAndFlush(timeSheetEntry);
        } else {
            return null;
        }
    }
    
    public TimeSheetEntry update(Long timeSheetId, Long entryId, TimeSheetEntry timeSheetEntry) {
        TimeSheetEntry existingEntry = timeSheetEntryRepository.findByIdAndTimeSheet_Id(timeSheetId, entryId);
        if (existingEntry != null) {
            BeanUtils.copyProperties(timeSheetEntry, existingEntry, "id");
            return timeSheetEntryRepository.saveAndFlush(existingEntry);
        } else {
            return null;
        }
    }
    
    public boolean deleteOne(Long timeSheetId, Long entryId, TimeSheetEntry timeSheetEntry) {
        TimeSheetEntry existingTimeSheetEntry = timeSheetEntryRepository.findByIdAndTimeSheet_Id(timeSheetId, entryId);
        if (existingTimeSheetEntry != null) {
            timeSheetEntryRepository.deleteByIdAndTimeSheet_Id(timeSheetId, entryId);
            return true;
        } else {
            return false;
        }
    }
}
