/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vertis.demo.resource;

import com.vertis.demo.domain.TimeSheet;
import com.vertis.demo.service.TimeSheetService;
import java.util.Collections;
import java.util.List;
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
@RequestMapping("/api/time-sheets")
public class TimeSheetsResource {
    @Autowired
    private TimeSheetService timeSheetService;
    
    @GetMapping
    public ResponseEntity<List<TimeSheet>> get(@PathVariable("id") Long id) {
        return new ResponseEntity<List<TimeSheet>>(timeSheetService.find(id), HttpStatus.OK);
    }
}
