package com.schimandle.interview;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ReportGenerator {
    private static String header;
    private static List<String> records = new ArrayList<>();

    public static void buildHeader(List<CellPhone> cellPhones, List<PhoneUsage> phoneUsages) {
        LocalDate runDate = LocalDate.now();
        int phoneCount = cellPhones.size();

        int totalMinutes = phoneUsages.stream().map(u -> u.minutes).mapToInt(m -> m).sum();
        BigDecimal totalData = phoneUsages.stream().map(u -> u.data).reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal averageMinutes = new BigDecimal(totalMinutes).divide(new BigDecimal(phoneUsages.size()));
        BigDecimal averageData = totalData.divide(new BigDecimal(phoneUsages.size()));

        header = String.format("- runDate %s phoneCount: %s totalMins: %s totalData: %s avgMins: %s avgData: %s", runDate, phoneCount, totalMinutes, totalData, averageMinutes, averageData);
        System.out.println(header);
    }

    public static void buildRecord(CellPhone p, List<PhoneUsage> phoneUsages) {
        List<PhoneUsage> empPhoneUsage = phoneUsages.stream().filter(u -> u.employeeId == p.employeeId).collect(Collectors.toList());
        Map<YearMonth, List<PhoneUsage>> monthlyUsage = empPhoneUsage.stream()
            .sorted(Comparator.comparing(u -> u.date))
            .collect(Collectors.groupingBy(u -> YearMonth.from(u.date)));
        StringBuilder stringBuilder = new StringBuilder();
        monthlyUsage.entrySet().forEach(e -> {
            stringBuilder.append(String.format(" %s (mins: %s data: %s)", e.getKey(), e.getValue().stream().mapToInt(u -> u.minutes).sum(), e.getValue().stream().map(u -> u.data).reduce(BigDecimal.ZERO, BigDecimal::add)));
        });
        String record = String.format("- + empId: %s empName: %s model: %s purchaseDate: %s **monthly usage**%s", p.employeeId, p.employeeName, p.model, p.purchaseDate, stringBuilder.toString());
        records.add(record);
        System.out.println(record);
    }
}
