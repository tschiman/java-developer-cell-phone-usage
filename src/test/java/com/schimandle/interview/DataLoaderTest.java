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

}