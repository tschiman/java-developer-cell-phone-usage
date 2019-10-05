package com.schimandle.interview;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DataValidator {
    public static void validate(List<CellPhone> cellPhones, List<PhoneUsage> phoneUsages) {
        Map<Integer, List<CellPhone>> employeeIdToPhone = cellPhones.stream().collect(Collectors.groupingBy(c -> c.employeeId));
        Map<Integer, List<PhoneUsage>> employeeIdToUsage = phoneUsages.stream().collect(Collectors.groupingBy(u -> u.employeeId));

        if (employeeIdToPhone.keySet().size() != employeeIdToUsage.keySet().size()) {
            throw new RuntimeException("Data sets not the same employees");
        }

        boolean allUsageEmpIdsInPhoneEmpIds = employeeIdToPhone.keySet().containsAll(employeeIdToUsage.keySet());
        boolean allPhoneEmpIdsInUsageEmpIds = employeeIdToUsage.keySet().containsAll(employeeIdToPhone.keySet());

        if (!allPhoneEmpIdsInUsageEmpIds || !allUsageEmpIdsInPhoneEmpIds) {
            throw new RuntimeException("There is a mismatch of employee ids between data sets");
        }

    }
}
