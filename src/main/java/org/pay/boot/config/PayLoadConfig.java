package org.pay.boot.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author liuxf
 * @version 1.0
 * @date 2020/11/17 15:19
 */
@Component
@ConfigurationProperties(prefix = "spring.pay")
public class PayLoadConfig {

    /**
     * 是否开启支付宝
     */
    private boolean ali;

    /**
     * 是否开启微信
     */
    private boolean wx;

    /**
     * 是否开启微信沙箱环境
     */
    private boolean wxSandbox = false;

    /**
     * 是否加载微信证书
     */
    private boolean wxCer = false;


    public boolean isWxCer() {
        return wxCer;
    }

    public void setWxCer(boolean wxCer) {
        this.wxCer = wxCer;
    }

    public boolean isWxSandbox() {
        return wxSandbox;
    }

    public void setWxSandbox(boolean wxSandbox) {
        this.wxSandbox = wxSandbox;
    }

    public boolean isAli() {
        return ali;
    }

    public void setAli(boolean ali) {
        this.ali = ali;
    }

    public boolean isWx() {
        return wx;
    }

    public void setWx(boolean wx) {
        this.wx = wx;
    }
}
