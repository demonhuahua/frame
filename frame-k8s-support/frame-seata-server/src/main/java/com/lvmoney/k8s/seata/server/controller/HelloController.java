package com.lvmoney.k8s.seata.server.controller;

import com.lvmoney.k8s.seata.server.po.User;
import com.lvmoney.k8s.seata.server.service.AccountService;
import com.lvmoney.k8s.seata.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @describe：
 * @author: lvmoney /xxxx科技有限公司
 * @version:v1.0 2018年9月30日 上午8:51:33
 */
@RestController
public class HelloController {
    @Autowired
    UserService userService;
    @Autowired
    AccountService accountService;

    @RequestMapping("/test")
    public String printDate() {
        return "this is v1";
    }

    @RequestMapping("/save")
    public int save() {
        User user = new User();
        user.setPassword("123");
        user.setUsername("lvmoney");
        return userService.insertUser(user);
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public int update(@PathVariable(value = "id") String id) {
        return accountService.updateAccount(id);
    }

}
