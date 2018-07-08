package com.kaka.jtest.openutils.poi.usermodel;

import com.kaka.jtest.openutils.dataobject.ErrorDevice;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author shuangkaijia
 */
public class APP {

    /**
     * 得到需要恢复的id
     *
     * @throws Exception
     */
    @Test
    public void readRecoverDeviceId() throws Exception {
        File file = new File("F:\\日常工作\\五码\\所有脏数据\\07-03\\7_五码脏数据分析.xls");
        Workbook workbook = ExcelUtil.getWorkbook(new FileInputStream(file), file.getName());
        Sheet sheet = workbook.getSheetAt(0);
        int lastNum = sheet.getLastRowNum();

        StringBuilder stringBuilder = new StringBuilder();
        int num = 0;
        for (int i = 0; i <= lastNum; i++) {
            ErrorDevice errorDevice = new ErrorDevice();
            Row row = sheet.getRow(i);
            errorDevice.setTboxDeviceId(ExcelUtil.getCellValue(row.getCell(13)).toString());
            errorDevice.setTboxId(ExcelUtil.getCellValue(row.getCell(17)).toString());
            errorDevice.setIhuDeviceId(ExcelUtil.getCellValue(row.getCell(14)).toString());
            errorDevice.setIhuId(ExcelUtil.getCellValue(row.getCell(18)).toString());
            if (StringUtils.isNotEmpty(errorDevice.getTboxDeviceId()) && StringUtils.isEmpty(errorDevice.getTboxId())) {
                stringBuilder.append(errorDevice.getTboxDeviceId() + ",");
                num++;
            } else if (StringUtils.isNotEmpty(errorDevice.getIhuDeviceId()) && StringUtils.isEmpty(errorDevice.getIhuId())) {
                stringBuilder.append(errorDevice.getIhuDeviceId() + ",");
                num++;
            }
        }
        System.out.println(stringBuilder);
        System.out.println("id个数：" + num);
    }

    /**
     * 筛选出误删的device记录
     *
     * @throws Exception
     */
    @Test
    public void exportDevice() throws Exception {
        String deviceId = "2463869,2647128,2484989,2713212,2091385,2091433,2109730,2259050,2124104,2124141,2485327,2432862,2709982,2485124,2472777,2322264,2711985," +
                "2611418,2613377,2613464.00,2432729,2620855,2620925,2621251,2621262,2621872,2633165,2645407,2642851,2642867,2642869,2642983,2643089,2643135," +
                "2643228,2643263,2643284,2643358,2697126,2643430,2643443,2645426,2645868,2645899,2645908,2645936,2645952,2645965,2645970,2645996,2646132," +
                "2646372,2646565,2646593,2646672,2646675,2408066,2425566,2646914,2651715,2651748,2651750,2651987,2652247,2665450,2681594,2692507,2692638," +
                "2695925,2696539,2698314,2698827,2698828,2698958,2699323,2699371,2711752,2711866,2711952,2713019," +
                "2020494,2073548,2073555,2073557,2432783,2073581,2073590,2073591,2075460,2075474,2075491,2075493,2075518,2083272,2083277,2083279,2358144," +
                "2083305,2169490,2083313,2083322,2083340,2083351,2083358,2307415,2083368,2083371,2083381,2083411,2642874,2083448,2083460,2083470,2091378," +
                "2440702,2091394,2091423,2091443,2091457,2091458,2091470,2091486,2109587,2109592,2109601,2109612,2109616,2109645,2109654,2109686,2109699," +
                "2109701,2109704,2109715,2294924,2228612,2109742,2109750,2109777,2440894,2109788,2109792,2294914,2109815,2109816,2591872,2124117,2124122," +
                "2124124,2294957,2627725,2124209,2656223,2124276,2130516,2138157,2175651,2317986,2138167,2138177,2138179,2138195,2143609,2153699,2280387," +
                "2143742,2203519,2175804,2143759,2332270,2153721,2153717,2153751,2153754,2153755,2153757,2153767,2169501,2153786,2153790,2153795,2583108," +
                "2169525,2169530,2169534,2495994,2322331,2175811,2175814,2280363,2705204,2182102,2197272,2200888,2478603,2276648,2200930,2203501,2712811," +
                "2203512,2203516,2203518,2276643,2280294,2457977,2203551,2276655,2206879,2228613,2705004,2246550,2312833,2259088,2491681,2259098,2404205," +
                "2312811,2332361,2387131,2397215,2621761,2464399,2484995,2591947,2611322,2611355,2611379,2643176,2612798,2643267,2612867,2612947,2717015," +
                "2698196,2613160,2613263,2613374,2613389,2613402,2613417,2613441,2613487,2613516,2620756,2620784,2620962,2620994,2621008,2621033,2621052," +
                "2621053,2621073,2621088,2621099,2621209,2621221,2621225,2408719,2621233,2621254,2621256,2621290,2621793,2621804,2621805,2621807,2621831," +
                "2621843,2621845,2621862,2621879,2632673,2633278,2633281,2633351,2633350,2633357,2633538,2642740,2642743,2642844,2642855,2642857,2645417," +
                "2642860,2642871,2642973,2642981,2643056,2643066,2643069,2643076,2643083,2643088,2643095,2643097,2643101,2643103,2643104,2643131,2643161," +
                "2643171,2643179,2643186,2643191,2643193,2643257,2643258,2643266,2643269,2643270,2643273,2643275,2643276,2643289,2643298,2408204,2643302," +
                "2643307,2643333,2643335,2643337,2643345,2643362,2643364,2643390,2643397,2643423,2643428,2643440,2643445,2643446,2652083,2643453,2645393," +
                "2645400,2645430,2645433,2645434,2645443,2645659,2645671,2645672,2645876,2645887,2645897,2645906,2645928,2645941,2645942,2645978,2645950," +
                "2645973,2645977,2645983,2645991,2646002,2646032,2646100,2646121,2646125,2401624,2646357,2646359,2646370,2646374,2646423,2646433,2646465," +
                "2646483,2646512,2646551,2646553,2646571,2646578,2646589,2646630,2646661,2646687,2646698,2646703,2646704,2646711,2646733,2646766,2646775," +
                "2646779,2646781,2646797,2646800,2646807,2646813,2646892,2646900,2646922,2646932,2646943,2646948,2646980,2647320,2676166,2651415,2651554," +
                "2651596,2651634,2651638,2651713,2651733,2651758,2651759,2651762,2651771,2651776,2651786,2651790,2651798,2651799,2651807,2651810,2651814," +
                "2651851,2651859,2651868,2651873,2651889,2651892,2651895,2651905,2307409,2651922,2652036,2652050,2652070,2652092,2699165,2652111,2652116," +
                "2652131,2652157,2652158,2652161,2652168,2652215,2652272,2652276,2652290,2652522,2652584,2652741,2652818,2661178,2663039,2664019,2692338," +
                "2665820,2665858,2666009,2669840,2677265,2678507,2680098,2681469,2681478,2681487,2681621,2698772,2681657,2681937,2681939,2692158,2692792," +
                "2692845,2693029,2693450,2693468,2696954,2693667,2693711,2693751,2693802,2693889,2695808,2695834,2695933,2695945,2696026,2696126,2696470," +
                "2696594,2698191,2698193,2698198,2698223,2698251,2698253,2698302,2698769,2698777,2698789,2698792,2698799,2698800,2698804,2698822,2698863," +
                "2698883,2698929,2698942,2699032,2699284,2699297,2699341,2699363,2711671,2711672,2711864,2711678,2711682,2711685,2711692,2711710,2711712," +
                "2711713,2711895,2712159,2711732,2711735,2711741,2711744,2711749,2711782,2711792,2711859,2711914,2711936,2712039,2712148,2712281,2712363," +
                "2712382,2712393,2712408,2712419,2712421,2712426,2713191,2717053,2717063,2717069,2717074,2717099,2717129,2717140,2621790,2632825";
        List<String> deviceIds = Arrays.asList(deviceId.split(","));
        System.out.println(deviceIds.size());

        File file = new File("F:\\日常工作\\五码\\所有脏数据\\07-03\\误删记录\\删除device_7（37）.xlsx");
        Workbook workbook = ExcelUtil.getWorkbook(new FileInputStream(file), file.getName());
        Sheet sheet = workbook.getSheetAt(0);
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            Cell cell = row.getCell(0);
            String Id = ExcelUtil.getCellValue(cell).toString();
            if (!deviceIds.contains(Id)) {
                sheet.removeRow(row);
            }
        }

        FileOutputStream out = new FileOutputStream("F:\\日常工作\\test2.xlsx");  //向d://test.xls中写数据
        out.flush();
        workbook.write(out);
        out.close();
    }

    /**
     * 筛选出误删的tbox
     */
    @Test
    public void exportIhuTbox() throws Exception {
        File file = new File("F:\\日常工作\\五码\\所有脏数据\\07-03\\误删记录\\误删的device.xlsx");
        Workbook workbook = ExcelUtil.getWorkbook(new FileInputStream(file), file.getName());
        Sheet sheet = workbook.getSheetAt(0);
        List<String> ecarxIds = new ArrayList<>();
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            Cell cell = row.getCell(14);
            String ecarxId = ExcelUtil.getCellValue(cell).toString();
            ecarxIds.add(ecarxId);
        }
        System.out.println("device个数：" + ecarxIds.size());

        File tboxFile = new File("F:\\日常工作\\五码\\所有脏数据\\07-03\\误删记录\\删除tbox_6（245）.xlsx");
        Workbook workbookTbox = ExcelUtil.getWorkbook(new FileInputStream(tboxFile), tboxFile.getName());
        Sheet sheetTbox = workbookTbox.getSheetAt(0);
        for (int i = 1; i <= sheetTbox.getLastRowNum(); i++) {
            Row row = sheetTbox.getRow(i);
            Cell cell = row.getCell(1);
            String tboxId = ExcelUtil.getCellValue(cell).toString();
            if (!ecarxIds.contains(tboxId)) {
                sheetTbox.removeRow(row);
            }
        }
        FileOutputStream out = new FileOutputStream("F:\\日常工作\\test.xlsx");  //向d://test.xls中写数据
        out.flush();
        workbookTbox.write(out);
        out.close();
    }

    /**
     * 筛选出误删的ihu
     */
    @Test
    public void exportIhu() throws Exception {
        File file = new File("F:\\日常工作\\五码\\所有脏数据\\07-03\\误删记录\\误删的device.xlsx");
        Workbook workbook = ExcelUtil.getWorkbook(new FileInputStream(file), file.getName());
        Sheet sheet = workbook.getSheetAt(0);
        List<String> ecarxIds = new ArrayList<>();
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            Cell cell = row.getCell(14);
            String ecarxId = ExcelUtil.getCellValue(cell).toString();
            ecarxIds.add(ecarxId);
        }
        System.out.println("device个数：" + ecarxIds.size());

        File tboxFile = new File("F:\\日常工作\\五码\\所有脏数据\\07-03\\误删记录\\删除ihu_7（37）.xlsx");
        Workbook workbookTbox = ExcelUtil.getWorkbook(new FileInputStream(tboxFile), tboxFile.getName());
        Sheet sheetTbox = workbookTbox.getSheetAt(0);
        for (int i = 1; i <= sheetTbox.getLastRowNum(); i++) {
            Row row = sheetTbox.getRow(i);
            Cell cell = row.getCell(1);
            String tboxId = ExcelUtil.getCellValue(cell).toString();
            if (!ecarxIds.contains(tboxId)) {
                sheetTbox.removeRow(row);
            }
        }
        FileOutputStream out = new FileOutputStream("F:\\日常工作\\test.xlsx");  //向d://test.xls中写数据
        out.flush();
        workbookTbox.write(out);
        out.close();
    }
}
