package org.pay.boot.utils;

import java.math.BigDecimal;

/**
 * @author liuxf
 * @version 1.0
 * @date 2020/11/18 10:20
 */
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
