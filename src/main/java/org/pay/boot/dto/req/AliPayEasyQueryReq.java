package org.pay.boot.dto.req;

/**
 * @author liuxf
 * @version 1.0
 * @date 2020/11/23 16:17
 * 查单参数
 */
public class AliPayEasyQueryReq {


    /**
     * 商户订单号
     */
    private String outTradeNo;

    /**
     * 支付宝订单号
     */
    private String orderNo;

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    @Override
    public String toString() {
        return "AliPayEasyQueryReq{" +
                "outTradeNo='" + outTradeNo + '\'' +
                ", orderNo='" + orderNo + '\'' +
                '}';
    }
}
