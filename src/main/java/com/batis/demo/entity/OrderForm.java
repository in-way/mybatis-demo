package com.batis.demo.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 订单主表
 * </p>
 *
 * @author jobob
 * @since 2021-09-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("ORDER_FORM")
public class OrderForm implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 订单编号
     */
    @TableId("ORDER_NO")
    private Long orderNo;

    /**
     * 采购单ID
     */
    @TableField("PURCHASE_ORDER_ID")
    private Long purchaseOrderId;

    /**
     * 换货订单的原订单id
     */
    @TableField("ORIGIN_ORDER_NO")
    private Long originOrderNo;

    /**
     * 终端 1:PC, 2:微信, 3:手机
     */
    @TableField("TERMINAL")
    private Integer terminal;

    /**
     * 商品类型， 分类根节点ID：3=原材料，506=五金配件，259=PCB
     */
    @TableField("TYPE")
    private Long type;

    /**
     * 1:团购订单 2：普通订单 3：招投标交易 4：委托采购
     */
    @TableField("ORDER_TYPE")
    private Integer orderType;

    /**
     * 0：退换 1: 换货 2：扣款
     */
    @TableField("DISPUTE_TYPE")
    private Integer disputeType;

    /**
     * 是否需要做物流整合，0：要做物流整合，1：不需要
     */
    @TableField("IS_NEED_TO_CENTRALIZE")
    private Integer isNeedToCentralize;

    /**
     * 销售方所属企业
     */
    @TableField("SUPPLIER_ID")
    private Integer supplierId;

    /**
     * 销售方所属企业名称（减少sql的复杂度）
     */
    @TableField("SUPPLIER_NAME")
    private String supplierName;

    /**
     * 关联供应商ID（实际供应商）
     */
    @TableField("ASSOCIATED_SUPPLIERS_ID")
    private Long associatedSuppliersId;

    /**
     * 关联供应商（实际供应商）
     */
    @TableField("ASSOCIATED_SUPPLIERS_CNNAME")
    private String associatedSuppliersCnname;

    /**
     * 采购方所属企业
     */
    @TableField("PROCURE_ID")
    private Integer procureId;

    /**
     * 采购方所属企业名称（减少sql的复杂度）
     */
    @TableField("PROCURE_NAME")
    private String procureName;

    /**
     * 采购方所属企业中文全称
     */
    @TableField("PROCURE_CN_NAME")
    private String procureCnName;

    /**
     * 采购会员帐号
     */
    @TableField("PROCURE_OPERATOR_ID")
    private Long procureOperatorId;

    /**
     * 付款方式
     */
    @TableField("PAYMENT")
    private Integer payment;

    /**
     * 付款方式  数据字典扩展
     */
    @TableField("PAY_WAY_KEY")
    private String payWayKey;

    /**
     * 收货人
     */
    @TableField("RECEIVER")
    private String receiver;

    /**
     * 收货人固定电话
     */
    @TableField("RECEIVER_PHONE")
    private String receiverPhone;

    /**
     * 收货人座机
     */
    @TableField("RECEIVER_MOBILE")
    private String receiverMobile;

    /**
     * 区域，逗号分隔
     */
    @TableField("RECEIVER_AREA_CODE")
    private String receiverAreaCode;

    /**
     * 收货地址-省市区名称
     */
    @TableField("RECEIVER_AREA_NAME")
    private String receiverAreaName;

    /**
     * 收货地址
     */
    @TableField("RECEIVER_ADDRESS")
    private String receiverAddress;

    /**
     * 邮编
     */
    @TableField("RECEIVER_ZIP_CODE")
    private String receiverZipCode;

    /**
     * 纳税人识别号
     */
    @TableField("TAX_IDENTIFICATION_NUMBER")
    private String taxIdentificationNumber;

    /**
     * 发票抬头
     */
    @TableField("RECIEPT_TITLE")
    private String recieptTitle;

    /**
     * 采购方附近仓库ID
     */
    @TableField("PROCURE_CLOSET_WAREHOUSE_ID")
    private Integer procureClosetWarehouseId;

    /**
     * 采购方附近仓库名称
     */
    @TableField("PROCURE_CLOSET_WAREHOUSE_NAME")
    private String procureClosetWarehouseName;

    /**
     * 销售方附近仓库ID
     */
    @TableField("SUPPLIER_CLOSET_WAREHOUSE_ID")
    private Integer supplierClosetWarehouseId;

    /**
     * 销售方附近仓库名称
     */
    @TableField("SUPPLIER_CLOSET_WAREHOUSE_NAME")
    private String supplierClosetWarehouseName;

    /**
     * 币种
     */
    @TableField("CURRENCY")
    private String currency;

    /**
     * 币种符号
     */
    @TableField("CURRENCY_SIGN")
    private String currencySign;

    /**
     * 下单时汇率,RMB->***
     */
    @TableField("CURRENCY_RATIO")
    private BigDecimal currencyRatio;

    /**
     * 原始金额
     */
    @TableField("INIT_TOTAL")
    private BigDecimal initTotal;

    /**
     * 订单金额, TOTAL = COST+其他费用+额外物流费-优惠券金额-平台折扣
     */
    @TableField("TOTAL")
    private BigDecimal total;

    /**
     * 订单成本,单价(包含信用等级、交易费、物流费)*数量
     */
    @TableField("COST")
    private BigDecimal cost;

    /**
     * 采购成本 含税价(公式值)*数量
     */
    @TableField("PURCHASE_COST")
    private BigDecimal purchaseCost;

    /**
     * 费用明细
     */
    @TableField("PRICES_BREAKDOWN")
    private String pricesBreakdown;

    /**
     * 基础价格费 即含税价；单个商品真正的单价应在PRICES_BREAKDOWN中的BaseLine中
     */
    @TableField("BASE_PRICE")
    private BigDecimal basePrice;

    /**
     * 物流费用
     */
    @TableField("LOGISTICS_FEE")
    private BigDecimal logisticsFee;

    /**
     * 物流附加费
     */
    @TableField("EXTRA_LOGISTICS_FEE")
    private BigDecimal extraLogisticsFee;

    /**
     * 服务费用
     */
    @TableField("SERVICE_FEE")
    private BigDecimal serviceFee;

    /**
     * 供货商成本(出库时进行更新)
     */
    @TableField("PRIME_COST")
    private BigDecimal primeCost;

    /**
     * 预估供货商成本(生成订单时生成)
     */
    @TableField("SUPPLIER_PRICE")
    private BigDecimal supplierPrice;

    /**
     * 企业属性：0=凡谷自营，1=官方旗舰店
     */
    @TableField("SELF_OPERATION")
    private Integer selfOperation;

    /**
     * 下单时间
     */
    @TableField("ORDER_TIME")
    private LocalDateTime orderTime;

    /**
     * 执行时间
     */
    @TableField("EXECUTION_TIME")
    private LocalDateTime executionTime;

    /**
     * 交期
     */
    @TableField("DELIVERY_TIME")
    private LocalDate deliveryTime;

    /**
     * (采购商附近仓库)最晚发货日
     */
    @TableField("LATEST_DELIVERY_DAY")
    private LocalDate latestDeliveryDay;

    /**
     * 订单审核状态：0等待审核员审核 1审核通过-1审核员审核末通过
     */
    @TableField("AUDIT_STATUS")
    private Integer auditStatus;

    /**
     * 1未支付,10待审核,11待执行,20待发货,30待收货,99已完成,-1已取消,-2审核不通过
     */
    @TableField("ORDER_STATUS")
    private Integer orderStatus;

    /**
     * 审核不通过原因
     */
    @TableField("NON_APPROVAL_REASON")
    private String nonApprovalReason;

    /**
     * 评论状态：0未评论，1已评论
     */
    @TableField("COMMENT_STATUS")
    private Integer commentStatus;

    /**
     * 退货换状态：0未申请，1已申请
     */
    @TableField("REFUND_STATUS")
    private Integer refundStatus;

    /**
     * 申请退款状态：0待退款、1退款中、2财务处理中
     */
    @TableField("APPLY_REFUND_STATUS")
    private Integer applyRefundStatus;

    /**
     * 废弃状态：0正常 1废弃
     */
    @TableField("DISCARD_STATUS")
    private Integer discardStatus;

    /**
     * 物流编号：-1末生成物流单号，非负数表示实际物流单号
     */
    @TableField("LOGISTIC_NO")
    private String logisticNo;

    /**
     * 物流公司的名称：顺丰、满载而归、跨越
     */
    @TableField("LOGISTIC_COMPANY")
    private String logisticCompany;

    /**
     * 自提拍照
     */
    @TableField("PICK_UP_CERTIFICATION")
    private String pickUpCertification;

    /**
     * 	备料情况：0 已生成备料单 1等待备料 2 备料完成，可发货
     */
    @TableField("STOCKUP_STATUS")
    private Integer stockupStatus;

    /**
     * 是否需要销售方备料：0GBPS有库存，可立即发货，1GBPS无库存，需要生备料单， 2GBPS总库存充足，但需要从gbps一个仓库调配到地区仓库
     */
    @TableField("NEED_STOCKUP")
    private Integer needStockup;

    /**
     * 备料单号
     */
    @TableField("STOCKUP_NO")
    private Long stockupNo;

    /**
     * 调配单号
     */
    @TableField("DEPLOY_NO")
    private Long deployNo;

    /**
     * 调配数量
     */
    @TableField("DEPLOY_QUANTITY")
    private Integer deployQuantity;

    /**
     * GBPS是否能满足该订单的交期：0不满足1满足
     */
    @TableField("MEET_DELIVERY_TIME_STATUS")
    private Integer meetDeliveryTimeStatus;

    /**
     * 采购商留言
     */
    @TableField("COMMENT")
    private String comment;

    /**
     * 调配状态：0已生成调配单1调配过程中2调配完成，可发货
     */
    @TableField("DEPLOY_STATUS")
    private Integer deployStatus;

    /**
     * 后台提交签收回执
     */
    @TableField("SIGN_RECEIPT")
    private String signReceipt;

    /**
     * 交易员ID
     */
    @TableField("TRADER_ID")
    private Integer traderId;

    /**
     * 交易员名称
     */
    @TableField("TRADER_NAME")
    private String traderName;

    /**
     * 交易员电话
     */
    @TableField("TRADER_TEL")
    private String traderTel;

    /**
     * 客户采购员
     */
    @TableField("CUSTOMER_BUYER")
    private String customerBuyer;

    /**
     * 送货方式：  1 送货上门    2 到仓自提
     */
    @TableField("SHIPPING_TYPE")
    private Integer shippingType;

    /**
     * 仓库编号
     */
    @TableField("WH_WAREHOUSE_ID")
    private Long whWarehouseId;

    /**
     * 仓库名称
     */
    @TableField("WH_WAREHOUSE_NAME")
    private String whWarehouseName;

    /**
     * 仓库员名称
     */
    @TableField("KEEPER")
    private String keeper;

    /**
     * 仓库员联系电话
     */
    @TableField("KEEPER_PHONE")
    private String keeperPhone;

    /**
     * 订单商品预付款百分比（分子）
     */
    @TableField("DEPOSIT_PERCENTAGE")
    private BigDecimal depositPercentage;

    /**
     * 后台运营下单附件
     */
    @TableField("ATTACHMENT")
    private String attachment;

    /**
     * 订单来源（1：前台订单，2：后台订单）
     */
    @TableField("ORDER_SOURCE")
    private Integer orderSource;

    /**
     * 使用的优惠券id
     */
    @TableField("MARKET_COUPON_ID")
    private Long marketCouponId;

    /**
     * 微营销用户ID
     */
    @TableField("DISTRIBUTION_USER_ID")
    private Long distributionUserId;

    /**
     * 销售代表ID
     */
    @TableField("SALES_REPRESENTATIVE_ID")
    private Long salesRepresentativeId;

    /**
     * 订单加急标识,0例行(默认)，1加急
     */
    @TableField("URGENT")
    private Integer urgent;

    /**
     * 最晚调配日
     */
    @TableField("LATEST_DEPLOY_DAY")
    private LocalDate latestDeployDay;

    /**
     *  最晚备料日
     */
    @TableField("LATEST_STOCKUP_DAY")
    private LocalDate latestStockupDay;

    /**
     * 上级审核状态
     */
    @TableField("LEADER_AUDIT")
    private Integer leaderAudit;

    /**
     * 上级审核备注
     */
    @TableField("LEADER_REMARK")
    private String leaderRemark;

    /**
     * 报废状态（0 未报废 1申请报废 -1拒绝报废 2确认报废）
     */
    @TableField("SCRAP_STATUS")
    private Integer scrapStatus;

    /**
     * 订单完成时间
     */
    @TableField("COMPLETE_TIME")
    private LocalDateTime completeTime;

    @TableField("MERCHANT_ID")
    private Long merchantId;

    /**
     * 报告
     */
    @TableField("REPORT")
    private String report;

    @TableField("CREATE_USER")
    private Integer createUser;

    @TableField("CREATE_TIME")
    private LocalDateTime createTime;

    /**
     * 创建者的IP地址
     */
    @TableField("CREATE_IP")
    private String createIp;

    @TableField("CREATE_USER_TYPE")
    private Integer createUserType;

    @TableField("UPDATE_USER")
    private Integer updateUser;

    @TableField("UPDATE_USER_TYPE")
    private Integer updateUserType;

    @TableField("UPDATE_TIME")
    private LocalDateTime updateTime;

    /**
     * 更新者的IP
     */
    @TableField("UPDATE_IP")
    private String updateIp;

    @TableField("DELETED")
    private Integer deleted;


}
