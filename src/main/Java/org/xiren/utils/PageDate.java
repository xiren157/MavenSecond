package org.xiren.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * @author xiren
 * @version 1.0
 * @date 2020/11/7 14:18
 *
 */
public class PageDate {
    /** 初始化默认每页条数数据*/
    private final static Integer DEFAULT_PAGE_SIZE = 3;
    /** 分页索引*/
    private Integer pageIndex;
    /** 分页大小*/
    private Integer pageSize;
    /** 搜索数据*/
    private String searchData;

    public PageDate() {
    }

    public PageDate(Integer pageIndex, Integer pageSize, String searchData) {
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        this.searchData = searchData;
    }

    public Integer getPageIndex() {
        /** 传参校验*/
        if(this.pageIndex == null || this.pageIndex < 1){
            this.pageIndex = 1;
        }
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        /** 分页大小校验*/
        if(this.pageSize == null || this.pageSize < 1){
            this.pageSize = DEFAULT_PAGE_SIZE;
        }
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public JSONObject getSearchData() {
        if(StringUtils.isNotEmpty(this.searchData)){
            /** 处理异常传参*/
            try {
                JSONObject parse = (JSONObject) JSONObject.parse(this.searchData);
                return parse;
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return null;
    }

    public void setSearchData(String searchData) {
        this.searchData = searchData;
    }

    @Override
    public String toString() {
        return "PageDate{" +
                "pageIndex=" + pageIndex +
                ", pageSize=" + pageSize +
                ", searchData='" + searchData + '\'' +
                '}';
    }
}
