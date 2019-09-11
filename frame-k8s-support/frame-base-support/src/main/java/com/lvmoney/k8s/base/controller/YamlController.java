package com.lvmoney.k8s.base.controller;/**
 * 描述:
 * 包名:com.lvmoney.k8s.base.controller
 * 版本信息: 版本1.0
 * 日期:2019/8/19
 * Copyright XXXXXX科技有限公司
 */


import com.lvmoney.k8s.base.service.YamlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @describe：
 * @author: lvmoney/XXXXXX科技有限公司
 * @version:v1.0 2019/8/19 14:12
 */
@RestController
@RequestMapping(value = "/yaml")
public class YamlController {
    @Autowired
    YamlService yamlService;

    @GetMapping(value = "/iDeploy")
    public void createDeploy() {
        yamlService.createDeploy();
    }

    @GetMapping(value = "/iGateway")
    public void createGateway() {
        yamlService.createGateway();
    }

}
