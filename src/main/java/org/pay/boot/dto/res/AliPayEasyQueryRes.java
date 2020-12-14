package org.pay.boot.dto.res;

import com.alipay.api.response.AlipayTradeQueryResponse;
import org.pay.boot.core.ali.model.TradeStatus;

/**
 * @author liuxf
 * @version 1.0
 * @date 2020/11/23 16:20
 * 查询订单返还状态
 */
public class AliPayEasyQueryRes {

    /**
     * 交易状态 TRADE_SUCCESS 查询返回该订单交易支付成功 ，FAILED 该订单号交易失败  UNKNOWN 查询发生异常，交易状态未知 NOTFUND //未发现
     */
    private TradeStatus tradeStatus;


    /**
     * 查单详情
     */
    AlipayTradeQueryResponse tradeQueryResponse;

    /**
     * 响应信息
     */
    private String msg;

    public AlipayTradeQueryResponse getTradeQueryResponse() {
        return tradeQueryResponse;
    }

    public void setTradeQueryResponse(AlipayTradeQueryResponse tradeQueryResponse) {
        this.tradeQueryResponse = tradeQueryResponse;
    }

    public TradeStatus getTradeStatus() {
        return tradeStatus;
    }

    public void setTradeStatus(TradeStatus tradeStatus) {
        this.tradeStatus = tradeStatus;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "AliPayEasyQueryRes{" +
                "tradeStatus=" + tradeStatus +
                ", tradeQueryResponse=" + tradeQueryResponse +
                ", msg='" + msg + '\'' +
                '}';
    }
}
