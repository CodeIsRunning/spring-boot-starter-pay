package org.pay.boot.dto.req;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * @author liuxf
 * @version 1.0
 * @date 2020/11/24 8:53
 * 微信条码支付 刷码付款参数
 */
public class WxPayEasyPayReq {

    /**
     * 商户订单号
     */
    @Expose
    @SerializedName("out_trade_no")
    private String outTradeNo;

    /**
     * 订单金额元
     */
    @Expose
    @SerializedName("total_fee")
    private String amount;

    /**
     * 授权码
     */
    @Expose
    @SerializedName("auth_code")
    private String authCode;


    /**
     * 订单描述
     */
    @Expose
    @SerializedName("body")
    private String body;


    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "WxPayEasyPayReq{" +
                "outTradeNo='" + outTradeNo + '\'' +
                ", amount='" + amount + '\'' +
                ", authCode='" + authCode + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
