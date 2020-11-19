package org.pay.boot.config;


import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.pay.boot.core.wx.IWXPayDomain;
import org.pay.boot.core.wx.WXPayConfig;
import org.pay.boot.core.wx.WXPayConstants;
import org.pay.boot.core.wx.WXPayUtil;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.FileCopyUtils;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class IWxPayConfig extends WXPayConfig {

    private static Configuration configs;

    private byte[] certData;


    private String app_id = "";


    private String wx_pay_key = "";


    private String wx_pay_mch_id = "";

    public IWxPayConfig() {
    }

    public IWxPayConfig(String filePath,boolean wxCer) throws Exception {


        if (configs != null) {
            return;
        }

        try {
            configs = new PropertiesConfiguration(filePath);
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }

        if (configs == null) {
            throw new IllegalStateException("can`t find file by path:" + filePath);
        }

        this.app_id=configs.getString("appId");

        this.wx_pay_key=configs.getString("key");
        this.wx_pay_mch_id=configs.getString("mchId");


        if (wxCer){
            // 构造方法读取证书, 通过getCertStream 可以使sdk获取到证书

            ClassPathResource resource = new ClassPathResource("apiclient_cert.p12");
            //获取文件输入流
            InputStream in = resource.getInputStream();

            byte[] bdata = FileCopyUtils.copyToByteArray(in);

            WXPayUtil.getLogger().info(bdata.length+"");

            this.certData = bdata;
        }


    }

    @Override
    public String getAppID() {
        return this.app_id;
    }

    @Override
    public String getMchID() {
        return this.wx_pay_mch_id;
    }

    @Override
    public String getKey() {
        return this.wx_pay_key;
    }

    @Override
    public InputStream getCertStream() {
        return new ByteArrayInputStream(this.certData);
    }

    @Override
    public IWXPayDomain getWXPayDomain() { // 这个方法需要这样实现, 否则无法正常初始化WXPay
        IWXPayDomain iwxPayDomain = new IWXPayDomain() {

            @Override
            public void report(String domain, long elapsedTimeMillis, Exception ex) {

            }


            @Override
            public DomainInfo getDomain(WXPayConfig config) {
                return new IWXPayDomain.DomainInfo(WXPayConstants.DOMAIN_API, true);
            }
        };
        return iwxPayDomain;
    }
}