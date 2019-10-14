package com.kaka.common.base;

import lombok.Data;

/**
 * @author jsk
 * @Date 2018/12/14 11:28
 */
@Data
public class PageResult<T> extends BaseResult<T> {
    /**
     * 页大小
     */
    private Integer pageSize = 20;
    /**
     * 当前页码 (从1开始)
     */
    private Integer currentPage = 1;
    /**
     * 总页数
     */
    private Integer totalPageCount = 0;
    /**
     * 记录总数
     */
    private Integer record = 0;
    /**
     * 首页页码
     */
    private Integer firstPage;
    /**
     * 前一页页码
     */
    private Integer prePage;
    /**
     * 下一页页码
     */
    private Integer nextPage;
    /**
     * 尾页页码
     */
    private Integer lastPage;
    private Integer startCount;
    private Integer endCount;
    private boolean firstPageStatus;
    private boolean lastPageStatus;

    public PageResult() {

    }

    public PageResult(int currentPage, int pageSize, int record, T data) {
        this.wrapPageResult(currentPage, pageSize, record, data);
    }

    //总页数
    public void setTotalPageCount() {
        int totalP = record % getPageSize() == 0 ? record / getPageSize() :
                record / getPageSize() + 1;
        this.totalPageCount = totalP;
    }


    /**
     * 总记录数
     *
     * @param record
     */
    public void setRecord(Integer record) {
        this.record = record;
        //设置总页数
        setTotalPageCount();
    }

    public void wrapPageResult(int currentPage, int pageSize, int record, T data) {
        if (record == 0) {
            return;
        }
        this.record = record;
        super.setData(data);
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.startCount = (currentPage - 1) * pageSize;
        this.endCount = currentPage * pageSize;

        // 设置总页数
        this.totalPageCount = (record - 1) / pageSize + 1;

        // 设置首页
        this.firstPage = 1;
        // 设置尾页
        this.lastPage = totalPageCount;

        // 判断是否是首页
        if (currentPage <= 1) {
            this.currentPage = 1;
            this.prePage = 1;
            this.firstPageStatus = true;
        } else {
            this.firstPageStatus = false;
            this.prePage = this.currentPage - 1;
        }

        // 判断是否为尾页
        if (this.currentPage < totalPageCount) {
            this.nextPage = this.currentPage + 1;
            this.lastPageStatus = false;
        } else {
            this.nextPage = totalPageCount;
            this.lastPageStatus = true;
        }
    }
}
