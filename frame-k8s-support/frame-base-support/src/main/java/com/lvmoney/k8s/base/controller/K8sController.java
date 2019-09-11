package com.lvmoney.k8s.base.controller;/**
 * 描述:
 * 包名:com.lvmoney.k8s.base.controller
 * 版本信息: 版本1.0
 * 日期:2019/8/17
 * Copyright XXXXXX科技有限公司
 */

import com.lvmoney.k8s.base.service.K8sService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import io.fabric8.kubernetes.api.model.NamespaceList;
import io.fabric8.kubernetes.api.model.NodeList;

/**
 * @describe：
 * @author: lvmoney/XXXXXX科技有限公司
 * @version:v1.0 2019/8/17 10:06
 */
@RestController
@RequestMapping(value = "/test")
public class K8sController {
    @Autowired
    K8sService devK8sApiService;

//    //k8s api init
//    @RequestMapping(value = "/init", method = RequestMethod.GET)
//    public String initK8s() {
//        return devK8sApiService.init();
//    }

    /**
     * @describe: k8s namespace list
     * @param: []
     * @return: io.fabric8.kubernetes.api.model.NamespaceList
     * @author: lvmoney /XXXXXX科技有限公司
     * 2019/9/9 10:15
     */
    @RequestMapping(value = "/listnamespace", method = RequestMethod.GET)
    public NamespaceList listk8snamespace() {
        return devK8sApiService.listNamespace();
    }

    /**
     *@describe: k8s node list
     *@param: []
     *@return: io.fabric8.kubernetes.api.model.NodeList
     *@author: lvmoney /XXXXXX科技有限公司
     *2019/9/9 10:19
     */
    @RequestMapping(value = "/listnode", method = RequestMethod.GET)
    public NodeList listk8snode() {
        return devK8sApiService.listNode();
    }
}
