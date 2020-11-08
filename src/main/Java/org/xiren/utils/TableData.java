package org.xiren.utils;

import java.util.List;

/**
 * @author xiren
 * @version 1.0
 * @date 2020/11/3 14:07
 */
public class TableData<T> {

    /**
     * 页面索引
     */
    private Integer pageIndex;

    /**
     * 页面数据条数
     */
    private Integer pageSize;

    /**
     * 总页数
     */
    private Integer pageCount;

    /**
     * 总数据条数
     */
    private Integer dataCount;

    /**
     * 数据列表
     */
    private List<T> dataList;

    public TableData(PageDate pd) {
        /** 后端输出数据初始化接收前端传参*/
        this.pageIndex = pd.getPageIndex();
        this.pageSize = pd.getPageSize();
    }

    public TableData(Integer pageIndex, Integer pageSize, Integer pageCount, Integer dataCount, List<T> dataList, PageDate pd) {
        this.pageIndex = pd.getPageIndex();
        this.pageSize = pd.getPageSize();
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        this.pageCount = pageCount;
        this.dataCount = dataCount;
        this.dataList = dataList;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public Integer getDataCount() {
        return dataCount;
    }

    public void setDataCount(Integer dataCount) {
        int pc = 0;
        if (dataCount > 0) {
            pc = (dataCount % pageSize == 0) ? (dataCount / pageSize) : (dataCount / pageSize + 1);
        }
        this.pageCount = pc;
        this.dataCount = dataCount;
    }

    public List<T> getDataList() {
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }

    @Override
    public String toString() {
        return "TableData{" +
                "pageIndex=" + pageIndex +
                ", pageSize=" + pageSize +
                ", pageCount=" + pageCount +
                ", dataCount=" + dataCount +
                ", dataList=" + dataList +
                '}';
    }
}
