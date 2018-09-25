/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vertis.demo.repository;

import com.vertis.demo.domain.TimeSheet;
import com.vertis.demo.domain.TimeSheetEntry;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author telfealr
 */
@Repository
public interface TimeSheetEntryRepository extends JpaRepository<TimeSheetEntry, Long> {
    List<TimeSheetEntry> findByTimeSheet_Id(Long timeSheetId);
    TimeSheetEntry findByIdAndTimeSheet_Id(Long timeSheetId, Long entryId);
    TimeSheetEntry deleteByIdAndTimeSheet_Id(Long timeSheetId, Long entryId);
}
