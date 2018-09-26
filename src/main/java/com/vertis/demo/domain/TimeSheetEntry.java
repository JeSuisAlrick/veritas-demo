/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vertis.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.vertis.demo.deserializer.TimeSheetDeserializer;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author telfealr
 */
@Entity
@Table(name = "_TIME_SHEET_ENTRY")
public class TimeSheetEntry extends DomainObject {
    @Column(name = "PERIOD_DATE")
    private LocalDate periodDate;
    
    @Column(name = "PERIOD_START")
    private LocalTime periodStart;
    
    @Column(name = "PERIOD_END")
    private LocalTime periodEnd;
    
    @Column(name = "COMMENT")
    private String comment;
    
    @ManyToOne
    @JsonIgnoreProperties({"entries"})
    private TimeSheet timeSheet;

    public LocalDate getPeriodDate() {
        return periodDate;
    }

    public void setPeriodDate(LocalDate periodDate) {
        this.periodDate = periodDate;
    }

    public LocalTime getPeriodStart() {
        return periodStart;
    }

    public void setPeriodStart(LocalTime periodStart) {
        this.periodStart = periodStart;
    }

    public LocalTime getPeriodEnd() {
        return periodEnd;
    }

    public void setPeriodEnd(LocalTime periodEnd) {
        this.periodEnd = periodEnd;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public TimeSheet getTimeSheet() {
        return timeSheet;
    }

    @JsonDeserialize(using = TimeSheetDeserializer.class)
    public void setTimeSheet(TimeSheet timeSheet) {
        this.timeSheet = timeSheet;
    }
    
}
