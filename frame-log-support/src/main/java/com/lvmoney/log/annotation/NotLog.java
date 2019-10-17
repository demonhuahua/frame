/**
 * 描述:
 * 包名:com.lvmoney.jwt.annotation
 * 版本信息: 版本1.0
 * 日期:2019年1月4日  下午2:26:15
 * Copyright xxxx科技有限公司
 */

package com.lvmoney.log.annotation;

import java.lang.annotation.*;

/**
 * @describe：
 * @author: lvmoney /xxxx科技有限公司
 * @version:v1.0 2019年1月4日 下午2:26:15
 */

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface NotLog {
    boolean required() default true;
}
