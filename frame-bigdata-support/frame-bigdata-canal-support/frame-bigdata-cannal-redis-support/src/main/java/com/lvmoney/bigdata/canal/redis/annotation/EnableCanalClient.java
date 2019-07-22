package com.lvmoney.bigdata.canal.redis.annotation;
/**
 * 描述:
 * 包名:com.lvmoney.common.config
 * 版本信息: 版本1.0
 * 日期:2019/2/28
 * Copyright xxxx科技有限公司
 */

import com.lvmoney.bigdata.canal.redis.config.CanalClientConfig;
import com.lvmoney.bigdata.canal.redis.properties.CanalProp;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @describe：通过注解开启canal客户端
 * @author: lvmoney/xxxx科技有限公司
 * @version:v1.0 2019/2/28 10:05
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import({CanalProp.class, CanalClientConfig.class})
public @interface EnableCanalClient {
}