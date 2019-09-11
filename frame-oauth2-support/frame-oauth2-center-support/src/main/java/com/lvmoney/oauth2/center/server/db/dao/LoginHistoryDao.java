package com.lvmoney.oauth2.center.server.db.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lvmoney.oauth2.center.server.db.entity.LoginHistory;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @describe：
 * @author: lvmoney /xxxx科技有限公司
 * @version:v1.0 2018年9月30日 上午8:51:33
 */
public interface LoginHistoryDao extends BaseMapper<LoginHistory> {
    /**
     * 分页获得历史数据
     *
     * @param username: 用户名
     * @param page:     分页信息
     * @throws
     * @return: java.util.List<com.lvmoney.oauth2.center.server.db.entity.LoginHistory>
     * @author: lvmoney /XXXXXX科技有限公司
     * @date: 2019/9/9 20:51
     */
    List<LoginHistory> findByUsername(String username, Page<LoginHistory> page);


}
