package org.pay.boot.dto.req;

/**
 * @author liuxf
 * @version 1.0
 * @date 2020/11/23 13:29
 * 扫码付款获取二维码参数
 */
public class AliPayEasyQrReq {

    /**
     * 商户订单号
     */

    private String outTradeNo;

    /**
     * 订单金额 元
     */
    private String amount;

    /**
     * 订单标题
     */
    private String subject;

    /**
     * 描述
     */
    private String body;

    /**
     * 回调地址
     */
    private String notifyUrl;

    /**
     * 超时
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

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    @Override
    public String toString() {
        return "AliPayEasyQrReq{" +
                "outTradeNo='" + outTradeNo + '\'' +
                ", amount='" + amount + '\'' +
                ", subject='" + subject + '\'' +
                ", body='" + body + '\'' +
                ", notifyUrl='" + notifyUrl + '\'' +
                '}';
    }
}
