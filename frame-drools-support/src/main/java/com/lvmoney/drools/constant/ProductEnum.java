/**
 * 描述:
 * 包名:com.lvmoney.hotel.constant
 * 版本信息: 版本1.0
 * 日期:2018年11月23日  上午10:19:07
 * Copyright xxxx科技有限公司
 */

package com.lvmoney.drools.constant;

import com.lvmoney.common.utils.IntervalUtil;

/**
 * @describe：
 * @author: lvmoney /xxxx科技有限公司
 * @version:v1.0 2018年11月23日 上午10:19:07
 */

public enum ProductEnum {
    LEVEL_1("(0,200]", 5), LEVEL_2("[201,300]", 10), LEVEL_3("[301,+∞)", 20);
    private final String key;
    private final double value;

    ProductEnum(String key, double value) {
        this.value = value;
        this.key = key;
    }

    public String getKey() {
        return this.key;
    }

    public double getValue() {
        return this.value;
    }

    /**
     * @param key
     * @return 2018年11月23日上午10:42:57
     * @describe:根据区间获得对应的值
     * @author: lvmoney /xxxx科技有限公司
     */
    public static double getValueByKey(String key) {
        return ProductEnum.getProductEnum(key).getValue();
    }

    /**
     * @param value
     * @return 2018年11月23日上午10:43:13
     * @describe:根据区间里面的值获得对应的值
     * @author: lvmoney /xxxx科技有限公司
     */
    public static double getValueByKey(double value) {
        return ProductEnum.getProductEnum(value).getValue();
    }

    public static void main(String[] args) {
        System.out.println(ProductEnum.getValueByKey(400));
    }

    public static ProductEnum getProductEnum(String key) {
        for (ProductEnum e : ProductEnum.values()) {
            if (e.getKey().equals(key)) {
                return e;
            }
        }
        return null;
    }

    public static ProductEnum getProductEnum(double value) {
        for (ProductEnum e : ProductEnum.values()) {
            String key = e.getKey();
            if (IntervalUtil.isInTheInterval(String.valueOf(value), key)) {
                return e;
            }
        }
        return null;
    }
}
