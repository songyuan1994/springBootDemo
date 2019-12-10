package com.example.demo.model;

import javax.validation.constraints.NotNull;

public class CreateMallMerchantParam {

    /**
     * 商城对应供应商id
     */
    @NotNull(message = "subId不能为空")
    private Long subId;

    /**
     * 供应商名称
     */
    @NotNull(message = "merchantName不能为空")
    private String merchantName;

    /**
     * 供应商账号
     */
    @NotNull(message = "merchantMobile不能为空")
    private String merchantMobile;

    /**
     * 供应商客服数量
     */
    private Integer  supportUserCount = 1;


    public Integer getSupportUserCount() {
        return supportUserCount;
    }

    public void setSupportUserCount(Integer supportUserCount) {
        this.supportUserCount = supportUserCount;
    }

    public Long getSubId() {
        return subId;
    }

    public void setSubId(Long subId) {
        this.subId = subId;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getMerchantMobile() {
        return merchantMobile;
    }

    public void setMerchantMobile(String merchantMobile) {
        this.merchantMobile = merchantMobile;
    }
}
