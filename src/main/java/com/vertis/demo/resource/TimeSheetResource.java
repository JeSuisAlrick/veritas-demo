/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vertis.demo.resource;

import com.vertis.demo.domain.TimeSheet;
import com.vertis.demo.service.TimeSheetService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author telfealr
 */
@RestController
@RequestMapping("/api/time-sheet/{id:[\\d]+}")
public class TimeSheetResource {
    @Autowired
    private TimeSheetService timeSheetService;
    
    @GetMapping
    public ResponseEntity get(@PathVariable("id") Long id) {
        Optional<TimeSheet> timeSheet = timeSheetService.findTimeSheetById(id);
        return timeSheet.isPresent() ? 
                new ResponseEntity<>(timeSheet.get(), HttpStatus.OK) : 
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @PutMapping
    public ResponseEntity update(@PathVariable("id") Long id, TimeSheet timeSheet) {
        TimeSheet updateTimeSheet = timeSheetService.updateTimeSheet(id, timeSheet);
        
        return updateTimeSheet != null ? 
                new ResponseEntity<>(updateTimeSheet, HttpStatus.OK) : 
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @DeleteMapping
    public ResponseEntity deleteTimeSheet(@PathVariable("id") Long id) {
        return timeSheetService.deleteTimeSheet(id) ? 
                new ResponseEntity(HttpStatus.OK) : 
                new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
