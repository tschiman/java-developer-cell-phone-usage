package com.schimandle.interview;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class ReportGeneratorTest {

    @Test
    public void testBuildHeader() throws IOException {
        DataLoader dataLoader = new DataLoader();
        assertEquals("- runDate 2019-10-05 phoneCount: 9 totalMins: 48698 totalData: 997.68 avgMins: 48.698 avgData: 0.99768", ReportGenerator.buildHeader(dataLoader.loadCellPhoneData(), dataLoader.loadCellPhoneUsage()));
    }

    @Test
    public void testBuildRecord() throws IOException {
        DataLoader dataLoader = new DataLoader();
        assertEquals("- + empId: 1903 empName: Stevie Griffin model: Samsung Galaxy 6 purchaseDate: 2015-01-01 **monthly usage** 2017-12 (mins: 429 data: 13.39) 2017-11 (mins: 329 data: 8.46) 2017-10 (mins: 404 data: 8.51) 2017-09 (mins: 329 data: 8.78) 2018-09 (mins: 355 data: 4.46) 2018-08 (mins: 436 data: 11.98) 2018-07 (mins: 379 data: 8.74) 2018-06 (mins: 108 data: 5.48) 2018-05 (mins: 586 data: 10.92) 2018-04 (mins: 653 data: 9.93) 2018-03 (mins: 810 data: 14.74) 2018-02 (mins: 384 data: 3.30) 2018-01 (mins: 649 data: 13.06)", ReportGenerator.buildRecord(dataLoader.loadCellPhoneData().get(0), dataLoader.loadCellPhoneUsage()));
    }

}