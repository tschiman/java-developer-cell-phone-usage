package com.schimandle.interview;

import java.time.LocalDate;

public class CellPhone {
    int employeeId;
    String employeeName;
    LocalDate purchaseDate;
    String model;

    public CellPhone(int employeeId, String employeeName, LocalDate purchaseDate, String model) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.purchaseDate = purchaseDate;
        this.model = model;
    }
}
