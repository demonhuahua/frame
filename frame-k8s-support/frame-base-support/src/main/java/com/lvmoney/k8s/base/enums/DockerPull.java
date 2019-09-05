package com.lvmoney.k8s.base.enums;/**
 * 描述:
 * 包名:com.lvmoney.k8s.base.enums
 * 版本信息: 版本1.0
 * 日期:2019/8/19
 * Copyright XXXXXX科技有限公司
 */


/**
 * @describe：
 * @author: lvmoney/XXXXXX科技有限公司
 * @version:v1.0 2019/8/19 11:13
 */
public enum DockerPull {
    IfNotPresent("IfNotPresent"),
    Always("Always"),
    Never("Never");

    private String value;

    DockerPull(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}