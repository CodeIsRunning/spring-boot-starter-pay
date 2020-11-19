##  **支付sdk使用手册**



**1、安装sdk到本地maven库**

------

 **2、引入依赖**

```java
        <dependency>
            <groupId>org.pay.boot</groupId>
            <artifactId>spring-boot-starter-pay</artifactId>
            <version>1.0-SNAPSHOT</version>
        </dependency>
```

------

**3、是否启用sdk**

```java
#是否开启支付宝 支付宝沙箱环境只需配置响应的配置文件即可
spring.pay.ali=false
#是否开启微信
spring.pay.wx=true
#是否加载微信证书
spring.pay.wx-cer=true
#是否开启微信沙箱环境
spring.pay.wx-sandbox=true
```

true为启用 false 为不启用 默认不启用，启用响应模块需要在classpath下增加响应配置文件.

支付配置文件 名称为 zfbinfo.properties  微信配置文件为 wxinfo.properties 微信需要把秘钥文件也放入classpath下。

------

**4、配置文件样例**



支付宝配置文件样例 

```
#沙箱环境

# 支付宝网关名、partnerId和appId
open_api_domain = https://openapi.alipay.com/gateway.do
mcloud_api_domain = http://mcloudmonitor.com/gateway.do
pid = ***
appid = ***

# RSA私钥、公钥和支付宝公钥
private_key = ***
public_key = ***

#SHA1withRsa对应支付宝公钥
#alipay_public_key = ***

#SHA256withRsa对应支付宝公钥
alipay_public_key = ***

# 签名类型: RSA->SHA1withRsa,RSA2->SHA256withRsa
sign_type = RSA2
# 当面付最大查询次数和查询间隔（毫秒）
max_query_retry = 5
query_duration = 5000

# 当面付最大撤销次数和撤销间隔（毫秒）
max_cancel_retry = 3
cancel_duration = 2000

# 交易保障线程第一次调度延迟和调度间隔（秒）
heartbeat_delay = 5
heartbeat_duration = 900

```

微信配置样例

```
#appId
appId=***
#秘钥
key=***
#商户号
mchId***
```

------

**5、支付宝使用样例**

支付宝当面付-刷码付款

```java

    @Resource
    AlipayTradeService alipayTradeService;


    @Test
    void aliPayTest(){
        AlipayTradePayRequestBuilder alipayTradePayRequestBuilder = new AlipayTradePayRequestBuilder();
        alipayTradePayRequestBuilder.setAuthCode("");
        alipayTradeService.tradePay(alipayTradePayRequestBuilder);
    }
```

AlipayTradeService 服务支持当面付所有接口

```java
    // 当面付2.0流程支付
    public AlipayF2FPayResult tradePay(AlipayTradePayRequestBuilder builder);

    // 当面付2.0消费查询
    public AlipayF2FQueryResult queryTradeResult(AlipayTradeQueryRequestBuilder builder);

    // 当面付2.0消费退款
    public AlipayF2FRefundResult tradeRefund(AlipayTradeRefundRequestBuilder builder);

    // 当面付2.0预下单(生成二维码)
    public AlipayF2FPrecreateResult tradePrecreate(AlipayTradePrecreateRequestBuilder builder);
```



**6、微信使用样例**

```
 	@Resource
    WXPay wxPay;


    @Test
    void wxPayTest()throws Exception{
        Map<String, String> map = new HashMap();
        map.put("body", "***");
        map.put("out_trade_no", "***");
        map.put("total_fee", "***");
        map.put("auth_code", "***");
        map.put("spbill_create_ip", InetAddress.getLocalHost().getHostAddress());
        Map<String, String> result = wxPay.microPayWithNew(map, 3000);
    }
```

microPayWithNew 30s重试机制

microPayWith 无重试机制

WXPay 服务几乎包含官网所有业务



**7、其他单位转换**

```java
public class PayUtils {

    /**
     * 分转元
     *
     * @param amount
     * @return
     */
    public static String toAmount(long amount) {
        return new BigDecimal(amount).divide(new BigDecimal(100)).toString();
    }

    /**
     * 将单位为元转换为单位为分.
     *
     * @param yuan 将要转换的元的数值字符串
     * @return the Long
     */
    public static Long yuanToFen(String yuan) {
        return new BigDecimal(yuan).setScale(2, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)).longValue();
    }

}
```

**8、目前仅整合原生sdk 包装sdk api正在开发**

