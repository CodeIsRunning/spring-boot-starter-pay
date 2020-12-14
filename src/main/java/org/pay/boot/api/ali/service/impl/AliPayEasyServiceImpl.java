package org.pay.boot.api.ali.service.impl;

import com.alipay.api.response.AlipayTradePayResponse;
import com.alipay.api.response.AlipayTradeQueryResponse;
import org.apache.commons.lang3.StringUtils;
import org.pay.boot.api.ali.service.AliPayEasyService;
import org.pay.boot.core.ali.model.builder.AlipayTradePayRequestBuilder;
import org.pay.boot.core.ali.model.builder.AlipayTradePrecreateRequestBuilder;
import org.pay.boot.core.ali.model.builder.AlipayTradeQueryRequestBuilder;
import org.pay.boot.core.ali.model.result.AlipayF2FPayResult;
import org.pay.boot.core.ali.model.result.AlipayF2FPrecreateResult;
import org.pay.boot.core.ali.model.result.AlipayF2FQueryResult;
import org.pay.boot.core.ali.service.AlipayTradeService;
import org.pay.boot.dto.req.AliPayEasyQrReq;
import org.pay.boot.dto.req.AliPayEasyQueryReq;
import org.pay.boot.dto.req.AliPayEasyTradePayReq;
import org.pay.boot.dto.res.AliPayEasyQrRes;
import org.pay.boot.dto.res.AliPayEasyQueryRes;
import org.pay.boot.dto.res.AliPayEasyTradePayRes;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author liuxf
 * @version 1.0
 * @date 2020/11/23 10:50
 */
@Service
public class AliPayEasyServiceImpl implements AliPayEasyService {

    @Resource
    AlipayTradeService alipayTradeService;

    @Override
    public AliPayEasyTradePayRes aliPayEasyTradePay(AliPayEasyTradePayReq aliPayEasyTradePayReq) {

        AlipayTradePayRequestBuilder payRequestBuilder = new AlipayTradePayRequestBuilder();
        payRequestBuilder.setAuthCode(aliPayEasyTradePayReq.getAuthCode()).setTotalAmount(aliPayEasyTradePayReq.getAmount())
                .setSubject(aliPayEasyTradePayReq.getSubject()).setBody(aliPayEasyTradePayReq.getBody()).setOutTradeNo(aliPayEasyTradePayReq.getOutTradeNo());

        if (StringUtils.isNotBlank(aliPayEasyTradePayReq.getTimeOut())) {
            payRequestBuilder.setTimeoutExpress(aliPayEasyTradePayReq.getTimeOut());
        }

        AlipayF2FPayResult f2FPayResult = alipayTradeService.tradePay(payRequestBuilder);

        AliPayEasyTradePayRes aliPayEasyTradePayRes = new AliPayEasyTradePayRes();

        AlipayTradePayResponse response = f2FPayResult.getResponse();

        aliPayEasyTradePayRes.setOutTradeNo(aliPayEasyTradePayReq.getOutTradeNo());

        aliPayEasyTradePayRes.setTradeStatus(f2FPayResult.getTradeStatus());


        if (f2FPayResult.isTradeSuccess()) {
            aliPayEasyTradePayRes.setTradeNo(response.getTradeNo());
            aliPayEasyTradePayRes.setLogonId(response.getBuyerLogonId());
            aliPayEasyTradePayRes.setUserId(response.getBuyerUserId());
        }


        return aliPayEasyTradePayRes;
    }

    @Override
    public AliPayEasyQrRes aliPayEasyQr(AliPayEasyQrReq easyQrReq) {

        AlipayTradePrecreateRequestBuilder builder = new AlipayTradePrecreateRequestBuilder();

        builder.setOutTradeNo(easyQrReq.getOutTradeNo()).setSubject(easyQrReq.getSubject())
                .setTotalAmount(easyQrReq.getAmount()).setNotifyUrl(easyQrReq.getNotifyUrl())
                .setBody(easyQrReq.getBody());

        if (StringUtils.isNotBlank(easyQrReq.getTimeOut())) {
            builder.setTimeoutExpress(easyQrReq.getTimeOut());
        }

        AlipayF2FPrecreateResult result = alipayTradeService.tradePrecreate(builder);

        AliPayEasyQrRes qrRes = new AliPayEasyQrRes();

        qrRes.setOutTradeNo(easyQrReq.getOutTradeNo());
        qrRes.setTradeStatus(result.getTradeStatus());
        if (result.isTradeSuccess()) {
            qrRes.setQrCode(result.getResponse().getQrCode());
        }

        return qrRes;
    }

    @Override
    public AliPayEasyQueryRes aliPayEasyQuery(AliPayEasyQueryReq aliPayEasyQueryReq) {

        AlipayTradeQueryRequestBuilder builder = new AlipayTradeQueryRequestBuilder();

        if (StringUtils.isNotBlank(aliPayEasyQueryReq.getOutTradeNo())) {
            builder.setOutTradeNo(aliPayEasyQueryReq.getOutTradeNo());
        }
        if (StringUtils.isNotBlank(aliPayEasyQueryReq.getOrderNo())) {
            builder.setTradeNo(aliPayEasyQueryReq.getOrderNo());
        }

        AlipayF2FQueryResult queryResult = alipayTradeService.queryTradeResult(builder);

        AliPayEasyQueryRes res = new AliPayEasyQueryRes();

        res.setTradeStatus(queryResult.getTradeStatus());

        AlipayTradeQueryResponse alipayTradeQueryResponse = queryResult.getResponse();

        if (alipayTradeQueryResponse != null && alipayTradeQueryResponse.getTradeStatus() != null) {
            res.setMsg(alipayTradeQueryResponse.getSubMsg());
        }

        res.setTradeQueryResponse(alipayTradeQueryResponse);

        return res;
    }
}
