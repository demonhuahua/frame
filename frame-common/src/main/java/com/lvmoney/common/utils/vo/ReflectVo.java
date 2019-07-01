/**
 * 描述:
 * 包名:com.lvmoney.pay.vo
 * 版本信息: 版本1.0
 * 日期:2018年10月10日  上午9:20:55
 * Copyright xxxx科技有限公司
 */

package com.lvmoney.common.utils.vo;

import java.io.Serializable;


/**
 * @param <T>
 * @describe：
 * @author: lvmoney /xxxx科技有限公司
 * @version:v1.0 2018年10月10日 上午9:20:55
 */

public class ReflectVo<T> implements Serializable {
    /**
     *
     */

    private static final long serialVersionUID = -1227970331171560494L;
    /**
     * 实体
     */
    private T t;
    /**
     * 拼接字段
     */
    private String content;
    /**
     * 是否需要URLENCODE
     */
    private boolean urlEncode;

    public boolean isUrlEncode() {
        return urlEncode;
    }

    public void setUrlEncode(boolean urlEncode) {
        this.urlEncode = urlEncode;
    }

    public boolean isKeyToUpper() {
        return keyToUpper;
    }

    public void setKeyToUpper(boolean keyToUpper) {
        this.keyToUpper = keyToUpper;
    }

    /**
     * 是否需要将Key转换为全大写 * true:key转化成大写，false:不转化
     */
    private boolean keyToUpper;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
