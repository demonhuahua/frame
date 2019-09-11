package com.lvmoney.k8s.seata.server.service.impl;

import com.lvmoney.k8s.seata.server.dao.AccountDao;
import com.lvmoney.k8s.seata.server.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @describe：
 * @author: lvmoney /xxxx科技有限公司
 * @version:v1.0 2018年9月30日 上午8:51:33
 */
@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountDao accountDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateAccount(String userid) {
        return accountDao.updateAccount(userid);
    }


}
