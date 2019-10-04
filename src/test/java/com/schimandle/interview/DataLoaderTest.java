package com.schimandle.interview;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class DataLoaderTest {

    @Test
    public void testLoadCellPhoneData() throws IOException {
        DataLoader dataLoader = new DataLoader();
        assertEquals(9, dataLoader.loadCellPhoneData().size());
    }

    @Test
    public void testLoadUsage() throws IOException {
        DataLoader dataLoader = new DataLoader();
        assertEquals(1000, dataLoader.loadCellPhoneUsage().size());
    }

}