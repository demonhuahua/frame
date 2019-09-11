package com.lvmoney.k8s.base.service;/**
 * 描述:
 * 包名:com.lvmoney.k8s.base.service
 * 版本信息: 版本1.0
 * 日期:2019/8/19
 * Copyright XXXXXX科技有限公司
 */


import com.lvmoney.k8s.base.vo.jyaml.*;

/**
 * @describe：
 * @author: lvmoney/XXXXXX科技有限公司
 * @version:v1.0 2019/8/19 10:53
 */
public interface YamlService {
    /**
     * 构造service
     *
     * @throws
     * @return: com.lvmoney.k8s.base.vo.jyaml.Service
     * @author: lvmoney /XXXXXX科技有限公司
     * @date: 2019/9/10 9:02
     */
    Service buildService();

    /**
     * 构造Deployment
     *
     * @throws
     * @return: com.lvmoney.k8s.base.vo.jyaml.Deployment
     * @author: lvmoney /XXXXXX科技有限公司
     * @date: 2019/9/10 9:02
     */
    Deployment buildDeployment();

    /**
     * 构造gateway
     *
     * @throws
     * @return: com.lvmoney.k8s.base.vo.jyaml.Gateway
     * @author: lvmoney /XXXXXX科技有限公司
     * @date: 2019/9/10 9:03
     */
    Gateway buildGateway();

    /**
     * 构造VirtualService
     *
     * @throws
     * @return: com.lvmoney.k8s.base.vo.jyaml.VirtualService
     * @author: lvmoney /XXXXXX科技有限公司
     * @date: 2019/9/10 9:03
     */
    VirtualService buildVirtualService();

    /**
     * 构造DestinationRule
     *
     * @throws
     * @return: com.lvmoney.k8s.base.vo.jyaml.DestinationRule
     * @author: lvmoney /XXXXXX科技有限公司
     * @date: 2019/9/10 9:03
     */
    DestinationRule buildDestinationRule();

    /**
     * 构造发布服务的yaml
     *
     * @throws
     * @return: void
     * @author: lvmoney /XXXXXX科技有限公司
     * @date: 2019/9/10 9:03
     */
    void createDeploy();

    /**
     * 构造发布服务可通过www.服务名.com访问的ingress等
     *
     * @throws
     * @return: void
     * @author: lvmoney /XXXXXX科技有限公司
     * @date: 2019/9/10 9:04
     */
    void createGateway();

}
