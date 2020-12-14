package org.pay.boot.dto.res;

import com.alipay.api.response.AlipayTradePayResponse;
import org.pay.boot.core.ali.model.TradeStatus;

/**
 * @author liuxf
 * @version 1.0
 * @date 2020/11/23 10:42
 * 支付宝简易当面付请求付款响应
 */
public class AliPayEasyTradePayRes {

    /**
     * 响应状态
     */
    private TradeStatus tradeStatus;

    /**
     * 商户订单号
     */
    private String outTradeNo;

    /**
     * 支付宝订单号
     */
    private String tradeNo;


    /**
     * 用户id
     */
    private String userId;

    /**
     * 用户登录id
     */
    private String logonId;

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public TradeStatus getTradeStatus() {
        return tradeStatus;
    }

    public void setTradeStatus(TradeStatus tradeStatus) {
        this.tradeStatus = tradeStatus;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLogonId() {
        return logonId;
    }

    public void setLogonId(String logonId) {
        this.logonId = logonId;
    }

    @Override
    public String toString() {
        return "AliPayEasyTradePayRes{" +
                "tradeStatus=" + tradeStatus +
                ", outTradeNo='" + outTradeNo + '\'' +
                ", tradeNo='" + tradeNo + '\'' +
                ", userId='" + userId + '\'' +
                ", logonId='" + logonId + '\'' +
                '}';
    }
}
