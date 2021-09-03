package com.batis.demo.controller;


import com.batis.demo.entity.page.PageDomain;
import com.batis.demo.entity.page.TableDataInfo;
import com.batis.demo.entity.page.TableSupport;
import com.batis.demo.util.SqlUtil;
import com.batis.demo.util.StringUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.beans.PropertyEditorSupport;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * web层通用数据处理
 * 
 * @author qingeng
 */
public class BaseController
{
    protected final Logger logger = LoggerFactory.getLogger(BaseController.class);


    /**
     * 设置请求分页数据
     */
    protected void startPage() {
        PageDomain pageDomain = TableSupport.buildPageRequest();
        Integer pageNum = pageDomain.getPageNum();
        Integer pageSize = pageDomain.getPageSize();
        if (StringUtils.isNull(pageNum)) {
            pageNum = 1;
        }
        if (StringUtils.isNull(pageSize)) {
            pageSize = 5;
        }
        String orderBy = SqlUtil.escapeOrderBySql(pageDomain.getOrderBy());
        PageHelper.startPage(pageNum, pageSize, orderBy);
    }

    /**
     * 响应请求分页数据
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    protected TableDataInfo getDataTable(List<?> list)
    {
        PageDomain pageDomain = TableSupport.buildPageRequest();
        Integer pageNo = Optional.ofNullable(pageDomain.getPageNum()).orElse(1);
        Integer pageSize =  Optional.ofNullable(pageDomain.getPageSize()).orElse(5);
        TableDataInfo rspData = new TableDataInfo();
        rspData.setData(list);
        rspData.setTotalCount(new PageInfo(list).getTotal());
        rspData.setPageNo(pageNo);
        rspData.setPageSize(pageSize);
        return rspData;
    }

}
