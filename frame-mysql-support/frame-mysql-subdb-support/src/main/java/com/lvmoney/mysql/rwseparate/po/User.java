package com.lvmoney.mysql.rwseparate.po;/**
 * 描述:
 * 包名:com.lvmoney.mysql.subdb.po
 * 版本信息: 版本1.0
 * 日期:2019/9/10
 * Copyright XXXXXX科技有限公司
 */


import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.util.Date;


/**
 * @describe：
 * @author: lvmoney/XXXXXX科技有限公司
 * @version:v1.0 2019/9/10 15:29
 */
@Data
public class User extends Model<User> {
    private Long id;
    private String name;
    private String phone;
    private String email;
    private String password;
    private Integer cityId;
    private Date createTime;
    private Integer sex;
}
