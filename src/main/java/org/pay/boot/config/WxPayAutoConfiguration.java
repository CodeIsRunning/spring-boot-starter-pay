package org.pay.boot.config;

import org.pay.boot.core.wx.WXPay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author liuxf
 * @version 1.0
 * @date 2020/11/17 15:22
 */
@Configuration
@EnableConfigurationProperties(PayLoadConfig.class)
@ConditionalOnProperty(value = "spring.pay.wx", havingValue = "true")
public class WxPayAutoConfiguration {

    @Autowired
    private IWxPayConfig iWxPayConfig;

    @Autowired
    private PayLoadConfig payLoadConfig;

    @Bean
    @ConditionalOnMissingBean(IWxPayConfig.class)
    public IWxPayConfig getWxConfigTradeService() throws Exception {


        return new IWxPayConfig("wxinfo.properties",payLoadConfig.isWxCer());
    }

    @Bean
    @ConditionalOnMissingBean(WXPay.class)
    public WXPay getWxpayTradeService() throws Exception {

        if (payLoadConfig.isWxSandbox()) {
            return new WXPay(iWxPayConfig, true, true);
        }
        return new WXPay(iWxPayConfig);
    }


}
