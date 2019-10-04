package com.schimandle.interview;

import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.Assert.assertNotNull;

public class PhoneUsageTest {

    @Test
    public void testBuildPhoneUsage() {
        String record = "1905,10/9/2017,29,0.02";
        String[] recordParts = record.split(",");

        PhoneUsage phoneUsage = new PhoneUsage(
            Integer.parseInt(recordParts[0]),
            LocalDate.parse(recordParts[1], DateTimeFormatter.ofPattern("MM/d/yyyy")),
            Integer.parseInt(recordParts[2]),
            new BigDecimal(recordParts[3])
        );

        assertNotNull(phoneUsage);
    }

}