package org.pay.boot.dto.enums;

/**
 * @author liuxf
 * @version 1.0
 * @date 2020/11/24 9:18
 */
public enum  WxTradeStatus {

    SUCCESS  // 业务交易明确成功，比如支付成功、退货成功

    ,FAILED  // 业务交易明确失败，比如支付明确失败、退货明确失败
    ,NOTFUND
}
