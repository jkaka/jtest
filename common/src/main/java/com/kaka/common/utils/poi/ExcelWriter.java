package com.kaka.common.utils.poi;

import com.kaka.common.model.Person;
import com.kaka.common.utils.LogUtil;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author jsk
 * @Date 2018/11/21 14:51
 */
public class ExcelWriter {
    private final static LogUtil logger = new LogUtil("excel");
    private final static Pattern p = Pattern.compile("^//d+(//.//d+)?$");
    private final static String dateFormat = "yyyy-MM-dd";

    /**
     * 创建workbook
     *
     * @param title
     * @param mapping "Excel表中的文本值":"对象中的属性值";如："车型名称":"modelName"
     * @param data
     * @param pattern
     * @return
     */
    public static <T> Workbook writeWorkbook(String title, Map<String, String> mapping, Collection<T> data, String pattern) {
        // 声明一个工作薄
        HSSFWorkbook workbook = new HSSFWorkbook();
        // 创建一个sheet
        HSSFSheet sheet = workbook.createSheet(title);
        // 设置表格默认列宽度为15个字节
        sheet.setDefaultColumnWidth(15);
        // 生成一个样式
        HSSFCellStyle style = workbook.createCellStyle();
        // 设置这些样式
        style.setFillForegroundColor(HSSFColor.WHITE.index);
        style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        // 生成一个字体
        HSSFFont font = workbook.createFont();
        font.setColor(HSSFColor.BLACK.index);
        font.setFontHeightInPoints((short) 12);
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        // 把字体应用到当前的样式
        style.setFont(font);
        // 生成并设置另一个样式
        HSSFCellStyle style2 = workbook.createCellStyle();
        style2.setFillForegroundColor(HSSFColor.WHITE.index);
        style2.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        style2.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        style2.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        style2.setBorderRight(HSSFCellStyle.BORDER_THIN);
        style2.setBorderTop(HSSFCellStyle.BORDER_THIN);
        style2.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        style2.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        // 生成另一个字体
        HSSFFont font2 = workbook.createFont();
        font2.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
        // 把字体应用到当前的样式
        style2.setFont(font2);
        // 声明一个画图的顶级管理器
        HSSFPatriarch patriarch = sheet.createDrawingPatriarch();
        // 定义注释的大小和位置,详见文档
        HSSFComment comment = patriarch.createComment(new HSSFClientAnchor(0,
                0, 0, 0, (short) 4, 2, (short) 6, 5));
        // 设置注释内容
        comment.setString(new HSSFRichTextString("可以在POI中添加注释！"));
        // 设置注释作者，当鼠标移动到单元格上是可以在状态栏中看到该内容.
        comment.setAuthor("leno");
        // 产生表格标题行
        HSSFRow row = sheet.createRow(0);

        // 1.设置标题
        int i = 0;
        for (String str : mapping.keySet()) {
            HSSFCell cell = row.createCell(i);
            cell.setCellStyle(style);
            HSSFRichTextString text = new HSSFRichTextString(str);
            cell.setCellValue(text);
            i++;
        }

        // 遍历集合数据，产生数据行
        HSSFFont font3 = workbook.createFont();
        font3.setColor(HSSFColor.BLACK.index);
        if(StringUtils.isEmpty(pattern)){
            pattern = dateFormat;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        if(CollectionUtils.isEmpty(data)){
            return workbook;
        }
        Iterator<T> it = data.iterator();
        int rowIndex = 1;
        // 2.遍历集合,根据mapping中的映射关系,展示对象中的属性值
        while (it.hasNext()) {
            row = sheet.createRow(rowIndex);
            T obj = it.next();
            int cellIndex = 0;
            for (String str : mapping.keySet()) {
                HSSFCell cell = row.createCell(cellIndex);
                cell.setCellStyle(style);
                try {
                    Field field = obj.getClass().getDeclaredField(mapping.get(str));
                    field.setAccessible(true);
                    Object value = field.get(obj);
                    // 判断值的类型后进行强制类型转换
                    String textValue = null;
                    if (value instanceof Date) {
                        Date date = (Date) value;
                        textValue = sdf.format(date);
                    } else if (value instanceof byte[]) {
                        // 有图片时，设置行高为60px;
                        row.setHeightInPoints(60);
                        // 设置图片所在列宽度为80px,注意这里单位的一个换算
                        sheet.setColumnWidth(i, (short) (35.7 * 80));
                        byte[] bsValue = (byte[]) value;
                        HSSFClientAnchor anchor = new HSSFClientAnchor(0, 0,
                                1023, 255, (short) cellIndex, rowIndex, (short) cellIndex, rowIndex);
                        anchor.setAnchorType(2);
                        patriarch.createPicture(anchor, workbook.addPicture(
                                bsValue, HSSFWorkbook.PICTURE_TYPE_JPEG));
                    } else {
                        // 其它数据类型都当作字符串简单处理
                        if (value != null) {
                            textValue = value.toString();
                        }
                    }
                    // 如果不是图片数据，就利用正则表达式判断textValue是否全部由数字组成
                    if (textValue != null) {
                        Matcher matcher = p.matcher(textValue);
                        if (matcher.matches()) {
                            // 是数字当作double处理
                            cell.setCellValue(Double.parseDouble(textValue));
                        } else {
                            HSSFRichTextString richString = new HSSFRichTextString(textValue);
                            richString.applyFont(font3);
                            cell.setCellValue(richString);
                        }
                    }
                } catch (NoSuchFieldException e) {
                    logger.error(obj.getClass() + "类中的" + mapping.get(str) + "属性不存在！");
                } catch (IllegalAccessException e) {
                    logger.error("IllegalAccessException:" + e.getMessage());
                }
                cellIndex++;
            }
            rowIndex++;
        }
        return workbook;
    }

    public static void main(String[] args) throws IOException {
        String title = "sheet111";
        Map<String, String> mapping = new LinkedHashMap() {{
            put("ID", "id");
            put("姓名", "name");
            put("年龄", "age");
        }};
        Collection<Person> data = new ArrayList() {{
            add(new Person(2, "AA", 18));
            add(new Person(3, "BB", 17));
            add(new Person(4, "CC", 16));
        }};
        String pattern = dateFormat;
        Workbook wb = writeWorkbook(title, mapping, data, pattern);

        OutputStream outputStream = new FileOutputStream("E:\\workspace\\otherTest\\test.xls");
        wb.write(outputStream);
        outputStream.close();

    }
}
