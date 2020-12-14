package org.pay.boot.dto.build;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * @author liuxf
 * @version 1.0
 * @date 2020/11/24 9:11
 */
public class WxPayEasyResBuild {

    @Expose
    @SerializedName("return_code")
    private String returnCode;

    @Expose
    @SerializedName("return_msg")
    private String returnMsg;
    @Expose
    @SerializedName("result_code")
    private String resultCode;

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnMsg() {
        return returnMsg;
    }

    public void setReturnMsg(String returnMsg) {
        this.returnMsg = returnMsg;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }



}
