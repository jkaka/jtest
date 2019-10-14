package com.kaka.common.utils.poi;


import org.apache.commons.beanutils.BeanUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author jsk
 * @Date 2018/10/13 17:45
 */
public class ExcelReader {
    private final static String excel2003L = ".xls";    //2003- 版本的excel
    private final static String excel2007U = ".xlsx";   //2007+ 版本的excel

    /**
     * 出输入流中读取出对象
     *
     * @param inputStream
     * @param fileName
     * @param clz
     * @param mapping     "Excel表中的文本值":"对象中的属性值";如："车型名称":"modelName"
     * @param <T>
     * @return
     * @throws Exception
     */
    public static <T> List<T> read2Object(InputStream inputStream, String fileName, Class<T> clz, Map<String, String> mapping) throws Exception {
        //创建Excel工作薄
        Workbook work;
        try {
            work = getWorkbook(inputStream, fileName);
        } catch (Exception e) {
            throw new Exception("解析Excel出错!");
        }
        if (null == work) {
            throw new Exception("Excel文件为空!");
        }
        List<T> beanList = new ArrayList<>();
        Sheet sheet = null;
        Row dataRow = null;

        // 1.遍历Excel中所有的sheet
        for (int i = 0; i < work.getNumberOfSheets(); i++) {
            sheet = work.getSheetAt(i);
            if (sheet == null) {
                continue;
            }
            Row headerRow = sheet.getRow(sheet.getFirstRowNum());

            // 2.遍历当前sheet中的所有行
            for (int j = sheet.getFirstRowNum() + 1; j < sheet.getLastRowNum() + 1; j++) {
                dataRow = sheet.getRow(j);
                T obj = clz.newInstance();
                for (int x = dataRow.getFirstCellNum(); x < dataRow.getLastCellNum(); x++) {
                    for (int y = headerRow.getFirstCellNum(); y < headerRow.getLastCellNum(); y++) {
                        String filedName = getCellValue(headerRow.getCell(y)).toString();
                        if (mapping != null) {
                            filedName = mapping.get(filedName);
                        }
                        Object value = getCellValue(dataRow.getCell(y));
                        BeanUtils.setProperty(obj, filedName, value);
                    }
                }
                beanList.add(obj);
            }
        }
        return beanList;
    }

    /**
     * 根据文件创建workbook
     *
     * @param inputStream
     * @param fileName
     * @return
     * @throws Exception
     */
    private static Workbook getWorkbook(InputStream inputStream, String fileName) throws Exception {
        Workbook wb = null;
        String fileType = fileName.substring(fileName.lastIndexOf("."));
        if (excel2003L.equals(fileType)) {
            wb = new HSSFWorkbook(inputStream);  //2003-
        } else if (excel2007U.equals(fileType)) {
            wb = new XSSFWorkbook(inputStream);  //2007+
        } else {
            throw new Exception("解析的文件格式有误！");
        }
        return wb;
    }

    /**
     * 读取cell中的值
     *
     * @param cell
     * @return
     */
    private static Object getCellValue(Cell cell) {
        Object value = null;
        DecimalFormat df = new DecimalFormat("0");  //格式化number String字符
        SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");  //日期格式化
        DecimalFormat df2 = new DecimalFormat("0.00");  //格式化数字

        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_STRING:
                value = cell.getRichStringCellValue().getString();
                break;
            case Cell.CELL_TYPE_NUMERIC:
                if ("General".equals(cell.getCellStyle().getDataFormatString())) {
                    value = df.format(cell.getNumericCellValue());
                } else if ("m/d/yy".equals(cell.getCellStyle().getDataFormatString())) {
                    // value = sdf.format(cell.getDateCellValue());
                    value = cell.getDateCellValue();
                } else {
                    value = df2.format(cell.getNumericCellValue());
                }
                break;
            case Cell.CELL_TYPE_BOOLEAN:
                value = cell.getBooleanCellValue();
                break;
            case Cell.CELL_TYPE_BLANK:
                value = "";
                break;
            default:
                break;
        }
        return value;
    }

    public static void main(String[] args) throws Exception {
        File file = new File("E:\\workspace\\otherTest/test.xlsx");
//        List<Person> personList = read2Object(file, Person.class);
//        System.out.println(personList);
    }
}
