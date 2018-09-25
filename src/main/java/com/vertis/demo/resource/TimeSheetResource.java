/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vertis.demo.resource;

import com.vertis.demo.domain.TimeSheet;
import com.vertis.demo.service.TimeSheetService;
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
@RequestMapping("/api/person/{pid:[\\d]+}/time-sheet/{id:[\\d]+}")
public class TimeSheetResource {
    @Autowired
    private TimeSheetService timeSheetService;
    
    @GetMapping
    public ResponseEntity get(@PathVariable("pid") Long pid, @PathVariable("id") Long id) {
        TimeSheet timeSheet = timeSheetService.findOne(id);
        return timeSheet != null ? 
                new ResponseEntity<>(timeSheet, HttpStatus.OK) : 
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @PutMapping
    public ResponseEntity update(@PathVariable("pid") Long pid, @PathVariable("id") Long id, TimeSheet timeSheet) {
        TimeSheet updateTimeSheet = timeSheetService.update(id, timeSheet);
        
        return updateTimeSheet != null ? 
                new ResponseEntity<>(updateTimeSheet, HttpStatus.OK) : 
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @DeleteMapping
    public ResponseEntity deleteTimeSheet(@PathVariable("pid") Long pid, @PathVariable("id") Long id) {
        return timeSheetService.deleteOne(id) ? 
                new ResponseEntity(HttpStatus.OK) : 
                new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
