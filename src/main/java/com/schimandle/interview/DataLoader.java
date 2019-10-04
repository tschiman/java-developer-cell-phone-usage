package com.schimandle.interview;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class DataLoader {

     List<CellPhone> loadCellPhoneData() throws IOException {
        //get the phone data
        File file = new File(this.getClass().getClassLoader().getResource("CellPhone.csv").getFile());
        List<String> lines = FileUtils.readLines(file, Charset.defaultCharset());

        List<CellPhone> cellPhoneData = new ArrayList<>();

         for (int i = 1; i < lines.size(); i++) {
             String[] recordParts = lines.get(i).split(",");

             CellPhone cellPhone = new CellPhone(
                 Integer.parseInt(recordParts[0]),
                 recordParts[1],
                 LocalDate.parse(recordParts[2], DateTimeFormatter.ofPattern("yyyyMMdd")),
                 recordParts[3]);

             cellPhoneData.add(cellPhone);
         }

        return cellPhoneData;
    }
}
