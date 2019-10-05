package com.schimandle.interview;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Application {
    public static void main(String[] args) throws IOException {

        DataLoader dataLoader = new DataLoader();
        List<CellPhone> cellPhones = dataLoader.loadCellPhoneData();
        List<PhoneUsage> phoneUsages = dataLoader.loadCellPhoneUsage();

        //validate data
        DataValidator.validate(cellPhones, phoneUsages);

        //build header data:
        // run date, #phones, total mins, total data, avg min, avg data
        LocalDate runDate = LocalDate.now();
        int phoneCount = cellPhones.size();

        int totalMinutes = phoneUsages.stream().map(u -> u.minutes).mapToInt(m -> m).sum();
        BigDecimal totalData = phoneUsages.stream().map(u -> u.data).reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal averageMinutes = new BigDecimal(totalMinutes).divide(new BigDecimal(phoneUsages.size()));
        BigDecimal averageData = totalData.divide(new BigDecimal(phoneUsages.size()));

        System.out.println(String.format("- runDate %s phoneCount: %s totalMins: %s totalData: %s avgMins: %s avgData: %s", runDate, phoneCount, totalMinutes, totalData, averageMinutes, averageData));

        //print an employees record

        cellPhones.forEach(p -> {
            System.out.println(String.format("- + empId: %s empName: %s model: %s purchaseDate: %s", p.employeeId, p.employeeName, p.model, p.purchaseDate));
        });
    }
}
