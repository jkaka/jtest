package com.kaka.jtest.openutils.poi.usermodel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;

/**
 * @author shuangkaijia
 */
public class SheetTest {

    /**
     * 得到最后一行索引值：getLastRowNum()
     *
     * @throws Exception
     */
    @Test
    public void getLastRowNum() throws Exception {
        File file = new File("E:\\test.xlsx");
        Workbook workbook = ExcelUtil.getWorkbook(new FileInputStream(file), file.getName());
        Sheet sheet = workbook.getSheetAt(0);
        System.out.println("LastRowNum：" + sheet.getLastRowNum());

        for (int i = 0; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            System.out.println(row.getCell(0).getStringCellValue());
        }
    }
}
