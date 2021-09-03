package com.batis.demo.entity.page;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 表格分页数据对象
 * 
 * @author qingeng
 */
@Data
public class TableDataInfo implements Serializable
{
    private static final long serialVersionUID = 1L;

    /** 总记录数 */
    private long totalCount;

    /** 列表数据 */
    private List<?> data;

    /** 页码*/
    private long pageNo;

    /** 页码*/
    private long pageSize;
    /**
     * 表格数据对象
     */
    public TableDataInfo()
    {
    }

    /**
     * 分页
     * 
     * @param list 列表数据
     * @param total 总记录数
     */
    public TableDataInfo(List<?> list, int total)
    {
        this.data = list;
        this.totalCount = total;
    }


    public void setTotalCount(long total)
    {
        this.totalCount = total;
    }

}