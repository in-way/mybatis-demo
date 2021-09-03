package com.batis.demo.constant;

/**
 * Common constant
 * Created by dell on 2015/10/9.
 */
public class CommonConstant {

    /**
     * 系统异常邮件订阅
     */
    public static String SYSTEM_EXCEPTION_SUBSCRIBE = "AarnW@gscso.com";


    public static final String DEFAULT_CHARSET = "UTF-8";
    public static final String TEXT_HTML_UTF8 = "text/html;charset=" + DEFAULT_CHARSET;
    public static final String TEXT_PLAIN_UTF8 = "text/plain;charset=" + DEFAULT_CHARSET;

    public static final String COMMA = ",";
    public static final String SEMICOLON = ";";
    public static final String DOT = ".";
    public static final String EQUAL = "=";
    public static final String DOUBLE_QUOTE = "\"";

    /** 记录已删除 */
    public static final int RECORD_DELETED = 1;
    /** 记录未删除 */
    public static final int RECORD_NOT_DELETE = 0;

    /**
     * COS 公开资源
     */
    public static final String QCLOUD_FOLDER_LOGO = "/logo/";
    public static final String QCLOUD_FOLDER_AD = "/other/";
    public static final String QCLOUD_FOLDER_CMS = "/cms/";
    public static final String QCLOUD_FOLDER_IMAGE = "/images/";
    public static final String QCLOUD_FOLDER_AVATAR = "/avatar/"; //头像
    public static final String QCLOUD_FOLDER_TOPIC = "/topic/"; // 文章

    /**
     * COS 内部资源
     */
    public static final String QCLOUD_FOLDER_MATERIAL = "/material/";
    public static final String QCLOUD_FOLDER_PDA_LOG = "/pda-log/";

    /**
     * COS 半公开资源
     */
    public static final String QCLOUD_FOLDER_ATTACHMENT = "/attachment/";
    public static final String QCLOUD_FOLDER_WORK_ORDER = "/work-order/";
    public static final String QCLOUD_FOLDER_REFUND = "/refund/";
    public static final String QCLOUD_FOLDER_GROUPON = "/groupon/";
    public static final String QCLOUD_FOLDER_BIDDING_APPLICATION = "/bidding-application/";

    public static final String QCLOUD_FOLDER_WITHHOLD = "/withhold/";   //扣款
    public static final String QCLOUD_FOLDER_PREPAY = "/prepay/";   //预付款

    public static final String QCLOUD_FOLDER_LOG_DRIVER = "/log-driver/";   //司机证件
    public static final String QCLOUD_FOLDER_FINANCE = "/finance/";   //财务凭证
    public static final String QCLOUD_FOLDER_RECEIPT = "/receipt/";   //单据

    public static final String QCLOUD_FOLDER_LOG_ORDER = "/log-order/";   //运单
    public static final String QCLOUD_FOLDER_WECHAT = "/wechat/";   //微信签单
    public static final String QCLOUD_FOLDER_DISPUTE = "/dispute/"; //纠纷
    public static final String QCLOUD_FOLDER_ORDER = "/order/";
    public static final String QCLOUD_FOLDER_VOUCHER = "/voucher/";   //凭证

    public static final String QCLOUD_BUCKET_NAME_IMAGES = "images";
    public static final String QCLOUD_BUCKET_NAME_PRIVATE = "private";
    public static final String QCLOUD_BUCKET_NAME_TEMP = "temp";

    public static final String VERIFY_CODE_PREFIX="verifyCodePrefix_";

}
