package com.kaka.common.utils.java.io;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jsk
 * @Date 2018/10/13 17:44
 */
public class FileUtil {
    /**
     * 得到该路径下的所有文件名称
     */
    public static List<String> getAllFileName(String path, List<String> allFileName) {
        if (allFileName == null) {
            allFileName = new ArrayList<String>();
        }
        File file = new File(path);
        if (!file.isDirectory()) {
            allFileName.add(file.getName());
            return allFileName;
        } else if (file.isDirectory()) {
            String[] fileList = file.list();
            for (String fileName : fileList) {
                File subFile = new File(path + File.separator + fileName);
                if (!subFile.isDirectory()) {
                    allFileName.add(subFile.getName());
                } else if (subFile.isDirectory()) {
                    getAllFileName(path + File.separator + fileName, allFileName);
                }
            }
            return allFileName;
        }
        return null;
    }

    /**
     * 得到该路径下的所有文件路径
     */
    public static List<String> getAllFilePath(String path, List<String> allFilePath) {
        if (allFilePath == null) {
            allFilePath = new ArrayList<String>();
        }
        File file = new File(path);
        if (!file.isDirectory()) {
            allFilePath.add(path);
            return allFilePath;
        } else if (file.isDirectory()) {
            String[] fileList = file.list();
            for (String fileName : fileList) {
                String subFileName = path + File.separator + fileName;
                File subFile = new File(subFileName);
                if (!subFile.isDirectory()) {
                    allFilePath.add(subFileName);
                } else if (subFile.isDirectory()) {
                    getAllFilePath(subFileName, allFilePath);
                }
            }
            return allFilePath;
        }
        return null;
    }

    /**
     * 得到该路径下的所有文件夹名称
     *
     * @param path
     * @param allFolderName
     * @return
     */
    public static List<String> getAllFolderName(String path, List<String> allFolderName) {
        if (allFolderName == null) {
            allFolderName = new ArrayList<String>();
        }
        File file = new File(path);
        if (!file.isDirectory()) {
            return allFolderName;
        } else if (file.isDirectory()) {
            String[] fileList = file.list();
            for (String fileName : fileList) {
                File subFile = new File(path + File.separator + fileName);
                if (!subFile.isDirectory()) {
                    continue;
                } else if (subFile.isDirectory()) {
                    allFolderName.add(fileName);
                    getAllFolderName(path + File.separator + fileName, allFolderName);
                }
            }
            return allFolderName;
        }
        return null;
    }

    /**
     * 得到该路径下的所有文件夹路径
     *
     * @param path
     * @param allFolderPath
     * @return
     */
    public static List<String> getAllFolderPath(String path, List<String> allFolderPath) {
        if (allFolderPath == null) {
            allFolderPath = new ArrayList<String>();
        }
        File file = new File(path);
        if (!file.isDirectory()) {
            return allFolderPath;
        } else if (file.isDirectory()) {
            String[] fileList = file.list();
            for (String fileName : fileList) {
                String subFilePath = path + File.separator + fileName;
                File subFile = new File(subFilePath);
                if (!subFile.isDirectory()) {
                    continue;
                } else if (subFile.isDirectory()) {
                    allFolderPath.add(subFilePath);
                    getAllFolderPath(subFilePath, allFolderPath);
                }
            }
            return allFolderPath;
        }
        return null;
    }
}
