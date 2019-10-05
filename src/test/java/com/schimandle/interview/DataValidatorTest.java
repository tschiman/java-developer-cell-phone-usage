package com.schimandle.interview;

import org.junit.Test;

import java.io.IOException;

public class DataValidatorTest {

    //exception thrown fails test
    @Test
    public void testValidation() throws IOException {
        DataLoader dataLoader = new DataLoader();
        DataValidator.validate(dataLoader.loadCellPhoneData(), dataLoader.loadCellPhoneUsage());
    }

}