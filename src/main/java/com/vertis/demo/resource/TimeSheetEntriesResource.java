/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vertis.demo.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author telfealr
 */
@RestController
@RequestMapping("/api/person/{pid:[\\d]+}/time-sheet/{id:[\\d]+}/entries")
public class TimeSheetEntriesResource {
    
}
