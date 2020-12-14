package org.pay.boot.api.ali.service;

import org.pay.boot.dto.req.AliPayEasyQrReq;
import org.pay.boot.dto.req.AliPayEasyQueryReq;
import org.pay.boot.dto.req.AliPayEasyTradePayReq;
import org.pay.boot.dto.res.AliPayEasyQrRes;
import org.pay.boot.dto.res.AliPayEasyQueryRes;
import org.pay.boot.dto.res.AliPayEasyTradePayRes;

/**
 * @author liuxf
 * @version 1.0
 * @date 2020/11/23 10:28
 *
 * 支付宝当面付简易调用api
 *
 */
public interface AliPayEasyService {


    /**
     * 当面付请求付款（刷码付）
     * @param aliPayEasyTradePayReq
     * @return
     */

    AliPayEasyTradePayRes aliPayEasyTradePay(AliPayEasyTradePayReq aliPayEasyTradePayReq);


    /**
     * 当面付获取二维码（扫码付）
     * @param easyQrReq
     * @return
     */
    AliPayEasyQrRes aliPayEasyQr(AliPayEasyQrReq easyQrReq);


    /**
     * 订单查询
     * @param aliPayEasyQueryReq
     * @return
     */
    AliPayEasyQueryRes aliPayEasyQuery(AliPayEasyQueryReq aliPayEasyQueryReq);

}
