package com.schimandle.interview;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PhoneUsage {
    int employeeId;
    LocalDate date;
    int minutes;
    BigDecimal data;

    public PhoneUsage(int employeeId, LocalDate date, int minutes, BigDecimal data) {
        this.employeeId = employeeId;
        this.date = date;
        this.minutes = minutes;
        this.data = data;
    }
}
