package com.batis.demo.controller;


import com.batis.demo.annoation.GbpsRest;
import com.batis.demo.entity.OrderForm;
import com.batis.demo.entity.PointsProduct;
import com.batis.demo.entity.page.TableDataInfo;
import com.batis.demo.service.IOrderFormService;
import com.batis.demo.service.IPointsProductService;
import com.gbps.webex.entity.GbpsResponseCode;
import com.gbps.webex.exception.GbpsBusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 积分商品表 前端控制器
 * </p>
 *
 * @author ivy
 * @since 2021-09-02
 */
@RestController
@RequestMapping("/test/points-product")
@GbpsRest
public class PointsProductController extends BaseController {
    @Autowired
    IPointsProductService pointsProductService;
    @Autowired
    IOrderFormService orderFormService;
    /**
     * 统一报文测试和解密测试
     * @author ivy
     * @date 2021/9/3 11:28
     * []
     * java.util.List<com.batis.demo.entity.PointsProduct>
     */
    @RequestMapping("/list")
    public List<PointsProduct> test(){
        List<PointsProduct> pointsProducts = pointsProductService.mySelectList();
        return pointsProducts;
    }

    /**
     * 新增添加基础信息加密和添加基础信息
     * @author ivy
     * @date 2021/9/3 11:28
     * []
     * int
     */
    @RequestMapping("/add")
    public int add(){
        PointsProduct pointsProduct = new PointsProduct();
        pointsProduct.setProductImage("aaaa");
        int add = pointsProductService.add(pointsProduct);
        return add;
    }
    @RequestMapping("/getOne")
    public PointsProduct getOne(){
        PointsProduct one = pointsProductService.getOne();
        return one;
    }
    /**
     * 分页列表
     * @author ivy
     * @date 2021/9/2 11:54
     * [pointsProduct]
     * com.batis.demo.entity.page.TableDataInfo
     */
    @GetMapping("/page")
    public TableDataInfo genList(PointsProduct pointsProduct) {
        startPage();
        List<PointsProduct> list = pointsProductService.mySelectList();
        return getDataTable(list);
    }

    /**
     * 异常统一处理
     * @author ivy
     * @date 2021/9/2 18:30
     * [pointsProduct]
     * com.batis.demo.entity.page.TableDataInfo
     */
    @GetMapping("/exception")
    public TableDataInfo exception(PointsProduct pointsProduct) {
//        throw new NullPointerException();
        throw new GbpsBusinessException(GbpsResponseCode.BIZ_ILLEGAL.getCode(), "获取用户信息异常");
    }
}
