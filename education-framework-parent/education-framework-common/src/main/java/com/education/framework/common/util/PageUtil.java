package com.education.framework.common.util;

/**
 * 分页工具
 * 
 * @date 2015-07-22 15:41
 * @author v_weilibin
 * 
 */
public class PageUtil {
    // 第几页的数据
    private int pageNum = 1;
    // 每页多少条记录
    private int pageSize;
    // 总共多少条记录
    private int rowCount;
    // 查询数据的时候从第几行开始
    private int rowStart;
    // 总共有多少页
    private int pageCount;
    // 每页的开始页码
    private int beginPageNum;
    // 每页的结束页码
    private int endPageNum;
    // 页面总共的页码数
    private int everyPageNum;
    // 上一页
    private int previousPageNum;
    // 下一页
    private int nextPageNum;

    /**
     * 构造分页
     * 
     * @param pageNumString
     *            客户端传入的页码数,默认为第一页
     * @param pageSizeString
     *            客户端传入的每页记录数，默认为每页10条
     * @param rowCount
     *            总共多少条记录
     * @param everyPageNumString
     *            页面总共的页码数，如果为空，默认为每页面的页码数为5
     */
    public PageUtil(String pageNumString, String pageSizeString, int rowCount, String everyPageNumString) {
        // 根据客户端传入的页码数，如果为空，默认为第一页
        this.pageNum = pageNumString == null ? 1 : (Integer.parseInt(pageNumString) == 0 ? 1 : Integer
                .parseInt(pageNumString));
        // 根据客户端传入的每页记录数，如果为空，默认为每页10条
        this.pageSize = pageSizeString == null ? 10 : (Integer.parseInt(pageSizeString) == 0 ? 10 : Integer
                .parseInt(pageSizeString));
        // 根据客户端传入的页面总共的页码数，如果为空，默认为每页面的页码数为5
        this.everyPageNum = everyPageNumString == null ? 5 : Integer.parseInt(everyPageNumString);
        // 一共有多少条记录
        this.rowCount = rowCount;
        // 当前页码数-1 乘以 每页数量就是 开始数
        this.rowStart = (pageNum - 1) * pageSize;
        // 用总记录数除以每页的记录数，然后向上取整
        this.pageCount = (int) Math.ceil(rowCount * 1.0 / pageSize);
        Integer num = (int) Math.ceil((double) everyPageNum / 2);
        this.beginPageNum = (pageNum - everyPageNum + 1) < 0 ? 1 : (pageNum - everyPageNum + num);
        this.beginPageNum = beginPageNum <= 0 ? 1 : beginPageNum;
        this.beginPageNum = (pageCount - beginPageNum + 1) < everyPageNum ? (pageCount - everyPageNum + 1)
                : beginPageNum;
        this.beginPageNum = beginPageNum <= 0 ? 1 : beginPageNum;

        this.endPageNum = pageNum - everyPageNum + 1 < 0 ? everyPageNum : (pageNum + num - 1);
        this.endPageNum = endPageNum < everyPageNum ? everyPageNum : endPageNum;
        this.endPageNum = endPageNum > pageCount ? pageCount : endPageNum;
        this.endPageNum = endPageNum <= 0 ? 1 : endPageNum;

        this.previousPageNum = pageNum - 1 < 1 ? 1 : pageNum - 1;
        this.nextPageNum = pageNum + 1 > pageCount ? pageCount : pageNum + 1;

    }

    public PageUtil() {

    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getRowCount() {
        return rowCount;
    }

    public void setRowCount(int rowCount) {
        this.rowCount = rowCount;
    }

    public int getRowStart() {
        return rowStart;
    }

    public void setRowStart(int rowStart) {
        this.rowStart = rowStart;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getBeginPageNum() {
        return beginPageNum;
    }

    public void setBeginPageNum(int beginPageNum) {
        this.beginPageNum = beginPageNum;
    }

    public int getEndPageNum() {
        return endPageNum;
    }

    public void setEndPageNum(int endPageNum) {
        this.endPageNum = endPageNum;
    }

    public int getEveryPageNum() {
        return everyPageNum;
    }

    public void setEveryPageNum(int everyPageNum) {
        this.everyPageNum = everyPageNum;
    }

    public int getPreviousPageNum() {
        return previousPageNum;
    }

    public void setPreviousPageNum(int previousPageNum) {
        this.previousPageNum = previousPageNum;
    }

    public int getNextPageNum() {
        return nextPageNum;
    }

    public void setNextPageNum(int nextPageNum) {
        this.nextPageNum = nextPageNum;
    }
}
