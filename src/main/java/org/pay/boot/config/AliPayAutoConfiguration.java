package org.pay.boot.config;

import org.pay.boot.core.ali.config.Configs;
import org.pay.boot.core.ali.service.AlipayTradeService;
import org.pay.boot.core.ali.service.impl.AlipayTradeServiceImpl;
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
@ConditionalOnProperty(value = "spring.pay.ali", havingValue = "true")
public class AliPayAutoConfiguration {


    @Bean
    @ConditionalOnMissingBean(AlipayTradeService.class)
    public AlipayTradeService getAlipayTradeService() {
        Configs.init("zfbinfo.properties");
        return new AlipayTradeServiceImpl.ClientBuilder().build();
    }

}
