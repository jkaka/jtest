package com.kaka.jtest.openutils.poi.usermodel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;

public class WorkbookTest {

    /**
     * 得到单元格中的值
     * @throws Exception
     */
    @Test
    public void getValue() throws Exception {
        File file = new File("E:\\test.xlsx");
        Workbook workbook = ExcelUtil.getWorkbook(new FileInputStream(file), file.getName());
        Sheet sheet = workbook.getSheetAt(0);
        Row row = sheet.getRow(0);
        Cell cell = row.getCell(0);
        System.out.println(ExcelUtil.getCellValue(cell));
    }

}
