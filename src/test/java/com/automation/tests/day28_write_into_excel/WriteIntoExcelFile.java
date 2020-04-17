package com.automation.tests.day28_write_into_excel;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.LocalDateTime;

public class WriteIntoExcelFile {

    @Test
    public void writeIntoFileTest() throws Exception{

        FileInputStream inputStream=new FileInputStream("VytrackTestUsers.xlsx");
        Workbook workbook= WorkbookFactory.create(inputStream);
        inputStream.close();

        Sheet sheet=workbook.getSheet("QA3-short");
        Row row=sheet.getRow(1);
        Cell cell=row.getCell(5);//get result column
        System.out.println("Before: "+cell.getStringCellValue());
        cell.setCellValue("FAILED"); //i am changing cell value from n/a to passed
        System.out.println("After: "+cell.getStringCellValue());

        Row firstRow=sheet.getRow(0);
        Cell newCell=firstRow.createCell(6);
        newCell.setCellValue("Date of execution");

        Row secondRow=sheet.getRow(1);
        Cell newCell2=secondRow.createCell(6);
        newCell2.setCellValue(LocalDateTime.now().toString());

        //i create it if i wanted to write something into the file
        //dont forget to close your file if you open it
        FileOutputStream outputStream=new FileOutputStream("VytrackTestUsers.xlsx");
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();

        /**
         * Close the underlying input resource (File or Stream),
         *  from which the Workbook was read.
         *
         * <p>Once this has been called, no further
         *  operations, updates or reads should be performed on the
         *  Workbook.
         */
    }
}
