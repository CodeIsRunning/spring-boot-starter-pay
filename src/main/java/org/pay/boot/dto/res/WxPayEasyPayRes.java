package org.pay.boot.dto.res;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.pay.boot.core.ali.model.TradeStatus;
import org.pay.boot.dto.build.WxPayEasyResBuild;
import org.pay.boot.dto.enums.WxTradeStatus;

/**
 * @author liuxf
 * @version 1.0
 * @date 2020/11/24 9:08
 */
public class WxPayEasyPayRes extends WxPayEasyResBuild {


    /**
     *交易状态
     */
    private WxTradeStatus tradeStatus;


    /**
     * 微信订单号
     */
    @Expose
    @SerializedName("transaction_id")
    private String transactionId;

    /**
     * 错误代码
     */
    @SerializedName("error_code")
    private String errCoe;

    /**
     * 错误信息
     */
    @SerializedName("err_code_des")
    private String errCodeDes;

}
