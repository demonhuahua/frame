package com.lvmoney.captcha.vo;/**
 * 描述:
 * 包名:com.lvmoney.jwt.annotation
 * 版本信息: 版本1.0
 * 日期:2019/2/12
 * Copyright xxxx科技有限公司
 */


import lombok.Data;

import java.awt.image.BufferedImage;
import java.io.Serializable;

/**
 * @describe：
 * @author: lvmoney /xxxx科技有限公司
 * @version:v1.0 2018年10月30日 下午3:29:38
 */
@Data
public class ValidateCodeVo implements Serializable {
    private String value;
    private BufferedImage bufferedImage;
}
