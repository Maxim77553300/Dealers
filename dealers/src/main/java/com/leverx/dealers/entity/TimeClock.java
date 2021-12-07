package com.leverx.dealers.entity;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Slf4j
@UtilityClass
public class TimeClock {

    private LocalDateTime dateTime;

    public LocalDateTime getCurrentDateTime() {
        return (dateTime == null ? LocalDateTime.now() : dateTime);
    }

    public void setDateTime(LocalDateTime date) {
        log.info("Set current date for application to: {}", date);
        TimeClock.dateTime = date;
    }

    public void resetDateTime() {
        log.info("Reset date for the application");
        TimeClock.dateTime = LocalDateTime.now();
    }

    /**
     * Different formats for current dateTime.
     */
    public LocalDate getCurrentDate() {
        return getCurrentDateTime().toLocalDate();
    }

    public LocalTime getCurrentTime() {
        return getCurrentDateTime().toLocalTime();
    }
}