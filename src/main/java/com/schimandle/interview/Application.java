package com.schimandle.interview;

import java.io.IOException;
import java.util.List;

public class Application {
    public static void main(String[] args) throws IOException {

        DataLoader dataLoader = new DataLoader();
        List<CellPhone> cellPhones = dataLoader.loadCellPhoneData();
    }
}
