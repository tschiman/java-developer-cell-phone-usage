package com.schimandle.interview;

import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.Assert.assertNotNull;

public class CellPhoneTest {

    @Test
    public void test() {
        String record = "1903,Stevie Griffin,20150101,Samsung Galaxy 6";

        String[] recordParts = record.split(",");

        CellPhone cellPhone = new CellPhone(
            Integer.parseInt(recordParts[0]),
            recordParts[1],
            LocalDate.parse(recordParts[2], DateTimeFormatter.ofPattern("yyyyMMdd")),
            recordParts[3]);

       assertNotNull(cellPhone);
    }

}