package com.lvmoney.oauth2.center.server.db.dao;/**
 * 描述:
 * 包名:com.lvmoney.oauth2.center.server.db.dao
 * 版本信息: 版本1.0
 * 日期:2019/8/7
 * Copyright XXXXXX科技有限公司
 */


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lvmoney.oauth2.center.server.db.entity.UserRole;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @describe：
 * @author: lvmoney/XXXXXX科技有限公司
 * @version:v1.0 2019/8/7 10:14
 */
public interface UserRoleDao extends BaseMapper<UserRole> {
    /**
     * @describe: 通过用户id获得用户的权限
     * @param: [userId]
     * @return: java.util.List<com.lvmoney.oauth2.center.server.db.entity.UserRole>
     * @author: lvmoney /XXXXXX科技有限公司
     * 2019/8/7 10:15
     */
    @Select("select a.code,c.username from role as a inner join user_role as b on a.role_id=b.role_id and a.valid=1 and b.valid=1  inner join user_account as c on b.user_id=c.user_accid and c.valid=1 where c.user_accid=#{userId}")
    List<UserRole> findRoleByUserId(String userId);
}
