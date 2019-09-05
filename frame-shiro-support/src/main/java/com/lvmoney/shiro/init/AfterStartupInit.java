package com.lvmoney.shiro.init;/**
 * 描述:
 * 包名:com.lvmoney.jwt.annotation
 * 版本信息: 版本1.0
 * 日期:2019/2/22
 * Copyright xxxx科技有限公司
 */


import com.lvmoney.shiro.annotations.ShiroResouce;
import com.lvmoney.shiro.ro.ShiroServerRo;
import com.lvmoney.shiro.service.ShiroRedisService;
import com.lvmoney.shiro.vo.SysServiceDataVo;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.condition.PatternsRequestCondition;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @describe：
 * @author: lvmoney /xxxx科技有限公司
 * @version:v1.0 2018年10月30日 下午3:29:38
 */
@Service
public class AfterStartupInit implements InitializingBean {
    @Autowired
    private RequestMappingHandlerMapping requestMappingHandlerMapping;
    @Autowired
    ShiroRedisService shiroRedisService;
    @Value("${spring.application.name}")
    private String serverName;

    @Override
    public void afterPropertiesSet() throws Exception {
        List<SysServiceDataVo> shiroServerData = new ArrayList<SysServiceDataVo>();
        Map<RequestMappingInfo, HandlerMethod> map = requestMappingHandlerMapping.getHandlerMethods();
        for (Map.Entry<RequestMappingInfo, HandlerMethod> m : map.entrySet()) {
            SysServiceDataVo sysServiceDataVo = new SysServiceDataVo();
            RequestMappingInfo info = m.getKey();
            HandlerMethod handlerMethod = m.getValue();
            PatternsRequestCondition p = info.getPatternsCondition();
            for (String url : p.getPatterns()) {
                sysServiceDataVo.setUri(url);
            }
            Method method = handlerMethod.getMethod();
            if (method.isAnnotationPresent(ShiroResouce.class)) {
                ShiroResouce shiroResouce = method.getAnnotation(ShiroResouce.class);
                sysServiceDataVo.setDescrption(shiroResouce.descrption());
            }
            shiroServerData.add(sysServiceDataVo);
        }
        ShiroServerRo shiroServerRo = new ShiroServerRo();
        Map<String, List<SysServiceDataVo>> data = new HashMap() {{
            put(serverName, shiroServerData);
        }};
        shiroServerRo.setData(data);
        shiroRedisService.deleteShiroServerData(serverName);
        shiroRedisService.saveShiroServerData(shiroServerRo);
    }


}
