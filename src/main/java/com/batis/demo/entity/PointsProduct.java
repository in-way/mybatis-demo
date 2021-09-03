package com.batis.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import com.batis.demo.annoation.EncryptedField;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 积分商品表
 * </p>
 *
 * @author ivy
 * @since 2021-09-02
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("POINTS_PRODUCT")
public class PointsProduct extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 积分商品表ID
     */
    @TableId(value = "POINTS_PRODUCT_ID", type = IdType.AUTO)
    private Long pointsProductId;

    /**
     * 商品名称
     */

    @TableField("PRODUCT_NAME")
    private String productName;

    /**
     * 品牌
     */
    @TableField("PRODUCT_BRAND")
    private String productBrand;

    /**
     * 属性
     */
    @TableField("PRODUCT_PROPERTY")
    private String productProperty;

    /**
     * 上下架状态(0下架，1上架)
     */
    @TableField("ON_AND_OFF_SHELVES")
    private Integer onAndOffShelves;

    /**
     * 库存
     */
    @TableField("STOCK")
    private Integer stock;

    /**
     * 对应积分
     */
    @TableField("POINTS")
    private Long points;

    /**
     * 排序
     */
    @TableField("SORT")
    private String sort;

    /**
     * 商品图片
     */
    @EncryptedField
    @TableField("PRODUCT_IMAGE")
    private String productImage;

    /**
     * 商品类型（0：实物，1：购物卡）
     */
    @TableField("TYPE")
    private Integer type;

    /**
     * 商品详情（富文本）
     */
    @TableField("DETAILS")
    private String details;


    /**
     * 商品名称英文
     */
    @TableField("PRODUCT_NAME_EN")
    private String productNameEn;


}
