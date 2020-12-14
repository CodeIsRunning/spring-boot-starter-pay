package org.pay.boot.dto.req;

import org.springframework.lang.NonNull;

/**
 * @author liuxf
 * @version 1.0
 * @date 2020/11/23 10:31
 * 当面付简易下单请求参数
 */
public class AliPayEasyTradePayReq {

    /**
     * 商户订单号
     */


    private String outTradeNo;


    /**
     * 订单金额 单位元
     */
    private String amount;

    /**
     * 授权码
     */
    private String authCode;

    /**
     * 订单标题
     */
    private String subject;


    /**
     * 商品描述
     */
    private String body;

    /**
     * 超时设置
     */
    private String timeOut;

    public String getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(String timeOut) {
        this.timeOut = timeOut;
    }

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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "AliPayEasyTradePayReq{" +
                "outTradeNo='" + outTradeNo + '\'' +
                ", amount='" + amount + '\'' +
                ", authCode='" + authCode + '\'' +
                ", subject='" + subject + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
