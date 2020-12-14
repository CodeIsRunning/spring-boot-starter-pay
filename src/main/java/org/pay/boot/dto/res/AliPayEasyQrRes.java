package org.pay.boot.dto.res;

import org.pay.boot.core.ali.model.TradeStatus;

/**
 * @author liuxf
 * @version 1.0
 * @date 2020/11/23 13:38
 */
public class AliPayEasyQrRes {

    private TradeStatus tradeStatus;

    private String qrCode;

    private String outTradeNo;


    public TradeStatus getTradeStatus() {
        return tradeStatus;
    }

    public void setTradeStatus(TradeStatus tradeStatus) {
        this.tradeStatus = tradeStatus;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    @Override
    public String toString() {
        return "AliPayEasyQrRes{" +
                "tradeStatus=" + tradeStatus +
                ", qrCode='" + qrCode + '\'' +
                ", outTradeNo='" + outTradeNo + '\'' +
                '}';
    }
}
