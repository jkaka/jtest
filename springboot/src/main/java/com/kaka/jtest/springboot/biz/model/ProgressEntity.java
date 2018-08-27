package com.kaka.jtest.springboot.biz.model;

/**
 * @author jsk
 * @Date 2018/8/27 15:53
 */
public class ProgressEntity {
    /**
     * 到目前为止读取文件的字节数
     */
    private long pBytesRead = 0L;
    /**
     * 文件总字节数
     */
    private long pContentLength = 0L;
    /**
     * 目前正在读取第几个文件
     */
    private int pItems;

    public long getpBytesRead() {
        return pBytesRead;
    }

    public void setpBytesRead(long pBytesRead) {
        this.pBytesRead = pBytesRead;
    }

    public long getpContentLength() {
        return pContentLength;
    }

    public void setpContentLength(long pContentLength) {
        this.pContentLength = pContentLength;
    }

    public int getpItems() {
        return pItems;
    }

    public void setpItems(int pItems) {
        this.pItems = pItems;
    }

    @Override
    public String toString() {
        return "ProgressEntity{" +
                "pBytesRead=" + pBytesRead +
                ", pContentLength=" + pContentLength +
                ", pItems=" + pItems +
                '}';
    }
}
